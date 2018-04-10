package com.ecourse.service;

import com.ecourse.entity.EcStcheck;

import java.util.List;
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-21 下午7:34
 */
public interface EcStcheckService {

    /**
     * 保存
     *
     * @param ecStcheck 保存数据
     */
    public void saveEcStcheck(EcStcheck ecStcheck);

    /**
     * 更具ID查找
     *
     * @param checkId 签到号
     * @param userId  用户账号
     * @return 返回对应的对象，没有查找到为null
     */
    public EcStcheck findEcStcheckById(Integer checkId, Integer userId);

    /**
     * 更具签到号查找
     *
     * @param id key
     * @return 一堆EcStcheck对象
     */
    public List<EcStcheck> findEcStcheckByCheckId(Integer id);

    /**
     * 其他查找
     *
     * @param map 查询的属性
     * @return 一堆EcStcheck对象
     */
    public List<EcStcheck> findEcStcheck(Map<String, Object> map);

    /**
     * 更新EcStcheck
     *
     * @param ecStcheck 需要更新的EcStcheck持久化对象
     */
    public void updateEcStcheck(EcStcheck ecStcheck);

    /**
     * 删除EcStcheck
     *
     * @param ecStcheck 需要删除的EcStcheck
     */
    public void deletEcStcheck(EcStcheck ecStcheck);
}
