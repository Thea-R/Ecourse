package com.ecourse.service;

import com.ecourse.entity.EcCheck;

import java.util.List;
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-21 上午10:21
 */
public interface EcCheckService {

    public void saveEcCheck(EcCheck ecCheck);

    public EcCheck findEcCheckById(Integer id);

    public List<EcCheck> findEcCheckByCourseId(Integer id);

    public List<EcCheck> findEcCheck(Map<String, Object> map);

    public void updateEcCheck(EcCheck ecCheck);

    public void deletEcCheck(EcCheck ecCheck);
}
