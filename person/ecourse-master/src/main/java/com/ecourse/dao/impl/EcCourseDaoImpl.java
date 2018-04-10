package com.ecourse.dao.impl;

import com.ecourse.dao.EcCourseDao;
import com.ecourse.entity.EcCourse;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tomato
 * @create 2017-12-22 下午8:11
 */
@Repository
public class EcCourseDaoImpl extends BaseDaoImpl implements EcCourseDao {

    /**
     * 保存
     *
     * @param ecCourse 保存数据
     */
    @Override
    public void saveEcCourse(EcCourse ecCourse) {
        getSession().save(ecCourse);
    }

    /**
     * 更具ID查找
     *
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    @Override
    public EcCourse findEcCourseById(Integer id) {
        String hql = "from EcCourse where courseId=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcCourse) query.uniqueResult();
    }

    /**
     * 其他查找
     *
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcCourse对象
     */
    @Override

    public List<EcCourse> findEcCourse(List<Object> params, String hql) {
        System.out.println("???");
        Query query = getSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        System.out.println("???");
        return query.list();
    }

    @Override
    public List<EcCourse> findEcCourseByuserId(Integer id)
    {
        String hql = "from EcCourse where userId=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return query.list();
    }

    /**
     * 更新EcCourse
     *
     * @param ecCourse 需要更新的EcCourse持久化对象
     */
    @Override
    public void updateEcCourse(EcCourse ecCourse) {
        getSession().update(ecCourse);
    }

    /**
     * 删除EcCourse
     *
     * @param ecCourse 需要删除的EcCourse
     */
    @Override
    public void deletEcCourse(EcCourse ecCourse) {
        getSession().delete(ecCourse);
    }
}
