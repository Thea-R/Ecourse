package com.ecourse.service.impl;

import com.ecourse.dao.EcStuandcourseDao;
import com.ecourse.entity.EcStuandcourse;
import com.ecourse.service.EcStuandcourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tomato
 * @create 2017-12-22 下午8:35
 */
@Service("EcStuandcourse")
public class EcStuandcourseServiceImpl implements EcStuandcourseService {

    @Autowired
    private EcStuandcourseDao ecStuandcourseDao;

    @Override
    public void saveEcStuandcourse(EcStuandcourse ecStuandcourse) {
        ecStuandcourseDao.saveEcStuandcourse(ecStuandcourse);
    }

    @Override
    public EcStuandcourse findEcStuandcourseById(Integer courseId, Integer userId) {
        return ecStuandcourseDao.findEcStuandcourseById(courseId, userId);
    }

    @Override
    public List<EcStuandcourse> findEcStuandcourseByCourseId(Integer courseId) {
        return ecStuandcourseDao.findEcStuandcourseByCourseId(courseId);
    }

    @Override
    public List<EcStuandcourse> findEcStuandcourseByUserId(Integer userId) {
        return ecStuandcourseDao.findEcStuandcourseByUserId(userId);
    }

    @Override
    public void updateEcStuandcourse(EcStuandcourse ecStuandcourse) {
        ecStuandcourseDao.updateEcStuandcourse(ecStuandcourse);
    }

    @Override
    public void deletEcStuandcourse(EcStuandcourse ecStuandcourse) {
        ecStuandcourseDao.deletEcStuandcourse(ecStuandcourse);
    }

}
