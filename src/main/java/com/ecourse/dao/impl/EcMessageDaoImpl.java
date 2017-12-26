package com.ecourse.dao.impl;

import com.ecourse.dao.EcMessageDao;
import com.ecourse.entity.EcMessage;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by biggf on 2017/12/23.
 */
@Repository
public class EcMessageDaoImpl extends BaseDaoImpl  implements EcMessageDao{
    @Override
    /**
     * 保存
     *
     * @param ecMessage 保存数据
     */
    public void saveEcMessage(EcMessage ecMessage){getSession().save(ecMessage);}
    @Override
    /**
     * 更具ID查找
     *
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcMessage findEcMessageById(Integer id)
    {

        String hql = "from EcMessage where msgId=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcMessage) query.uniqueResult();
    }
    @Override
    public List<EcMessage> findEcMessageByCourseId(Integer courseId)
    {
        String hql = "from EcMessage where courseId=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, courseId);
        return query.list();
    }


    @Override
    public EcMessage findUserMessage(Integer userId,Integer courseId)
    {
        String hql = "from EcMessage where userId=? and courseId=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1,courseId);
        return (EcMessage) query.uniqueResult();
    }

    @Override
    /**
     * 其他查找
     *
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcMessage对象
     */
    public List<EcMessage> findEcMessage(List<Object> params, String hql)
    {
        System.out.println(hql+"params.size:"+params.size());
        Query query = getSession().createQuery(hql);

        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {

                query.setParameter(i, params.get(i));
                System.out.println("in EcMessageDaoImpl findEcMessage:"+params.get(i));
            }
        }
        System.out.println(query.toString());
        System.out.println(":/"+query.list().size());
        return query.list();
    }
    @Override
    /**
     * 更新EcMessae
     *
     * @param ecMessage 需要更新的EcMessage持久化对象
     */
    public void updateEcMessage(EcMessage ecMessage)
    {
        getSession().update(ecMessage);
    }

    @Override
    /**
     * 删除EcMessae
     *
     * @param ecMessage 需要删除的EcMessge
     */
    public void deleteEcMessage(EcMessage ecMessage){
        getSession().delete(ecMessage);
    }
}
