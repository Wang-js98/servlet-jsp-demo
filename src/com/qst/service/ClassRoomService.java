package com.qst.service;

import com.qst.pojo.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    //添加班级
    public int addClassRoom(ClassRoom classRoom);
    //查询所有班级
    public List<ClassRoom> queryClassRoom();
    //根据班级名称查询
    public ClassRoom queryClassRoomByName(String c_name);
}
