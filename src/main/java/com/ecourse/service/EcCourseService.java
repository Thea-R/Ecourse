package com.ecourse.service;

import com.ecourse.entity.EcCourse;

import java.util.List;
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-22 下午8:18
 */
public interface EcCourseService {

    public void saveEcCourse(EcCourse ecCourse);

    public EcCourse findEcCourseById(Integer id);

    public List<EcCourse> findEcCourse(Map<String, Object> map);

    public void updateEcCourse(EcCourse ecCourse);

    public void deletEcCourse(EcCourse ecCourse);
}
