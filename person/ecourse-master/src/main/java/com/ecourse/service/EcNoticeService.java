package com.ecourse.service;

import com.ecourse.entity.EcNotice;

import java.util.List;
import java.util.Map;

public interface EcNoticeService {

    public void saveEcNotice(EcNotice ecNotice);

    public EcNotice findEcNoticeById(Integer id);

    public List<EcNotice> findEcNotice(Map<String, Object> map);

    public void updateEcNotice(EcNotice ecNotice);

    public void deleteEcNotice(EcNotice ecNotice);

}
