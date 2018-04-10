package com.ecourse.dao;

import com.ecourse.entity.EcNotice;

import java.util.List;

public interface EcNoticeDao {

    /**
     * 保存
     * @param ecNotice 保存数据
     */
    public void saveEcNotice(EcNotice ecNotice);

    /**
     * 更具ID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcNotice findEcNoticeById(Integer id);

    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql 查找的hql语句
     * @return 一堆EcNotice对象
     */
    public List<EcNotice> findEcNotice(List<Object> params, String hql);

    /**
     * 更新EcAnswer
     * @param ecNotice 需要更新的EcNotice持久化对象
     */
    public void updateEcNotice(EcNotice ecNotice);

    /**
     * 删除EcAnswer
     * @param ecNotice 需要删除的EcNotice
     */
    public void deleteEcNotice(EcNotice ecNotice);

}
