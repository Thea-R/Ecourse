package com.ecourse.service.impl;

import com.ecourse.dao.EcSourceDao;
import com.ecourse.entity.EcSource;
import com.ecourse.service.EcSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("EcSource")
public class EcSourceServiceImpl implements EcSourceService {
    @Autowired
    private EcSourceDao ecSourceDao;

    @Override
    public void saveEcSource(EcSource ecSource) {
        ecSourceDao.saveEcSource(ecSource);
    }

    @Override
    public EcSource findEcSourceBySid(Integer id) {
        return ecSourceDao.findEcSourceBySid(id);
    }

    @Override
    public EcSource findEcSourceByCid(Integer id) {
        return ecSourceDao.findEcSourceByCid(id);
    }

    @Override
    public List<EcSource> findEcSource(Map<String, Object> map) {
        StringBuilder hql = new StringBuilder("from EcSource where 1=1 ");
        List<Object> params = new LinkedList<Object>();

        if (map.get("sourceId") != null) {
            hql.append(" and sourceId=? ");
            params.add(map.get("sourceId"));
        }
        if (map.get("courseId") != null) {
            hql.append(" and courseId=? ");
            params.add(map.get("courseId"));
        }
        if (map.get("sourceTitle") != null) {
            hql.append(" and sourceTitle=? ");
            params.add(map.get("sourceTitle"));
        }
        if (map.get("sourceLink") != null) {
            hql.append(" and sourceLink=? ");
            params.add(map.get("sourceLink"));
        }
        if (map.get("sourcePassword") != null) {
            hql.append(" and sourcePassword=? ");
            params.add(map.get("sourcePassword"));
        }
        if (map.get("sourceUnit") != null) {
            hql.append(" and sourceUnit=? ");
            params.add(map.get("sourceUnit"));
        }
        if (map.get("sourceType") != null) {
            hql.append(" and sourceType=? ");
            params.add(map.get("sourceType"));
        }
        if (map.get("sourceNote") != null) {
            hql.append(" and sourceNote=? ");
            params.add(map.get("sourceNote"));
        }
        if (map.get("sourceShare") != null) {
            hql.append(" and sourceShare=? ");
            params.add(map.get("sourceShare"));
        }
        return ecSourceDao.findEcSource(params, hql.toString());
    }

    @Override
    public void updateEcSource(EcSource ecSource) {
        ecSourceDao.updateEcSource(ecSource);
    }

    @Override
    public void deletEcSource(EcSource ecSource) {
        ecSourceDao.deletEcSource(ecSource);
    }

    @Override
    public int getNewSid() {
        return ecSourceDao.getNewSid();
    }
}
