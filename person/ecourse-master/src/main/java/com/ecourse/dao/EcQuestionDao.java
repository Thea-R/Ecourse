package com.ecourse.dao;

import com.ecourse.entity.EcQuestion;
import java.util.List;

public interface EcQuestionDao {

    /**
     * 保存
     * @param ecQuestion  保存数据
     */
    public void saveEcQuestion(EcQuestion ecQuestion);

    /**
     * 更具ID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcQuestion findEcQuestionById(Integer id);

    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql 查找的hql语句
     * @return 一堆EcQuestion对象
     */
    public List<EcQuestion> findEcQuestion(List<Object> params, String hql);

    /**
     * 更新EcQuestion
     * @param ecQuestion 需要更新的EcAnswer持久化对象
     */
    public void updateEcQuestion(EcQuestion ecQuestion);

    /**
     * 删除EcQuestion
     * @param ecQuestion 需要删除的EcQuestion
     */
    public void deletEcQuestion(EcQuestion ecQuestion);
}
