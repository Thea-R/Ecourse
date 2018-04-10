package com.ecourse.service.impl;

import com.ecourse.dao.EcCourseDao;
import com.ecourse.entity.EcCourse;
import com.ecourse.service.EcCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-22 下午8:18
 */
@Service("EcCourse")
public class EcCourseServiceImpl implements EcCourseService {

    @Autowired
    private EcCourseDao ecCourseDao;

    @Override
    public void saveEcCourse(EcCourse ecCourse) {
        ecCourseDao.saveEcCourse(ecCourse);
    }

    @Override
    public EcCourse findEcCourseById(Integer id) {
        return ecCourseDao.findEcCourseById(id);
    }
    @Override
    public List<EcCourse> findEcCourseByuserId(Integer id)
    {
        return ecCourseDao.findEcCourseByuserId(id);
    }

    @Override
    public List<EcCourse> findEcCourse(Map<String, Object> map) {
        StringBuilder hql = new StringBuilder("from EcCourse where 1=1 ");
        List<Object> params = new LinkedList<Object>();
        System.out.println("???"+map.get("userId"));
        if (map.get("userId") != null) {
            hql.append(" and userId=? ");
            params.add(map.get("userId"));
        }
        if (map.get("courseName") != null) {
            hql.append(" and courseName=? ");
            params.add(map.get("courseName"));
        }
        if (map.get("courseNote") != null) {
            hql.append(" and courseNote=? ");
            params.add(map.get("courseNote"));
        }
        if (map.get("courseIcode") != null) {
            hql.append(" and courseIcode=? ");
            params.add(map.get("courseIcode"));
        }//order by time    desc

        System.out.println("???"+map.get("userId"));
        return ecCourseDao.findEcCourse(params, hql.toString());
    }

    @Override
    public void updateEcCourse(EcCourse ecCourse) {
        ecCourseDao.updateEcCourse(ecCourse);
    }

    @Override
    public void deletEcCourse(EcCourse ecCourse) {
        ecCourseDao.deletEcCourse(ecCourse);
    }
}
