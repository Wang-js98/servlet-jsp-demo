package com.qst.dao;

import com.qst.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用Dbutils导包
    private QueryRunner queryRunner=new QueryRunner();

    /**
    update方法用来执行Insert\Update\Delete语句
    @return如果返回-1，说明执行失败。返回其它表示影响的函数
    */

    public int update(String sql,Object... args)  {
        Connection connection= JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        }catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection);
        }

    }



    /**
    查询返回一个javabean的sql语句
    @param type 返回的对象类型
    @param sql 执行的sql语句
    @param args sql对应的参数值
    @param <T> 返回的类型的泛型


     */
    public <T>  T queryForOne(Class<T> type ,String sql, Object...args){
        Connection connection= JdbcUtils.getConnection();


        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        }catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection);
        }
    }


    /**
    查询返回多个javabean的sql语句
    @param type 返回的对象类型
    @param sql 执行的sql语句
    @param args sql对应的参数值
    @param <T> 返回的类型的泛型


     */

    public <T> List<T> queryForList(Class<T> type , String sql, Object...args)  {
        Connection connection= JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        }catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection);
        }
    }


    /**
    执行返回一行一列的sql语句
    @param sql 执行的sql语句
    @param args sql对应的参数值
     */


    public Object queryForSingleValue(String sql, Object...args) {
        Connection connection= JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        }catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection);
        }

    }

}
