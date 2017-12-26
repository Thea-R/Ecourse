package com.ecourse.service;

import com.ecourse.entity.EcQuestion;
import java.util.List;
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-14 下午11:17
 */
public interface EcQuestionService {

    /**
     * 保存
     * @param ecQuestion  保存数据
     */
    public void saveEcQuestion(EcQuestion ecQuestion);

    public EcQuestion findEcQuestionById(Integer id);

    public List<EcQuestion> findEcQuestion(Map<String, Object> map);

    public void updateEcQuestion(EcQuestion ecQuestion);

    public void deletEcQuestion(EcQuestion ecQuestion);
}
