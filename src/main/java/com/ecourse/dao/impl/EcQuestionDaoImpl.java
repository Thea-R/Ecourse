package com.ecourse.dao.impl;

import org.hibernate.Query;
import java.util.List;
import com.ecourse.dao.EcQuestionDao;
import com.ecourse.entity.EcQuestion;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangyuxuan on 17/12/21.
 */

@Repository
public class EcQuestionDaoImpl extends BaseDaoImpl implements EcQuestionDao {

    /**
     * 保存
     * @param ecQuestion  保存数据
     */
    @Override
    public void saveEcQuestion(EcQuestion ecQuestion) {
        getSession().save(ecQuestion);
    }

    /**
     * 更具ID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    @Override
    public EcQuestion findEcQuestionById(Integer id) {
        String hql = "from EcQuestion where queId=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcQuestion) query.uniqueResult();
    }

    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql 查找的hql语句
     * @return 一堆EcAnswer对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<EcQuestion> findEcQuestion(List<Object> params, String hql) {
        Query query = getSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query.list();
    }

    /**
     * 更新EcQuestion
     * @param ecQuestion 需要更新的EcQuestion持久化对象
     */
    @Override
    public void updateEcQuestion(EcQuestion ecQuestion) {
        getSession().update(ecQuestion);
    }

    /**
     * 删除EcQuestion
     * @param ecQuestion 需要删除的EcQuestion
     */
    @Override
    public void deletEcQuestion(EcQuestion ecQuestion) {
        getSession().delete(ecQuestion);
    }
}
