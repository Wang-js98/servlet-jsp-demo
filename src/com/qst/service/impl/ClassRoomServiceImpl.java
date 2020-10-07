package com.qst.service.impl;

import com.qst.dao.ClassRoomDao;
import com.qst.dao.impl.ClassRoomDaoImpl;
import com.qst.pojo.ClassRoom;
import com.qst.service.ClassRoomService;

import java.util.List;

public class ClassRoomServiceImpl implements ClassRoomService {


    ClassRoomDao classRoomDao=new ClassRoomDaoImpl();
    @Override
    public int addClassRoom(ClassRoom classRoom) {
        return classRoomDao.addClassRoom(classRoom);
    }

    @Override
    public List<ClassRoom> queryClassRoom() {
        return classRoomDao.queryClassRoom();
    }

    @Override
    public ClassRoom queryClassRoomByName(String c_name) {
        return classRoomDao.queryClassRoomByName(c_name);
    }
}
