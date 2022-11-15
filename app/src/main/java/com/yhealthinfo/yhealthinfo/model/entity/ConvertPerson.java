package com.yhealthinfo.yhealthinfo.model.entity;

import android.widget.TextView;
import android.widget.RadioGroup;

import com.yhealthinfo.yhealthinfo.R;

public class ConvertPerson {

    private static Biotype checkBiotype;
    private static int teste;

    public static Person convertPerson(TextView name, TextView age, TextView heigth, TextView weight, TextView fatPercentage, RadioGroup biotype){
        Person person = new Person();

        person.setName(name.getText().toString());
        person.setAge(Byte.parseByte(age.getText().toString()));
        person.setHeigth(Double.parseDouble(heigth.getText().toString()));
        person.setWeight(Double.parseDouble(weight.getText().toString()));
        person.setFatPercentage(Double.parseDouble(fatPercentage.getText().toString()));
        person.setBiotype(convertBiotype(biotype));
        return person;
    }

    public static Biotype convertBiotype(RadioGroup biotype){
        int valueCkhecked = biotype.getCheckedRadioButtonId();
        if (valueCkhecked == R.id.menRegistration){
            return Biotype.men;
        }else if(valueCkhecked == R.id.womamRegistration){
            return Biotype.womam;
        }else{
            throw new IllegalArgumentException("Erro na verificação de Bio-tipo");
        }
    }

    public static Person convertStringPerson(String name, String age, String heigth, String weight, String fatPercentage, String biotype ){
        Person person = new Person();
        person.setName(name);
        person.setAge(Byte.parseByte(age));
        person.setHeigth(Double.parseDouble(heigth));
        person.setWeight(Double.parseDouble(weight));
        person.setFatPercentage(Double.parseDouble(fatPercentage));
        person.setBiotype(convertStringBiotype(biotype));
        return person;
    }

    private static Biotype convertStringBiotype(String biotype){
        if (biotype.equals("men")){
            return Biotype.men;
        }else{
            return Biotype.womam;
        }
    }
}
