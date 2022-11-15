package com.yhealthinfo.yhealthinfo.model.service;

import com.yhealthinfo.yhealthinfo.model.entity.Person;
import com.yhealthinfo.yhealthinfo.model.service.ennumS.AgeGroup;
import com.yhealthinfo.yhealthinfo.model.service.ennumS.FatStatus;
import com.yhealthinfo.yhealthinfo.model.service.interfaceS.PercentFatService;

public class PercentFatMenService implements PercentFatService {

    @Override
    public FatStatus analyzeFatPercentage(Person person) {
        if (ageGroupMod(person) == AgeGroup.young){
            return comparesYoung(person.getFatPercentage());
        } else if (ageGroupMod(person) == AgeGroup.adult){
            return comparesAdult(person.getFatPercentage());
        } else if (ageGroupMod(person) == AgeGroup.majorityAge){
            return comparesMajorityAge(person.getFatPercentage());
        } else if (ageGroupMod(person) == AgeGroup.oldMan){
            return comparesOldMan(person.getFatPercentage());
        }
        throw new IllegalArgumentException("Erro na verificação idade ");
    }

    private AgeGroup ageGroupMod(Person person){
        if (person.getAge() >= 20 && person.getAge() <= 29){
            return AgeGroup.young;
        } else if(person.getAge() >= 30 && person.getAge() <= 39){
            return AgeGroup.adult;
        } else if(person.getAge() >= 40 && person.getAge() <= 49){
            return AgeGroup.majorityAge;
        } else if(person.getAge() >= 50){
            return AgeGroup.oldMan;
        }else{
            return null;
        }
    }

    private FatStatus comparesYoung(double percentage){
        if ((percentage < 11.00)){
            return FatStatus.athlete;
        } else if (percentage >= 11.00 && percentage <= 13.00){
            return FatStatus.good;
        } else if (percentage >= 14.00 && percentage <= 20.00){
            return FatStatus.normal;
        } else if (percentage >= 21.00 && percentage <= 23.00){
            return FatStatus.high;
        } else  {
            return FatStatus.veryHigh;
        }
    }

    private FatStatus comparesAdult(double percentage){
        if ((percentage < 12.00)){
            return FatStatus.athlete;
        } else if (percentage >= 12.00 && percentage <= 14.00){
            return FatStatus.good;
        } else if (percentage >= 15.00 && percentage <= 21.00){
            return FatStatus.normal;
        } else if (percentage >= 22.00 && percentage <= 24.00){
            return FatStatus.high;
        } else  {
            return FatStatus.veryHigh;
        }
    }

    private FatStatus comparesMajorityAge(double percentage){
        if ((percentage < 14.00)){
            return FatStatus.athlete;
        } else if (percentage >= 14.00 && percentage <= 16.00){
            return FatStatus.good;
        } else if (percentage >= 17.00 && percentage <= 23.00){
            return FatStatus.normal;
        } else if (percentage >= 24.00 && percentage <= 26.00){
            return FatStatus.high;
        } else  {
            return FatStatus.veryHigh;
        }
    }

    private FatStatus comparesOldMan(double percentage){
        if ((percentage < 15.00)){
            return FatStatus.athlete;
        } else if (percentage >= 15.00 && percentage <= 17.00){
            return FatStatus.good;
        } else if (percentage >= 18.00 && percentage <= 24.00){
            return FatStatus.normal;
        } else if (percentage >= 25.00 && percentage <= 27.00){
            return FatStatus.high;
        } else  {
            return FatStatus.veryHigh;
        }
    }

}
