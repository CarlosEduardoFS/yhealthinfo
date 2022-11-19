package com.yhealthinfo.yhealthinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yhealthinfo.yhealthinfo.model.entity.Biotype;
import com.yhealthinfo.yhealthinfo.model.entity.ConvertPerson;
import com.yhealthinfo.yhealthinfo.model.entity.Person;
import com.yhealthinfo.yhealthinfo.model.service.ImcService;
import com.yhealthinfo.yhealthinfo.model.service.PercentFatMenService;
import com.yhealthinfo.yhealthinfo.model.service.PercentFatWomamService;
import com.yhealthinfo.yhealthinfo.model.service.ennumS.FatStatus;
import com.yhealthinfo.yhealthinfo.model.service.interfaceS.PercentFatService;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView age;
    TextView heigth;
    TextView weight;
    TextView fatPercentage;
    RadioGroup biotype;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        buttunOnClick();
    }

    private Person buttunOnClick(){
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureValue();
                Person person = ConvertPerson.convertPerson(name, age, heigth, weight, fatPercentage, biotype);
                PercentFatService fatService;
                double imc = ImcService.imcCalc(person);
                FatStatus statusPercent;
                if (person.getBiotype() == Biotype.men){
                    fatService = new PercentFatMenService();
                }else{
                    fatService = new PercentFatWomamService();
                }
                statusPercent = fatService.analyzeFatPercentage(person);
                String teste = ""+imc+" "+statusPercent.toString();

                Intent informationHealth = new Intent(MainActivity.this, MainActivityInformationHealth.class);
                Bundle params = new Bundle();
                params.putString("name", person.getName());
                params.putString("age", ""+person.getAge());
                params.putString("heigth", ""+person.getHeigth());
                params.putString("weight", ""+person.getWeight());
                params.putString("fatPercentage", ""+person.getFatPercentage());
                params.putString("biotype", ""+person.getBiotype());

                informationHealth.putExtras(params);
                startActivity(informationHealth);
            }
        });
        return null;
    }

    private void captureValue(){
        name = (TextView) findViewById(R.id.registrationName);
        heigth = (TextView) findViewById(R.id.registrationHeight);
        weight = (TextView) findViewById(R.id.registrationWeight);
        age = (TextView) findViewById(R.id.registrationAge);
        fatPercentage = (TextView) findViewById(R.id.registrationFatPercentage);
        biotype = (RadioGroup) findViewById(R.id.radioGroup);
    }

}