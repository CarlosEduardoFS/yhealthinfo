package com.yhealthinfo.yhealthinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yhealthinfo.yhealthinfo.model.entity.Biotype;
import com.yhealthinfo.yhealthinfo.model.entity.ConvertPerson;
import com.yhealthinfo.yhealthinfo.model.entity.Person;
import com.yhealthinfo.yhealthinfo.model.service.ImcService;
import com.yhealthinfo.yhealthinfo.model.service.PercentFatMenService;
import com.yhealthinfo.yhealthinfo.model.service.PercentFatWomamService;
import com.yhealthinfo.yhealthinfo.model.service.ennumS.FatStatus;
import com.yhealthinfo.yhealthinfo.model.service.interfaceS.PercentFatService;

public class MainActivityMore extends AppCompatActivity {

    Button imc01;
    Button imc02;
    Button fatPercent01;
    Button fatPercent02;
    String[] url = {
            "https://www.sistemasca.com/blog/160/o-que-e-imc-entenda-a-importancia-desse-protocolo-na-avaliacao-fisica#:~:text=O%20IMC%20é%20o%20cálculo,e%20encontrar%20seu%20peso%20ideal.",
            "https://www.torcedores.com/noticias/2020/04/entenda-a-importancia-do-imc-e-como-fazer-o-calculo",
            "https://my.oceandrop.com.br/percentual-de-gordura/#:~:text=Manter-se%20dentro%20do%20índice,de%20fatores%20inflamatórios%20no%20organismo.",
            "https://mude.vc/percentual-de-gordura/"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.know_more);
        captureValue();
        Intent webWiew = new Intent(MainActivityMore.this, MainActivityWebWiew.class);
        Bundle bundle = new Bundle();
        imc01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebWiew(url[0], webWiew, bundle);

            }
        });

        imc02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebWiew(url[1], webWiew, bundle);
            }
        });

        fatPercent01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebWiew(url[2],webWiew, bundle);
            }
        });

        fatPercent02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebWiew(url[3],webWiew, bundle);
            }
        });
    }

    private void captureValue(){
        imc01 = (Button) findViewById(R.id.imc01);
        imc02 = (Button) findViewById(R.id.imc02);
        fatPercent01 = (Button) findViewById(R.id.fatPercent01);
        fatPercent02 = (Button) findViewById(R.id.fatPercent02);
    }

    private void loadWebWiew(String url, Intent intent, Bundle bundle){
        bundle.putString("url",url);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}