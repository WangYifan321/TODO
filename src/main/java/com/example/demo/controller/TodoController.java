package com.example.demo.controller;

import com.example.demo.dao.TodoDao;
import com.example.demo.daoImpl.TodoDaoImpl;
import com.example.demo.entity.Todo;
import com.example.demo.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/todos")
public class TodoController {
    TodoDao td = new TodoDaoImpl();


    @GetMapping(path = "/",produces = "application/json;charset=UTF-8")
    @CrossOrigin(origins = "*",maxAge = 3600)
    public ArrayList<Todo> getAll(){
        return td.getAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/count",produces = "application/json")
    @ResponseBody
    @CrossOrigin(origins = "*",maxAge = 3600)
    public Map<String,String> getCount(){
        Map<String,String> map = new HashMap<>();
        String str = Integer.toString(td.count());
        map.put("count",str);
        return map;
    }

   @RequestMapping(method = RequestMethod.POST,value = "/",produces = "application/json;charset=UTF-8",consumes = "application/json;charset=UTF-8")
   @ResponseBody
   @CrossOrigin(origins = "*",maxAge = 3600)
   public void insertOne(@RequestBody Todo todo, HttpServletResponse response){
    System.out.println(todo);

    if(td.insertOne(todo)){
            response.setStatus(201);
        }else{
            response.setStatus(400);
        }
    }
    @DeleteMapping(path = "/{id}",produces = "application/json")
    @CrossOrigin(origins = "*",maxAge = 3600)
    public void deleteOne(@PathVariable String id, HttpServletResponse response){
        int x = Integer.parseInt(id);
        if(td.deleteOne(x)){
            response.setStatus(204);
        }else{
            response.setStatus(400);
        }
    }
    @PatchMapping(path = "/{id}",produces = "application/json")
    @CrossOrigin(origins = "*",maxAge = 3600)
    public void updateOne(@PathVariable String id, HttpServletResponse response){
        int x;
        x = Integer.parseInt(id+"");
        if(td.updateOne(x)){
            response.setStatus(200);
        }else{
            response.setStatus(400);
        }
    }

}
