package com.ecourse.dao;

import com.ecourse.entity.EcCheck;

import java.util.List;

/**
 * @author tomato
 * @create 2017-12-21 上午10:03
 */
public interface EcCheckDao {

    /**
     * 保存
     *
     * @param ecCheck 保存数据
     */
    public void saveEcCheck(EcCheck ecCheck);

    /**
     * 更具ID查找
     *
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcCheck findEcCheckById(Integer id);

    /**
     * 更具课程号查找
     *
     * @param id key
     * @return 一堆EcCheck对象
     */
    public List<EcCheck> findEcCheckByCourseId(Integer id);

    /**
     * 其他查找
     *
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcCheck对象
     */
    public List<EcCheck> findEcCheck(List<Object> params, String hql);

    /**
     * 更新EcCheck
     *
     * @param ecCheck 需要更新的EcCheck持久化对象
     */
    public void updateEcCheck(EcCheck ecCheck);

    /**
     * 删除EcCheck
     *
     * @param ecCheck 需要删除的EcCheck
     */
    public void deletEcCheck(EcCheck ecCheck);
}
