package com.ecourse.service.impl;

import com.ecourse.dao.EcCheckDao;
import com.ecourse.entity.EcCheck;
import com.ecourse.service.EcCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-21 上午10:23
 */
@Service("EcCheck")
public class EcCheckServiceImpl implements EcCheckService {

    @Autowired
    private EcCheckDao ecCheckDao;

    @Override
    public void saveEcCheck(EcCheck ecCheck) {
        ecCheckDao.saveEcCheck(ecCheck);
    }

    @Override
    public EcCheck findEcCheckById(Integer id) {
        return ecCheckDao.findEcCheckById(id);
    }

    @Override
    public List<EcCheck> findEcCheckByCourseId(Integer id) {
        return ecCheckDao.findEcCheckByCourseId(id);
    }

    @Override
    public List<EcCheck> findEcCheck(Map<String, Object> map) {
        StringBuilder hql = new StringBuilder("from EcCheck where 1=1 ");
        List<Object> params = new LinkedList<Object>();

        if (map.get("courseId") != null) {
            hql.append(" and courseId=? ");
            params.add(map.get("courseId"));
        }
        if (map.get("checkTime") != null) {
            hql.append(" and checkTime=? ");
            params.add(map.get("checkTime"));
        }
        if (map.get("checkVerify") != null) {
            hql.append(" and checkVerify=? ");
            params.add(map.get("checkVerify"));
        }
        if (map.get("checkState") != null) {
            hql.append(" and checkState=? ");
            params.add(map.get("checkState"));
        }//order by time    desc
        return ecCheckDao.findEcCheck(params, hql.toString());
    }

    @Override
    public void updateEcCheck(EcCheck ecCheck) {
        ecCheckDao.updateEcCheck(ecCheck);
    }

    @Override
    public void deletEcCheck(EcCheck ecCheck) {
        ecCheckDao.deletEcCheck(ecCheck);
    }
}
