package com.ecourse.dao.impl;

import com.ecourse.dao.EcSourceDao;
import com.ecourse.entity.EcSource;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EcSourceDaoImpl extends BaseDaoImpl implements EcSourceDao {
    /**
     * 保存
     * @param ecSource 保存数据
     */
    @Override
    public void saveEcSource(EcSource ecSource) {
        getSession().save(ecSource);
    }

    /**
     * 根据SID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    @Override
    public EcSource findEcSourceBySid(Integer id) {
        String hql = "from EcSource where sourceId=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcSource) query.uniqueResult();
    }

    /**
     * 根据CID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    @Override
    public EcSource findEcSourceByCid(Integer id) {
        String hql = "from EcSource where courseId=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (EcSource) query.uniqueResult();
    }

    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcSource对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<EcSource> findEcSource(List<Object> params, String hql) {
        Query query = getSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query.list();
    }

    /**
     * 更新EcSource
     * @param ecSource 需要更新的EcSource持久化对象
     */
    @Override
    public void updateEcSource(EcSource ecSource) {
        getSession().update(ecSource);
    }

    /**
     * 删除EcSource
     * @param ecSource 需要删除的EcSource
     */
    @Override
    public void deletEcSource(EcSource ecSource) {
        getSession().delete(ecSource);
    }

    @Override
    public int getNewSid() {
        String hql = "from EcSource where 1=1";
        Query query = getSession().createQuery(hql);
        List<EcSource> list=query.list();
        int ans=1;
        if(list==null || list.isEmpty())  return ans;
        for(int i=0; i<list.size(); i++) {
            int sid=list.get(i).getSourceId();
            ans=Math.max(ans, sid+1);
        }
        return ans;
    }
}
