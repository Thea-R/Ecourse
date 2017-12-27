package com.ecourse.dao;
import com.ecourse.entity.EcUnderstandSelect;

import java.util.List;
public interface EcUnderstandSelectDao {
    /**
     * 保存
     * @param ecUnderstandSelect  保存数据
     */
    public void saveEcUnderstandSelect(EcUnderstandSelect ecUnderstandSelect);

    /**
     * 更具ID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcUnderstandSelect findEcUnderstandSelectById(Integer id);


    /**
     * 更具ID和密码进行登陆
     * @param id key
     * @return ID正确，返回ID对应的对象，没有查找到为null
     */
    public EcUnderstandSelect findEcUnderstandSelectByUId(Integer id);



    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql 查找的hql语句
     * @return 一堆EcUser对象
     */
    public List<EcUnderstandSelect> findEcUnderstandSelect(List<Object> params, String hql);

    /**
     * 更新EcUnderstand
     * @param ecUnderstandSelect EcUnderstandSelect
     */
    public void updateEcUnderstandSelect(EcUnderstandSelect ecUnderstandSelect);

    /**
     * 删除EcUnderstandSelect
     * @param ecUnderstandSelect 需要删除的EcUnderstand
     */
    public void deletEcUnderstandSelect(EcUnderstandSelect ecUnderstandSelect);
}
