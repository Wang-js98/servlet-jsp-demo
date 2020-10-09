package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.CourseDao;
import com.qst.pojo.Course;

import java.util.List;

public class CourseDaoImpl extends BaseDao implements CourseDao {

    @Override
    public int addCourse(Course course) {
        String sql="insert into course(c_name,description,createTime) values(?,?,?)";
        return update(sql,course.getC_name(),course.getDescription(),course.getCreateTime());
    }

    @Override
    public List<Course> queryCourse() {
        String sql="select course_id,c_name,description,createTime from course";
        return queryForList(Course.class,sql);
    }

    @Override
    public Course queryByCourseName(String c_name) {
        String sql="select course_id,c_name,description,createTime from course WHERE c_name=?";
        return queryForOne(Course.class,sql,c_name);
    }
    @Override
    public int deleteCourseById(Integer course_id) {
        String sql="delete from course where course_id=?";
        return update(sql,course_id);
    }

    @Override
    public int updateCourse(Course course) {
        String sql="update course set `c_name`=?,`description`=?,`createTime`=? where course_id=?";
        return update(sql,course.getC_name(),course.getDescription(),course.getCreateTime(),course.getCourse_id());
    }
}
