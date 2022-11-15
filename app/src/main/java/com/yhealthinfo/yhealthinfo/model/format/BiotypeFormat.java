package com.yhealthinfo.yhealthinfo.model.format;

import com.yhealthinfo.yhealthinfo.model.entity.Biotype;

public class BiotypeFormat {
    public static String biotypeFormat(Biotype biotype){
        if (biotype == Biotype.men){
            return "Homem";
        }else{
            return "Mulher";
        }
    }

    public static String biotypeFormatString(String biotype){
        if (biotype.equalsIgnoreCase("men")){
            return "Homem";
        }else{
            return "Mulher";
        }
    }

}
