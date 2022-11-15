package com.yhealthinfo.yhealthinfo.model.service;

import com.yhealthinfo.yhealthinfo.model.entity.Person;
import com.yhealthinfo.yhealthinfo.model.service.ennumS.AgeGroup;
import com.yhealthinfo.yhealthinfo.model.service.ennumS.FatStatus;
import com.yhealthinfo.yhealthinfo.model.service.interfaceS.PercentFatService;

public class PercentFatWomamService implements PercentFatService {

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
        }else{
            return null;
        }
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
        }
        throw new IllegalArgumentException("Erro na verificação idade ");
    }

    private FatStatus comparesYoung(double percentage){
        if ((percentage < 16.00)){
            return FatStatus.athlete;
        } else if (percentage >= 16.00 && percentage <= 19.00){
            return FatStatus.good;
        } else if (percentage >= 20.00 && percentage <= 28.00){
            return FatStatus.normal;
        } else if (percentage >= 29.00 && percentage <= 31.00){
            return FatStatus.high;
        } else  {
            return FatStatus.veryHigh;
        }
    }

    private FatStatus comparesAdult(double percentage){
        if ((percentage < 17.00)){
            return FatStatus.athlete;
        } else if (percentage >= 17.00 && percentage <= 20.00){
            return FatStatus.good;
        } else if (percentage >= 21.00 && percentage <= 29.00){
            return FatStatus.normal;
        } else if (percentage >= 30.00 && percentage <= 32.00){
            return FatStatus.high;
        } else  {
            return FatStatus.veryHigh;
        }
    }

    private FatStatus comparesMajorityAge(double percentage){
        if ((percentage < 18.00)){
            return FatStatus.athlete;
        } else if (percentage >= 18.00 && percentage <= 21.00){
            return FatStatus.good;
        } else if (percentage >= 22.00 && percentage <= 30.00){
            return FatStatus.normal;
        } else if (percentage >= 31.00 && percentage <= 32.00){
            return FatStatus.high;
        } else  {
            return FatStatus.veryHigh;
        }
    }

    private FatStatus comparesOldMan(double percentage){
        if ((percentage < 19.00)){
            return FatStatus.athlete;
        } else if (percentage >= 19.00 && percentage <= 22.00){
            return FatStatus.good;
        } else if (percentage >= 23.00 && percentage <= 31.00){
            return FatStatus.normal;
        } else if (percentage >= 32.00 && percentage <= 34.00){
            return FatStatus.high;
        } else  {
            return FatStatus.veryHigh;
        }
    }

}
