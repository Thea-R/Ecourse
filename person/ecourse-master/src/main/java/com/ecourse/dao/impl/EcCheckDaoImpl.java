package com.ecourse.dao.impl;

import com.ecourse.dao.EcCheckDao;
import com.ecourse.entity.EcCheck;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tomato
 * @create 2017-12-21 上午10:05
 */
@Repository
public class EcCheckDaoImpl extends BaseDaoImpl implements EcCheckDao {

    /**
     * 保存
     *
     * @param ecCheck 保存数据
     */
    @Override
    public void saveEcCheck(EcCheck ecCheck) {
        getSession().save(ecCheck);
    }

    /**
     * 更具ID查找
     *
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    @Override
    public EcCheck findEcCheckById(Integer id) {
        String hql = "from EcCheck where checkId=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcCheck) query.uniqueResult();
    }

    /**
     * 更具课程号查找
     *
     * @param id key
     * @return 一堆EcCheck对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<EcCheck> findEcCheckByCourseId(Integer id) {
        String hql = "from EcCheck where courseId=? order by checkId desc";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return query.list();
    }

    /**
     * 其他查找
     *
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcCheck对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<EcCheck> findEcCheck(List<Object> params, String hql) {
        Query query = getSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query.list();
    }

    /**
     * 更新EcCheck
     *
     * @param ecCheck 需要更新的EcCheck持久化对象
     */
    @Override
    public void updateEcCheck(EcCheck ecCheck) {
        getSession().update(ecCheck);
    }

    /**
     * 删除EcCheck
     *
     * @param ecCheck 需要删除的EcCheck
     */
    @Override
    public void deletEcCheck(EcCheck ecCheck) {
        getSession().delete(ecCheck);
    }
}
