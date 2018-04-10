package com.ecourse.service.impl;

import com.ecourse.dao.EcNoticeDao;
import com.ecourse.entity.EcNotice;
import com.ecourse.service.EcNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("EcNotice")
public class EcNoticeServiceImpl implements EcNoticeService{

    @Autowired
    private EcNoticeDao ecNoticeDao;

    public void saveEcNotice(EcNotice ecNotice){
        ecNoticeDao.saveEcNotice(ecNotice);
    }

    @Override
    public EcNotice findEcNoticeById(Integer id){
        return ecNoticeDao.findEcNoticeById(id);
    }
    @Override
    public List<EcNotice> findEcNotice(Map<String, Object> map){
        StringBuilder hql = new StringBuilder("from EcNotice where 1=1 ");
        List<Object> params = new LinkedList<Object>();
        if (map.get("courseId") != null) {
            hql.append(" and courseId=? ");
            params.add(map.get("courseId"));
        }
        if (map.get("notType") != null) {
            hql.append(" and notType=? ");
            params.add(map.get("notType"));
        }
        if (map.get("notTime") != null) {
            hql.append(" and notTime=? ");
            params.add(map.get("notTime"));
        }
        if (map.get("notContent") != null) {
            hql.append(" and notContent=? ");
            params.add(map.get("notContent"));
        }
        if (map.get("notTitle") != null) {
            hql.append(" and notTitle=? ");
            params.add(map.get("notTitle"));
        }
        hql.append(" order by notTime desc ");

        return ecNoticeDao.findEcNotice(params, hql.toString());
    }
    @Override
    public void updateEcNotice(EcNotice ecNotice){
        ecNoticeDao.updateEcNotice(ecNotice);
    }
    @Override
    public void deleteEcNotice(EcNotice ecNotice){
        ecNoticeDao.deleteEcNotice(ecNotice);
    }
}
