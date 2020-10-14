package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.ClassRoomDao;
import com.qst.pojo.ClassRoom;
import com.qst.pojo.Course;

import java.util.List;

public class ClassRoomDaoImpl extends BaseDao implements ClassRoomDao {
    @Override
    public List<ClassRoom> queryClassRoom2() {
        String sql="select c_id,c_name,createTime from classroom ";
        return queryForList(ClassRoom.class,sql);
    }

    @Override
    public int addClassRoom(ClassRoom classRoom) {
        String sql="insert into classroom(c_name,createTime) values(?,now())";
        return update(sql,classRoom.getC_name());
    }

    @Override
    public List<ClassRoom> queryClassRoom(int pageNo, int pageSize) {
        int dataNum =( pageNo-1)*pageSize;
        String sql="select c_id,c_name,createTime from classroom limit "+dataNum+","+pageSize;
        return queryForList(ClassRoom.class,sql);
    }

    @Override
    public List<ClassRoom>  queryClassRoomByName(String c_name) {
        String sql="select c_id,c_name,createTime from classroom where c_name=?";
        return queryForList(ClassRoom.class,sql,c_name);
    }

    @Override
    public int selectCount(String table_name) {
        String sql="SELECT COUNT(*) FROM "+table_name;
        Number count= (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public int updateClassRoom(ClassRoom classRoom) {
        String sql="update classroom set c_name=? where c_id=?";
        return update(sql,classRoom.getC_name(),classRoom.getC_id());
    }

    @Override
    public int deleteClassroomById(Integer c_id) {

        String sql="delete from classroom where c_id=?";
        return update(sql,c_id);
    }
}
