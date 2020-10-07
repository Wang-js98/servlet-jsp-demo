package com.qst.test;

import com.qst.dao.ClassRoomDao;
import com.qst.dao.impl.ClassRoomDaoImpl;
import com.qst.pojo.ClassRoom;
import org.junit.Test;

import java.util.Date;


public class ClassRoomServiceTest {

    ClassRoomDao classRoomDao=new ClassRoomDaoImpl();
    @Test
    public void addClassRoom() {
        classRoomDao.addClassRoom(new ClassRoom(null,"B软件171",new Date()));
    }

    @Test
    public void queryClassRoom() {
        for (ClassRoom queryClassRoom:classRoomDao.queryClassRoom()){
            System.out.println(queryClassRoom);
        }
    }

    @Test
    public void queryClassRoomByName() {
        classRoomDao.queryClassRoomByName("B软件171");
    }
}