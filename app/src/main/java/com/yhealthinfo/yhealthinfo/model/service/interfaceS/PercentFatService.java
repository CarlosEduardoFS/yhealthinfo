package com.yhealthinfo.yhealthinfo.model.service.interfaceS;

import com.yhealthinfo.yhealthinfo.model.entity.Person;
import com.yhealthinfo.yhealthinfo.model.service.ennumS.FatStatus;

public interface PercentFatService {
    public FatStatus analyzeFatPercentage(Person person);
}
