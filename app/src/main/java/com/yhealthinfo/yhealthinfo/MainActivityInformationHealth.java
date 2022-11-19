package com.yhealthinfo.yhealthinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yhealthinfo.yhealthinfo.model.format.BiotypeFormat;
import com.yhealthinfo.yhealthinfo.model.format.FatPercentFormat;
import com.yhealthinfo.yhealthinfo.model.format.ImcFormat;
import com.yhealthinfo.yhealthinfo.model.entity.Biotype;
import com.yhealthinfo.yhealthinfo.model.entity.ConvertPerson;
import com.yhealthinfo.yhealthinfo.model.entity.Person;
import com.yhealthinfo.yhealthinfo.model.service.ImcService;
import com.yhealthinfo.yhealthinfo.model.service.PercentFatMenService;
import com.yhealthinfo.yhealthinfo.model.service.PercentFatWomamService;

public class MainActivityInformationHealth extends AppCompatActivity {

    TextView name;
    TextView age;
    TextView heigth;
    TextView weight;
    TextView fatPercentage;
    TextView biotype;
    TextView imc;
    TextView imcStatus;
    TextView statusPercent;
    Bundle params;
    Button more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_health);
        captureValue();
        Intent intent = getIntent();

        if (intent != null){
            params = intent.getExtras();
            if (params != null){
                String name = params.getString(("name"));
                String age = params.getString(("age"));
                String heigth = params.getString(("heigth"));
                String weight = params.getString(("weight"));
                String fatPercentage = params.getString(("fatPercentage"));
                String biotype = params.getString(("biotype"));

                Person person = ConvertPerson.convertStringPerson(name, age, heigth, weight, fatPercentage, biotype);
                convertTextedit(name, age, heigth, weight, fatPercentage, biotype);
                double imcValue = ImcService.imcCalc(person);
                imc.setText(ImcFormat.imcFormat(imcValue));
                imcStatus.setText(ImcFormat.imcStatusFormat(ImcService.imcStatus(imcValue)));
                if (person.getBiotype() == Biotype.men) {
                    statusPercent.setText(FatPercentFormat.fatPercentFormat(new PercentFatMenService().analyzeFatPercentage(person)));
                }else{
                    statusPercent.setText(FatPercentFormat.fatPercentFormat(new PercentFatWomamService().analyzeFatPercentage(person)));
                }

                more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivityInformationHealth.this, MainActivityMore.class);
                        startActivity(intent);
                        //Toast.makeText(getApplicationContext(), "Teste", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }

    }

    private void captureValue(){
        name = (TextView) findViewById(R.id.nameWiew);
        heigth = (TextView) findViewById(R.id.heigthWiew);
        weight = (TextView) findViewById(R.id.weightWiew);
        age = (TextView) findViewById(R.id.ageWiew);
        fatPercentage = (TextView) findViewById(R.id.fatPercentWiew);
        biotype = (TextView) findViewById(R.id.biotypeWiew);
        imc = (TextView) findViewById(R.id.imcWiew);
        imcStatus = (TextView) findViewById(R.id.statusImc);
        statusPercent = (TextView) findViewById(R.id.statusFatPercent);
        more = (Button) findViewById(R.id.more);
    }

    private void convertTextedit(String nameS, String ageS, String heigthS, String weightS, String fatPercentageS, String biotypeS ){
        name.setText(nameS);
        age.setText(ageS);
        heigth.setText(heigthS);
        weight.setText(weightS);
        fatPercentage.setText(fatPercentageS);
        biotype.setText(BiotypeFormat.biotypeFormatString(biotypeS));
    }
}
