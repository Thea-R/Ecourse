package com.ecourse.dao.impl;

import com.ecourse.dao.EcNoticeDao;
import com.ecourse.entity.EcNotice;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EcNoticeDaoImpl extends BaseDaoImpl implements EcNoticeDao {

    /**
     * 保存
     * @param ecNotice 保存数据
     */

    @Override
    public void saveEcNotice(EcNotice ecNotice){
        getSession().save(ecNotice);
    }

    /**
     * 更具ID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */

    @Override
    public EcNotice findEcNoticeById(Integer id){
        String hql = "from EcNotice where notId=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcNotice) query.uniqueResult();
    }

    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql 查找的hql语句
     * @return 一堆EcNotice对象
     */

    @Override
    public List<EcNotice> findEcNotice(List<Object> params, String hql){
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
     * @param ecNotice 需要更新的EcNotice持久化对象
     */
    @Override
    public void updateEcNotice(EcNotice ecNotice){
        getSession().update(ecNotice);
    }

    /**
     * 删除EcAnswer
     * @param ecNotice 需要删除的EcNotice
     */
    @Override
    public void deleteEcNotice(EcNotice ecNotice){
        getSession().delete(ecNotice);
    }
}
