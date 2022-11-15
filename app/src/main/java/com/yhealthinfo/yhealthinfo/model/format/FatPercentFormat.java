package com.yhealthinfo.yhealthinfo.model.format;

import com.yhealthinfo.yhealthinfo.model.service.ennumS.FatStatus;

public class FatPercentFormat {
    public static String fatPercentFormat(FatStatus status){
        if (status == FatStatus.athlete){
            return "Atleta";
        }else if (status == FatStatus.good){
            return "Bom";
        }else if (status == FatStatus.normal){
            return "Normal";
        }else if (status == FatStatus.high){
            return "alto";
        } else {
            return "Muito Alta";
        }
    }
}
