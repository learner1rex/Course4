package com.example.course4.Service;

import com.example.course4.Dao.IStudentDao;
import com.example.course4.Entity.Student;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "学生管理相关接口")
@CrossOrigin(allowedHeaders = {"*"})
@RequestMapping("/student")
public class StudentApi {
//    @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
    @Autowired
    private IStudentDao sDao;

//    @GetMapping(value = "/login")
//    @CrossOrigin
//    public Student login(@PathVariable String name, @PathVariable String password){
//        Student stu = sDao.findStudentByNameAndPassword(name,password);
//        if(stu == null){
//            return null;
//        }
//        else{
//            return stu;
//        }
//    }

//    get方法
    @GetMapping("/get")
    public List<Student> getAll(){
        List<Student> list =  sDao.findAll();
        if (list == null){
            return null;
        }else{
            return list;
        }
    }


//post
    @PostMapping(value = "/login")
    @ApiOperation("学生登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",defaultValue = "null",required = true),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "null",required = true),
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    })
    public int login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
        Student stu = sDao.findStudentByNameAndPassword(name,password);

        if (stu != null){
            return 1;
        }else {
            return 0;
        }

    }
    @ApiOperation("学生注册")
    @ApiImplicitParam(name = "stu",value = "学生信息JSON数据",required = true)
    @ApiResponse(code = 100,message = "操作成功",response = Boolean.class)
    @PostMapping(value = "/register")
    public boolean registerStudent(@RequestBody Student stu){
        try{
            sDao.save(stu);
        }catch (Exception e){
            return false;
        }
        return true;
    }
/*
把json对象传到该方法
注意：save方法机制，会根据主键查找数据库
当数据库中没有对应的数据时，进行的是新增操作
有对应的数据时，进行的更新操作
 */
    @PutMapping("/update")
    public boolean updateStudent(@RequestBody Student stu){
        try{
            sDao.save(stu);
        }catch (Exception e){
            return false;
        }
        return true;
    }
//把id作为参数进行删除操作
    @PostMapping ("/delete")
    public boolean deleteStudent(@RequestParam(value="id") Long id){
        try{
            sDao.deleteStudentsById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
