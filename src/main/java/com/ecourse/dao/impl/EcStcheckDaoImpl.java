package com.ecourse.dao.impl;

import com.ecourse.dao.EcStcheckDao;
import com.ecourse.entity.EcStcheck;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author tomato
 * @create 2017-12-21 下午7:25
 */
@Repository
public class EcStcheckDaoImpl extends BaseDaoImpl implements EcStcheckDao {

    /**
     * 保存
     *
     * @param ecStcheck 保存数据
     */
    @Override
    public void saveEcStcheck(EcStcheck ecStcheck) {
        getSession().save(ecStcheck);
    }

    /**
     * 更具ID查找
     *
     * @param checkId 签到号
     * @param userId  用户账号
     * @return 返回对应的对象，没有查找到为null
     */
    @Override
    public EcStcheck findEcStcheckById(Integer checkId, Integer userId) {
        String hql = "from EcStcheck where checkId=? and userId=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, checkId);
        query.setParameter(1, userId);
        return (EcStcheck) query.uniqueResult();
    }

    /**
     * 更具签到号查找
     *
     * @param id 签到号
     * @return 一堆EcStcheck对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<EcStcheck> findEcStcheckByCheckId(Integer id) {
        String hql = "from EcStcheck where checkId=? order by userId ASC";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return query.list();
    }

    /**
     * 其他查找
     *
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcStcheck对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<EcStcheck> findEcStcheck(List<Object> params, String hql) {
        Query query = getSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query.list();
    }

    /**
     * 更新EcStcheck
     *
     * @param ecStcheck 需要更新的EcStcheck持久化对象
     */
    @Override
    public void updateEcStcheck(EcStcheck ecStcheck) {
        getSession().update(ecStcheck);
    }

    /**
     * 删除EcStcheck
     *
     * @param ecStcheck 需要删除的EcStcheck
     */
    @Override
    public void deletEcStcheck(EcStcheck ecStcheck) {
        getSession().delete(ecStcheck);
    }
}
