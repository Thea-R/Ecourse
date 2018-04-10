package com.ecourse.dao.impl;

import com.ecourse.dao.EcNoticeViewDao;
import com.ecourse.entity.EcNoticeView;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EcNoticeViewDaoImpl extends BaseDaoImpl implements EcNoticeViewDao {
    /**
     * 保存
     * @param ecNoticeView 保存数据
     */
    @Override
    public void saveEcNoticeView(EcNoticeView ecNoticeView){
        getSession().save(ecNoticeView);
    }

    /**
     * 更具ID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    @Override
    public EcNoticeView findEcNoticeViewById(Integer id){
        String hql = "from EcNoticeView where notId=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcNoticeView) query.uniqueResult();
    }

    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql 查找的hql语句
     * @return 一堆EcNotice对象
     */
    @Override
    public List<EcNoticeView> findEcNoticeView(List<Object> params, String hql){
        Query query = getSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query.list();
    }

    /**
     * 更新EcAnswer
     * @param ecNoticeView 需要更新的EcNoticeView持久化对象
     */
    @Override
    public void updateEcNoticeView(EcNoticeView ecNoticeView){
        getSession().update(ecNoticeView);
    }

    /**
     * 删除EcAnswer
     * @param ecNoticeView 需要删除的EcNoticeView
     */
    @Override
    public void deleteEcNoticeView(EcNoticeView ecNoticeView){
        getSession().delete(ecNoticeView);
    }
}
