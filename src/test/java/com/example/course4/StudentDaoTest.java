package com.example.course4;

import com.example.course4.Dao.IStudentDao;
import com.example.course4.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentDaoTest {
   @Autowired
    private IStudentDao sDao;

   @Test
   public void insertStudent(){
       Student stu = new Student();
       stu.setAge(23);
       stu.setName("Tom");
       stu.setPassword("567890");
       stu.setSex("男");
       sDao.save(stu);

   }
    @Test
    public void findStudent(){
        List<Student> stuList = sDao.findAll();
        System.out.println(stuList.size());
    }

    @Test
    public void updateNameById(){
        Integer result = sDao.UpdateStudentNameById("Rex",1l);
        System.out.println(result);
    }

    @Test
    public void deleteStudentByNameAndId(){
        sDao.deleteStudentsById(2L);
    }
}
