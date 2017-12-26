package com.ecourse.dao;

import com.ecourse.entity.EcStcheck;
import com.ecourse.entity.EcStuandcourse;

import java.util.List;

/**
 * @author tomato
 * @create 2017-12-22 下午8:30
 */
public interface EcStuandcourseDao {

    /**
     * 保存
     *
     * @param ecStuandcourse 保存数据
     */
    public void saveEcStuandcourse(EcStuandcourse ecStuandcourse);

    /**
     * 更具ID查找
     *
     * @param courseId 课程号
     * @param userId   用户账号
     * @return 返回对应的对象，没有查找到为null
     */
    public EcStuandcourse findEcStuandcourseById(Integer courseId, Integer userId);

    /**
     * 更具课程号查找
     *
     * @param courseId 课程号
     * @return 一堆EcStuandcourse对象
     */
    public List<EcStuandcourse> findEcStuandcourseByCourseId(Integer courseId);

    /**
     * 更具用户号查找
     *
     * @param userId 用户号
     * @return 一堆EcStuandcourse对象
     */
    public List<EcStuandcourse> findEcStuandcourseByUserId(Integer userId);

    /**
     * 更新EcStuandcourse
     *
     * @param ecStuandcourse 需要更新的EcStuandcourse持久化对象
     */
    public void updateEcStuandcourse(EcStuandcourse ecStuandcourse);

    /**
     * 删除EcStuandcourse
     *
     * @param ecStuandcourse 需要删除的EcStuandcourse
     */
    public void deletEcStuandcourse(EcStuandcourse ecStuandcourse);
}
