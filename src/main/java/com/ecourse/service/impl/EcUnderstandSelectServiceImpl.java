package com.ecourse.service.impl;

import com.ecourse.dao.EcUnderstandSelectDao;
import com.ecourse.entity.EcUnderstandSelect;
import com.ecourse.entity.EcUser;
import com.ecourse.service.EcUnderstandSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("EcUnderstandSeclect")
public class EcUnderstandSelectServiceImpl implements EcUnderstandSelectService{
    @Autowired
    private EcUnderstandSelectDao ecUnderstandSelectDao;

    @Override
    public void saveEcUnderstandSelect(EcUnderstandSelect ecUnderstandSelect) {
        ecUnderstandSelectDao.saveEcUnderstandSelect(ecUnderstandSelect);
    }

    @Override
    public EcUnderstandSelect findEcUnderstandSelectById(Integer id) {
        return ecUnderstandSelectDao.findEcUnderstandSelectById(id);
    }

    @Override
    public EcUnderstandSelect findEcUnderstandSelectByUId(Integer id) {
        return ecUnderstandSelectDao.findEcUnderstandSelectByUId(id);
    }

    @Override
    public List<EcUnderstandSelect> findEcUnderstandSelect(Map<String, Object> map) {
        StringBuilder hql = new StringBuilder("from EcUnderstandSelect where 1=1 ");
        List<Object> params = new LinkedList<Object>();

        if (map.get("undId") != null) {
            hql.append(" and undId=? ");
            params.add(map.get("undId"));
        }
        if (map.get("userId") != null) {
            hql.append(" and userId=? ");
            params.add(map.get("userId"));
        }
        if (map.get("undType") != null) {
            hql.append(" and undType=? ");
            params.add(map.get("undType"));
        }

        //System.out.println(hql.toString());
        return ecUnderstandSelectDao.findEcUnderstandSelect(params, hql.toString());
    }

    @Override
    public void updateEcUnderstandSelect(EcUnderstandSelect ecUnderstandSelect) {

        ecUnderstandSelectDao.updateEcUnderstandSelect(ecUnderstandSelect);
    }

    @Override
    public void deletEcUnderstandSelect(EcUnderstandSelect ecUnderstandSelect) {

        ecUnderstandSelectDao.deletEcUnderstandSelect(ecUnderstandSelect);
    }
}
