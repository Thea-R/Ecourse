package com.ecourse.service.impl;

import com.ecourse.dao.EcUnderstandDao;
import com.ecourse.entity.EcUnderstand;
import com.ecourse.entity.EcUser;
import com.ecourse.service.EcUnderstandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("EcUnderstand")
public class EcUnderstandServiceImpl implements EcUnderstandService{
    @Autowired
    private EcUnderstandDao ecUnderstandDao;

    @Override
    public void saveEcUnderstand(EcUnderstand ecUnderstand) {

        ecUnderstandDao.saveEcUnderstand(ecUnderstand);
    }

    @Override
    public EcUnderstand findEcUnderstandById(Integer id) {

        return ecUnderstandDao.findEcUnderstandById(id);
    }

    @Override
    public EcUnderstand findEcUnderstandByCId(Integer id) {

        return ecUnderstandDao.findEcUnderstandByCId(id);
    }




    @Override
    public List<EcUnderstand> findEcUnderstand(Map<String, Object> map) {
        StringBuilder hql = new StringBuilder("from EcUnderstand where 1=1 ");
        List<Object> params = new LinkedList<Object>();

        if (map.get("undId") != null) {
            hql.append(" and undId=? ");
            params.add(map.get("undId"));
        }
        if (map.get("courseId") != null) {
            hql.append(" and courseId=? ");
            params.add(map.get("courseId"));
        }
        if (map.get("undTime") != null) {
            hql.append(" and undTime=? ");
            params.add(map.get("undTime"));
        }
        if (map.get("undMaximum") != null) {
            hql.append(" and undMaximum=? ");
            params.add(map.get("undMaximum"));
        }

        //System.out.println(hql.toString());
        return ecUnderstandDao.findEcUnderstand(params, hql.toString());
    }

    @Override
    public void updateEcUnderstand(EcUnderstand ecUnderstand) {

        ecUnderstandDao.updateEcUnderstand(ecUnderstand);
    }

    @Override
    public void deletEcUnderstand(EcUnderstand ecUnderstand) {

        ecUnderstandDao.deletEcUnderstand(ecUnderstand);
    }
}
