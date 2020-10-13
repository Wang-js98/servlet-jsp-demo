package com.qst.service;

import com.qst.pojo.Page;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import com.qst.pojo.WorkArrange;

import java.util.List;

public interface TeacherService {

    public void addTeacher(User user,Teacher teacher);
    //查询所有老师
    public Page<Teacher> queryTeachers(int pageNo, int pageSize);

    //根据学历查询老师
    public List<Teacher> queryTeachersByEducation(String education);
    //条件查询
    public List<Teacher> queryTeachersByTags(String t_name,String education);

    //查询工作
    public List<WorkArrange> queryWork(int t_id);

    //修改工作内容
    public void updateWork(int t_id,int course_id,String []c_id);
}
