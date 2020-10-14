package com.qst.service.impl;

import com.qst.dao.ClassRoomDao;
import com.qst.dao.StudentDao;
import com.qst.dao.impl.ClassRoomDaoImpl;
import com.qst.dao.impl.StudentDaoImpl;
import com.qst.pojo.ClassRoom;
import com.qst.pojo.Course;
import com.qst.pojo.Page;
import com.qst.pojo.Student;
import com.qst.service.ClassRoomService;

import java.util.List;

public class ClassRoomServiceImpl implements ClassRoomService {


    ClassRoomDao classRoomDao=new ClassRoomDaoImpl();
    @Override
    public int addClassRoom(ClassRoom classRoom) {

        return classRoomDao.addClassRoom(classRoom);
    }

    @Override
    public List<ClassRoom> queryClassRoom2() {
        return classRoomDao.queryClassRoom2();
    }

    @Override
    public Page<ClassRoom> queryClassRoom(int pageNo, int pageSize) {
        List<ClassRoom> classRooms = classRoomDao.queryClassRoom(pageNo,pageSize);
        int total = classRoomDao.selectCount("classroom");
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;

        Page<ClassRoom> page = new Page<ClassRoom>();
        page.setCurrentPage(pageNo);
        page.setData(classRooms);
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public Page<ClassRoom> queryClassRoomByName(String c_name) {
        List<ClassRoom> classRooms = classRoomDao.queryClassRoomByName(c_name);
        int total = classRoomDao.selectCount("classroom");
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;

        Page<ClassRoom> page = new Page<ClassRoom>();
        page.setCurrentPage(1);
        page.setData(classRooms);
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public int updateClassRoom(ClassRoom classRoom) {
        return classRoomDao.updateClassRoom(classRoom);
    }

    @Override
    public int deleteClassroomById(Integer c_id) {
        StudentDao studentDao=new StudentDaoImpl();
        List<Student> list = studentDao.queryByCid(c_id);
        if(list.isEmpty()) {
            classRoomDao.deleteClassroomById(c_id);
            return 1;
        }else{
            return 0;
        }
    }
}
