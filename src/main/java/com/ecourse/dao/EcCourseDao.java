package com.ecourse.dao;

import com.ecourse.entity.EcCourse;

import java.util.List;

/**
 * @author tomato
 * @create 2017-12-22 下午8:11
 */
public interface EcCourseDao {

    /**
     * 保存
     *
     * @param ecCourse 保存数据
     */
    public void saveEcCourse(EcCourse ecCourse);

    /**
     * 更具ID查找
     *
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcCourse findEcCourseById(Integer id);

    /**
     * 其他查找
     *
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcCourse对象
     */
    public List<EcCourse> findEcCourse(List<Object> params, String hql);

    /**
     * 更新EcCourse
     *
     * @param ecCourse 需要更新的EcCourse持久化对象
     */
    public void updateEcCourse(EcCourse ecCourse);

    /**
     * 删除EcCourse
     *
     * @param ecCourse 需要删除的EcCourse
     */
    public void deletEcCourse(EcCourse ecCourse);
}
