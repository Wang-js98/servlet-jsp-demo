package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.ClassRoomDao;
import com.qst.pojo.ClassRoom;

import java.util.List;

public class ClassRoomDaoImpl extends BaseDao implements ClassRoomDao {
    @Override
    public int addClassRoom(ClassRoom classRoom) {
        String sql="insert into classroom(c_name,createTime) values(?,?)";
        return update(sql,classRoom.getC_name(),classRoom.getCreateTime());
    }

    @Override
    public List<ClassRoom> queryClassRoom() {
        String sql="select c_id,c_name,createTime from classroom";
        return queryForList(ClassRoom.class,sql);
    }

    @Override
    public ClassRoom queryClassRoomByName(String c_name) {
        String sql="select c_id,c_name,createTime from classroom where c_name=?";
        return queryForOne(ClassRoom.class,sql,c_name);
    }
}
