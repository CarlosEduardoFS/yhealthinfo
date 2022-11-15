package com.yhealthinfo.yhealthinfo.model.service;

import com.yhealthinfo.yhealthinfo.model.entity.Person;

public class ImcService {
    public static double imcCalc (Person person) throws IllegalArgumentException{
        return person.getWeight()/(person.getHeigth()* person.getHeigth());
    }

    public static ImcStatus imcStatus(double imc){
        if (imc < 18.5){
            return ImcStatus.thinness;
        }else if (imc >= 18.5 && imc <= 24.9){
            return ImcStatus.normal;
        }else if (imc >= 25.00 && imc <= 29.9){
            return ImcStatus.overweight;
        } else if (imc >= 30.00 && imc <= 39.9){
            return ImcStatus.obesity;
        }else{
            return ImcStatus.severeObesity;
        }
    }

}
