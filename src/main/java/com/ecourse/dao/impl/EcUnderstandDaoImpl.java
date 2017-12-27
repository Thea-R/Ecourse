package com.ecourse.dao.impl;

import com.ecourse.dao.EcUnderstandDao;
import com.ecourse.entity.EcUnderstand;
import com.ecourse.untils.AccountValidatorUtil;
import org.apache.ibatis.jdbc.Null;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tomato
 * @create 2017-12-14 下午11:10
 */
@Repository
public class EcUnderstandDaoImpl extends BaseDaoImpl implements EcUnderstandDao {

    @Override
    public void saveEcUnderstand(EcUnderstand ecUnderstand) {
        getSession().save(ecUnderstand);
    }

    @Override
    public EcUnderstand findEcUnderstandById(Integer id) {
        String hql = "from EcUnderstand where undId = ? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcUnderstand) query.uniqueResult();
    }

    @Override
    public EcUnderstand findEcUnderstandByCId(Integer id) {
        String hql = "from EcUnderstand where courseId = ? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcUnderstand) query.uniqueResult();
    }



    @Override
    @SuppressWarnings("unchecked")
    public List<EcUnderstand> findEcUnderstand(List<Object> params, String hql) {
        Query query = getSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query.list();
    }

    @Override
    public void updateEcUnderstand(EcUnderstand ecUnderstand) {
        getSession().update(ecUnderstand);
    }

    @Override
    public void deletEcUnderstand(EcUnderstand ecUnderstand) {
        getSession().delete(ecUnderstand);
    }
}
