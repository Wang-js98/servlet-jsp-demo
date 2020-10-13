package com.qst.dao;

import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import com.qst.pojo.WorkArrange;

import java.util.List;

public interface TeacherDao {

    //添加用户
    public int addUser(User user) ;
    //添加老师
    public int addTeacher(Teacher teacher);
    //查询所有老师
    public List<Teacher> queryTeachers(int pageNo, int pageSize);
    //根据用户名查询老师
    public List<Teacher> queryByTeacherName(String t_name);

    //根据学历查询老师
    public List<Teacher> queryTeachersByEducation(String education);

    //根据姓名和学历查询
    public List<Teacher> queryTeachersByTags(String t_name,String education);


    //查询工作安排
    public List<WorkArrange> searchWork(int t_id);

    //更新教师表的课程id
    public int updateTeaCourse(int t_id,int course_id);

    //删除教师-教室表旧数据
    public int deleteTeaClass(int t_id);

    //添加教师-教室表新数据
    public int insertTeaClass(int t_id,int c_id);
}
