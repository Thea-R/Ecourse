package com.ecourse.dao.impl;

import com.ecourse.dao.EcStuandcourseDao;
import com.ecourse.entity.EcStuandcourse;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tomato
 * @create 2017-12-22 下午8:30
 */
@Repository
public class EcStuandcourseDaoImpl extends BaseDaoImpl implements EcStuandcourseDao {

    /**
     * 保存
     *
     * @param ecStuandcourse 保存数据
     */
    @Override
    public void saveEcStuandcourse(EcStuandcourse ecStuandcourse) {
        getSession().save(ecStuandcourse);
    }

    /**
     * 更具ID查找
     *
     * @param courseId 课程号
     * @param userId   用户账号
     * @return 返回对应的对象，没有查找到为null
     */
    @Override
    public EcStuandcourse findEcStuandcourseById(Integer courseId, Integer userId) {
        String hql = "from EcStuandcourse where courseId=? and userId=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, courseId);
        query.setParameter(1, userId);
        return (EcStuandcourse) query.uniqueResult();
    }

    /**
     * 更具课程号查找
     *
     * @param courseId 课程号
     * @return 一堆EcStuandcourse对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<EcStuandcourse> findEcStuandcourseByCourseId(Integer courseId){
        String hql = "from EcStuandcourse where courseId=? order by userId ASC";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, courseId);
        return query.list();
    }

    /**
     * 更具用户号查找
     *
     * @param userId 用户号
     * @return 一堆EcStuandcourse对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<EcStuandcourse> findEcStuandcourseByUserId(Integer userId){
        String hql = "from EcStuandcourse where userId=? order by courseId ASC";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, userId);
        return query.list();
    }

    /**
     * 更新EcStuandcourse
     *
     * @param ecStuandcourse 需要更新的EcStuandcourse持久化对象
     */
    @Override
    public void updateEcStuandcourse(EcStuandcourse ecStuandcourse) {
        getSession().update(ecStuandcourse);
    }

    /**
     * 删除EcStuandcourse
     *
     * @param ecStuandcourse 需要删除的EcStuandcourse
     */
    @Override
    public void deletEcStuandcourse(EcStuandcourse ecStuandcourse) {
        getSession().delete(ecStuandcourse);
    }
}
