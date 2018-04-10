package com.ecourse.dao;

import com.ecourse.entity.EcSource;
import java.util.List;

public interface EcSourceDao {
    /**
     * 保存
     * @param ecSource 保存数据
     */
    public void saveEcSource(EcSource ecSource);

    /**
     * 根据SID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcSource findEcSourceBySid(Integer id);

    /**
     * 根据CID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcSource findEcSourceByCid(Integer id);

    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql    查找的hql语句
     * @return 一堆EcAnswer对象
     */
    public List<EcSource> findEcSource(List<Object> params, String hql);

    /**
     * 更新
     * @param ecSource 需要更新的持久化对象
     */
    public void updateEcSource(EcSource ecSource);

    /**
     * 删除
     * @param ecSource 需要删除的对象
     */
    public void deletEcSource(EcSource ecSource);

    public int getNewSid();
}
