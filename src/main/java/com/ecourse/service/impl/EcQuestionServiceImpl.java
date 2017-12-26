package com.ecourse.service.impl;

import com.ecourse.dao.EcQuestionDao;
import com.ecourse.entity.EcQuestion;
import com.ecourse.service.EcQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuxuan on 17/12/22.
 */
@Service("EcQuestion")
public class EcQuestionServiceImpl implements EcQuestionService {

    @Autowired
    private EcQuestionDao ecQuestionDao;

    @Override
    public void saveEcQuestion(EcQuestion ecQuestion) {
        ecQuestionDao.saveEcQuestion(ecQuestion);
    }

    @Override
    public EcQuestion findEcQuestionById(Integer id) {
        return ecQuestionDao.findEcQuestionById(id);
    }

    @Override
    public List<EcQuestion> findEcQuestion(Map<String, Object> map) {
        StringBuilder hql = new StringBuilder("from EcQuestion where 1=1 ");
        List<Object> params = new LinkedList<Object>();

        if (map.get("queId") != null) {
            hql.append(" and queId=? ");
            params.add(map.get("queId"));
        }
        if (map.get("courseId") != null) {
            hql.append(" and courseId=? ");
            params.add(map.get("courseId"));
        }
        if (map.get("queType") != null) {
            hql.append(" and queType=? ");
            params.add(map.get("queType"));
        }
        if (map.get("queState") != null) {
            hql.append(" and queState=? ");
            params.add(map.get("queState"));
        }
        if (map.get("queAns") != null) {
            hql.append(" and queAns=? ");
            params.add(map.get("queAns"));
        }
        if (map.get("queTitle") != null) {
            hql.append(" and queTitle=? ");
            params.add(map.get("queTitle"));
        }
        if (map.get("queTime") != null) {
            hql.append(" and queTime=? ");
            params.add(map.get("queTime"));
        }
        //System.out.println(hql.toString());
        return ecQuestionDao.findEcQuestion(params, hql.toString());
    }

    @Override
    public void updateEcQuestion(EcQuestion ecQuestion) {
        ecQuestionDao.updateEcQuestion(ecQuestion);
    }

    @Override
    public void deletEcQuestion(EcQuestion ecQuestion) {
        ecQuestionDao.deletEcQuestion(ecQuestion);
    }
}
