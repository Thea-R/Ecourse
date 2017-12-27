package com.ecourse.service;

import com.ecourse.entity.EcSource;
import java.util.List;
import java.util.Map;

public interface EcSourceService {
    public void saveEcSource(EcSource ecSource);

    public EcSource findEcSourceBySid(Integer id);

    public EcSource findEcSourceByCid(Integer id);

    public List<EcSource> findEcSource(Map<String, Object> map);

    public void updateEcSource(EcSource ecSource);

    public void deletEcSource(EcSource ecSource);

    public int getNewSid();
}
