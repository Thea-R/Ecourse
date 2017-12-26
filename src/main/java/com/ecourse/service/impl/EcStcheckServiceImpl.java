package com.ecourse.service.impl;

import com.ecourse.dao.EcStcheckDao;
import com.ecourse.entity.EcStcheck;
import com.ecourse.service.EcStcheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-21 下午7:36
 */
@Service("EcStcheck")
public class EcStcheckServiceImpl implements EcStcheckService {

    @Autowired
    private EcStcheckDao ecStcheckDao;

    @Override
    public void saveEcStcheck(EcStcheck ecStcheck) {
        ecStcheckDao.saveEcStcheck(ecStcheck);
    }

    @Override
    public EcStcheck findEcStcheckById(Integer checkId, Integer userId) {
        return ecStcheckDao.findEcStcheckById(checkId, userId);
    }

    @Override
    public List<EcStcheck> findEcStcheckByCheckId(Integer id) {
        return ecStcheckDao.findEcStcheckByCheckId(id);
    }

    @Override
    public List<EcStcheck> findEcStcheck(Map<String, Object> map) {
        StringBuilder hql = new StringBuilder("from EcStcheck where 1=1 ");
        List<Object> params = new LinkedList<Object>();
        if (map.get("checkId") != null) {
            hql.append(" and checkId=? ");
            params.add(map.get("checkId"));
        }
        if (map.get("userId") != null) {
            hql.append(" and userId=? ");
            params.add(map.get("userId"));
        }
        if (map.get("checkType") != null) {
            hql.append(" and checkType=? ");
            params.add(map.get("checkType"));
        }
        if (map.get("ltCheckType") != null) {
            hql.append(" and checkType<? ");
            params.add(map.get("ltCheckType"));
        }
        return ecStcheckDao.findEcStcheck(params, hql.toString());
    }

    @Override
    public void updateEcStcheck(EcStcheck ecStcheck) {
        ecStcheckDao.updateEcStcheck(ecStcheck);
    }

    @Override
    public void deletEcStcheck(EcStcheck ecStcheck) {
        ecStcheckDao.deletEcStcheck(ecStcheck);
    }
}
