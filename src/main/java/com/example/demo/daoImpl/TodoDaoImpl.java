package com.example.demo.daoImpl;

import com.example.demo.dao.TodoDao;
import com.example.demo.entity.Todo;
import com.example.demo.util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TodoDaoImpl implements TodoDao {
    @Override
    public ArrayList<Todo> getAll() {
        ArrayList<Todo> list = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql = "select * from list order by state";
            Object[] param=null;
            rs = DBUtil.executeQuery(sql, null);
            while(rs.next()){
                Todo todo = new Todo(rs.getInt("id"),rs.getString("content"),rs.getInt("state"));
                list.add(todo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs,DBUtil.pst,DBUtil.connection);
        }
        return list;
    }

    @Override
    public boolean updateOne(int id) {

            String sql = "update list set state = ? where id =?";
            int a =2;
            Object[] params = {a,id};
            return DBUtil.executeUpdate(sql,params);

    }

    @Override
    public boolean insertOne(Todo todo) {
        String sql = "insert into list (content) values (?)";
        Object[] param = {todo.getContent()};
        return DBUtil.executeUpdate(sql,param);
    }

    @Override
    public boolean deleteOne(int id) {
        String sql = "delete from list where id = ?";
        Object[] param = {id};
        return DBUtil.executeUpdate(sql,param);    }

    @Override
    public int count() {
        int count = -1;
        ResultSet rs = null;
        try{
            String sql = "select count(*) from list where state = ?";
            int a=1;
            Object[] param={a};
            rs = DBUtil.executeQuery(sql,param);
            if(rs.next()){
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs,DBUtil.pst,DBUtil.connection);
        }
        return count;
    }

}
