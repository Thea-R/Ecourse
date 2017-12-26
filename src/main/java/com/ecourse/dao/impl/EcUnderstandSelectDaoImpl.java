package com.ecourse.dao.impl;

import com.ecourse.dao.EcUnderstandSelectDao;
import com.ecourse.entity.EcUnderstandSelect;
import com.ecourse.service.EcUnderstandService;
import com.ecourse.untils.AccountValidatorUtil;
import org.apache.ibatis.jdbc.Null;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EcUnderstandSelectDaoImpl extends BaseDaoImpl implements EcUnderstandSelectDao {

    @Autowired
    private EcUnderstandService ecUnderstandService;

    @Override
    public void saveEcUnderstandSelect(EcUnderstandSelect ecUnderstandSelect) {

        getSession().save(ecUnderstandSelect);
    }

    @Override
    public EcUnderstandSelect findEcUnderstandSelectById(Integer id) {
        String hql = "from EcUnderstand where undId = ? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcUnderstandSelect) query.uniqueResult();
    }

    @Override
    public EcUnderstandSelect findEcUnderstandSelectByUId(Integer id) {
        String hql = "from EcUnderstand where courseId = ? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcUnderstandSelect) query.uniqueResult();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<EcUnderstandSelect> findEcUnderstandSelect(List<Object> params, String hql) {
        Query query = getSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query.list();
    }

    @Override
    public void updateEcUnderstandSelect(EcUnderstandSelect ecUnderstandSelect) {
        getSession().update(ecUnderstandSelect);
    }

    @Override
    public void deletEcUnderstandSelect(EcUnderstandSelect ecUnderstandSelect) {
        getSession().delete(ecUnderstandSelect);}
}
