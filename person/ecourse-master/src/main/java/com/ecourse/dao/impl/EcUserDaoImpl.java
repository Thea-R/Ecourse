package com.ecourse.dao.impl;

import com.ecourse.dao.EcUserDao;
import com.ecourse.entity.EcUser;
import com.ecourse.untils.AccountValidatorUtil;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tomato
 * @create 2017-12-14 下午11:10
 */
@Repository
public class EcUserDaoImpl extends BaseDaoImpl implements EcUserDao {

    @Override
    public void saveEcUser(EcUser ecUser) {
        getSession().save(ecUser);
    }

    @Override
    public EcUser findEcUserById(Integer id) {
        String hql = "from EcUser where userId = ? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcUser) query.uniqueResult();
    }

    @Override
    public EcUser findEcUserByPhandMa(String mail,String phone ){
        String hql="from EcUser where userEmail=? and userPhone=?";
        Query query=getSession().createQuery(hql);
        query.setParameter(0,mail);
        query.setParameter(1,phone);
        return (EcUser) query.uniqueResult();
    }

    @Override
    public EcUser findEcUserByLogin(Integer id, String password) {
        String hql = "from EcUser where userId=? and userPassword=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        query.setParameter(1, password);
        return (EcUser) query.uniqueResult();
    }

    @Override
    public EcUser findEcUserByLogin(String key, String password) {
        StringBuilder hql = new StringBuilder("from EcUser where 1=1 ");
        if (AccountValidatorUtil.isEmail(key)) {
            hql.append(" and userEmail=? ");
        } else if (AccountValidatorUtil.isMobile(key)) {
            hql.append(" and userPhone=? ");
        } else {
            Query query = getSession().createQuery(hql.toString() + " and userNum=? and userPassword=?");
            query.setParameter(0, key);
            query.setParameter(1, password);
            EcUser ecUser = (EcUser) query.uniqueResult();
            if (ecUser == null) {
                query = getSession().createQuery(hql.toString() + " and userWxId=? and userPassword=?");
                query.setParameter(0, key);
                query.setParameter(1, password);
                return (EcUser) query.uniqueResult();
            }
            return ecUser;
        }
        hql.append(" and userPassword=?");
        Query query = getSession().createQuery(hql.toString());
        query.setParameter(0, key);
        query.setParameter(1, password);
        return (EcUser) query.uniqueResult();
    }

    @Override
    public EcUser findEcUserByWxId(Integer id) {
        String hql = "from EcUser where userWxId = ? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcUser) query.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<EcUser> findEcUser(List<Object> params, String hql) {
        Query query = getSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query.list();
    }

    @Override
    public void updateEcUser(EcUser ecUser) {
        getSession().update(ecUser);
    }

    @Override
    public void deletEcUser(EcUser ecUser) {
        getSession().delete(ecUser);
    }
}
