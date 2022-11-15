package com.yhealthinfo.yhealthinfo.model.format;

import com.yhealthinfo.yhealthinfo.model.service.ImcStatus;

public class ImcFormat {

    public static String imcFormat(double imc){
        return String.format("%.2f",imc);
    }

    public static String imcStatusFormat(ImcStatus imcStatus){
        if (imcStatus == ImcStatus.thinness){
            return "Magreza";
        } else if (imcStatus == ImcStatus.normal){
            return "Normal";
        } else if (imcStatus == ImcStatus.overweight){
            return "Sobrepeso";
        } else if (imcStatus == ImcStatus.obesity){
            return "Obesidade";
        }else{
            return "Obesidade Grave";
        }
    }

}
