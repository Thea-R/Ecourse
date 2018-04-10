package com.ecourse.service;

import com.ecourse.entity.EcNoticeView;

import java.util.List;
import java.util.Map;

public interface EcNoticeViewService {

    public void saveEcNoticeView(EcNoticeView ecNoticeView);

    public EcNoticeView findEcNoticeViewById(Integer id);

    public List<EcNoticeView> findEcNoticeView(Map<String, Object> map);

    public void updateEcNoticeView(EcNoticeView ecNoticeView);

    public void deleteEcNoticeView(EcNoticeView ecNoticeView);
}
