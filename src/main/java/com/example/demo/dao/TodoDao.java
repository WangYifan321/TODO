package com.example.demo.dao;

import com.example.demo.entity.Todo;

import java.util.ArrayList;

public interface TodoDao {
    public ArrayList<Todo> getAll();
    public boolean updateOne(int id);
    public boolean insertOne(Todo todo);
    public boolean deleteOne(int id);
    public int count();
}
