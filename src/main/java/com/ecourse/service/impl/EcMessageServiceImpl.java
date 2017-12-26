package com.ecourse.service.impl;

import com.ecourse.dao.EcMessageDao;
import com.ecourse.entity.EcMessage;
import com.ecourse.service.EcMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by biggf on 2017/12/23.
 */
@Service("EcMessage")
public class EcMessageServiceImpl implements EcMessageService{
    @Autowired
    private EcMessageDao ecMessageDao;


    @Override
    /**
     * 保存
     *
     * @param ecMessage 保存数据
     */
    public void saveEcMessage(EcMessage ecMessage){ecMessageDao.saveEcMessage(ecMessage);}
    @Override
    /**
     * 更具ID查找
     *
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcMessage findEcMessageById(Integer id)
    {
        return ecMessageDao.findEcMessageById(id);
    }
    @Override
    public List<EcMessage> findEcMessageByCourseId(Integer courseId)
    {
        return ecMessageDao.findEcMessageByCourseId(courseId);
    }

    @Override
    public EcMessage findUserMessage(Integer userId,Integer courseId)
    {
        return ecMessageDao.findUserMessage(userId,courseId);
    }

    @Override
    /**
     * 其他查找
     *
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcMessage对象
     */
    public List<EcMessage> findEcMessage(Map<String, Object> map)
    {
        StringBuilder hql = new StringBuilder("from EcMessage where 1=1 ");
        List<Object> params = new LinkedList<Object>();

        if(map.get("msgId")!=null)
        {
            hql.append(" and msgId = ? ");
            params.add(map.get("msgId"));
        }
        if(map.get("userId")!=null)
        {
            hql.append(" and userId= ? ");
            params.add(map.get("userId"));
        }
        if(map.get("courseId")!=null)
        {
            hql.append(" and courseId= ? ");
            params.add(map.get("courseId"));
        }
        if(map.get("msgTime")!=null)
        {
            hql.append(" and msgTime= ? ");
            params.add(map.get("msgTime"));
        }
        if(map.get("msgContent")!=null)
        {
            hql.append(" and msgContent= ? ");
            params.add(map.get("msgContent"));
        }
        if(map.get("msgAnonymous")!=null);
        {
            hql.append("msgAnonymous");
            params.add(map.get("msgAnonymous"));
        }
        if(map.get("msgStar")!=null)
        {
            hql.append("msgStar");
            params.add(map.get("msgStar"));
        }
        return ecMessageDao.findEcMessage(params,hql.toString());
    }
    @Override
    /**
     * 更新EcMessae
     *
     * @param ecMessage 需要更新的EcMessage持久化对象
     */
    public void updateEcMessage(EcMessage ecMessage)
    {
        ecMessageDao.updateEcMessage(ecMessage);
    }

    @Override
    /**
     * 删除EcMessae
     *
     * @param ecMessage 需要删除的EcMessge
     */
    public void deleteEcMessage(EcMessage ecMessage){
        ecMessageDao.deleteEcMessage(ecMessage);
    }
}
