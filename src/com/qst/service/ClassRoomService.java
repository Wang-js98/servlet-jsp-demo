package com.qst.service;

import com.qst.pojo.ClassRoom;
import com.qst.pojo.Page;

import java.util.List;

public interface ClassRoomService {
    //添加班级
    public int addClassRoom(ClassRoom classRoom);
    //分页查询所有班级
    public Page<ClassRoom> queryClassRoom(int pageNo, int pageSize);
    //根据班级名称查询
    public Page<ClassRoom> queryClassRoomByName(String c_name);
    //修改班级信息
    public int updateClassRoom(ClassRoom classRoom);
    //删除班级
    public int deleteClassroomById(Integer c_id);
}
