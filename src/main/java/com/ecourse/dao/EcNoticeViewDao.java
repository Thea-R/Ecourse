package com.ecourse.dao;

import com.ecourse.entity.EcNotice;
import com.ecourse.entity.EcNoticeView;

import java.util.List;

public interface EcNoticeViewDao {
    /**
     * 保存
     * @param ecNoticeView 保存数据
     */
    public void saveEcNoticeView(EcNoticeView ecNoticeView);

    /**
     * 更具ID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcNoticeView findEcNoticeViewById(Integer id);

    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql 查找的hql语句
     * @return 一堆EcNotice对象
     */
    public List<EcNoticeView> findEcNoticeView(List<Object> params, String hql);

    /**
     * 更新EcAnswer
     * @param ecNoticeView 需要更新的EcNoticeView持久化对象
     */
    public void updateEcNoticeView(EcNoticeView ecNoticeView);

    /**
     * 删除EcAnswer
     * @param ecNoticeView 需要删除的EcNoticeView
     */

    public void deleteEcNoticeView(EcNoticeView ecNoticeView);
}
