package com.ecourse.service.impl;

import com.ecourse.dao.EcNoticeViewDao;
import com.ecourse.entity.EcNoticeView;
import com.ecourse.service.EcNoticeViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("EcNoticeView")
public class EcNoticeViewServiceImpl implements EcNoticeViewService {

    @Autowired
    private EcNoticeViewDao ecNoticeViewDao;

    @Override
    public void saveEcNoticeView(EcNoticeView ecNoticeView){
        ecNoticeViewDao.saveEcNoticeView(ecNoticeView);
    }
    @Override
    public EcNoticeView findEcNoticeViewById(Integer id){
        return ecNoticeViewDao.findEcNoticeViewById(id);
    }
    @Override
    public List<EcNoticeView> findEcNoticeView(Map<String, Object> map){
        StringBuilder hql = new StringBuilder("from EcNoticeView where 1=1 ");
        List<Object> params = new LinkedList<Object>();

        if (map.get("notId") != null) {
            hql.append(" and notId=? ");
            params.add(map.get("notId"));
        }
        if (map.get("userId") != null) {
            hql.append(" and userId=? ");
            params.add(map.get("userId"));
        }
        if (map.get("notViewTime") != null) {
            hql.append(" and notViewTime=? ");
            params.add(map.get("notViewTime"));
        }
        //System.out.println(hql.toString());
        return ecNoticeViewDao.findEcNoticeView(params, hql.toString());
    }

    @Override
    public void updateEcNoticeView(EcNoticeView ecNoticeView){
        ecNoticeViewDao.updateEcNoticeView(ecNoticeView);
    }

    @Override
    public void deleteEcNoticeView(EcNoticeView ecNoticeView) {
        ecNoticeViewDao.deleteEcNoticeView(ecNoticeView);
    }
}
