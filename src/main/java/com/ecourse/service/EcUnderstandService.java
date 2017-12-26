package com.ecourse.service;

import com.ecourse.entity.EcUnderstand;

import java.util.List;
import java.util.Map;

public interface EcUnderstandService {

    /**
     * 保存
     * @param ecUnderstand  保存数据
     */
    public void saveEcUnderstand(EcUnderstand ecUnderstand);

    /**
     * 更具ID查找
     * @param id key
     * @return 返回ID对应的对象，没有查找到为null
     */
    public EcUnderstand findEcUnderstandById(Integer id);


    /**
     * 更具ID和密码进行登陆
     * @param id key
     * @return ID正确，返回ID对应的对象，没有查找到为null
     */
    public EcUnderstand findEcUnderstandByCId(Integer id);





    /**
     * 其他查找
     * @param params 查找的属性
     * @param hql 查找的hql语句
     * @return 一堆EcUser对象
     */
    public List<EcUnderstand> findEcUnderstand(Map<String, Object> map);

    /**
     * 更新EcUnderstand
     * @param ecUnderstand EcUnderstand
     */
    public void updateEcUnderstand(EcUnderstand ecUnderstand);

    /**
     * 删除EcUnderstand
     * @param ecUnderstand 需要删除的EcUnderstand
     */
    public void deletEcUnderstand(EcUnderstand ecUnderstand);
}
