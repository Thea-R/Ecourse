package com.ecourse.dao;

import com.ecourse.entity.EcMessage;

import java.util.List;

/**
 * Created by biggf on 2017/12/23.
 */
public interface EcMessageDao {

    /**
     * 保存
     *
     * @param ecMessage 保存数据
     */
    public void saveEcMessage(EcMessage ecMessage);

    /**
     * 更具ID查找
     *
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcMessage findEcMessageById(Integer id);

    public List<EcMessage> findEcMessageByCourseId(Integer courseId);

    public EcMessage findUserMessage(Integer userId,Integer courseId);
    /**
     * 其他查找
     *
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcMessage对象
     */
    public List<EcMessage> findEcMessage(List<Object> params, String hql);

    /**
     * 更新EcMessae
     *
     * @param ecMessage 需要更新的EcMessage持久化对象
     */
    public void updateEcMessage(EcMessage ecMessage);

    /**
     * 删除EcMessae
     *
     * @param ecMessage 需要删除的EcMessge
     */
    public void deleteEcMessage(EcMessage ecMessage);

}
