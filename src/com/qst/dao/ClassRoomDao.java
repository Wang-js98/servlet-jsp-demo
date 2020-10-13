package com.qst.dao;

import com.qst.pojo.ClassRoom;
import com.qst.pojo.Course;

import java.util.List;

public interface ClassRoomDao {
    //添加班级
    public int addClassRoom(ClassRoom classRoom);
    //分页查询所有课程
    public List<ClassRoom> queryClassRoom(int pageNo, int pageSize);
    public List<ClassRoom> queryClassRoom2();
    //根据班级名称查询
    public  List<ClassRoom> queryClassRoomByName(String c_name);
    //查询指定表字段总数
    public int selectCount(String table_name);
    //修改班级信息
    public int updateClassRoom(ClassRoom classRoom);
    //删除班级
    public int deleteClassroomById(Integer c_id);
}
