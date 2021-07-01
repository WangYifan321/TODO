# ToDo应用restfulAPI

### 查询所有（首页）

```
method GET path /todos
```

返回参数：

{

"content":"吃饭",

"list_state":0,

}

content  string  待办事项的内容

list_state int      待办事项的状态，默认为1，表示未完成

### 更新单个

```
method PUT path /todos/{ID}
```

{

"content":"吃饭",

"list_state":1,

}

### 插入便签

```
method POST path /todos 创建一个新的便签，并返回到首页
传入参数：
{
    “content”：'吃饭'
}
```

返回状态码，成功或失败

### 删除便签

```
method DELETE path /todos/{ID}
```

返回状态码，成功或失败

### 统计个数

```
method GET path /todos/count    默认返回未完成
```

{

"list_num":9

}

返回参数

int count

##  状态码

200 OK GET 服务器成功返回用户请求的数据

204删除成功

201 CREATED POST/PUT 用户新建数据成功

400失败

