package com.example.course4.Dao;

import com.example.course4.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

//当我们需要定义自己的Repository接口的时候，我们可以直接继承JpaRepository，
// 从而获得SpringBoot Data JPA为我们内置的多种基本数据操作方法，
public interface IStudentDao extends JpaRepository<Student,Long> {
//    根据name和password查询并返回学生对象
    Student findStudentByNameAndPassword(String name,String password);
    Student findStudentById(Long id);
//    使用@Transactional的相比传统的我们需要手动开启事务，然后提交事务来说。它提供如下方便
//根据你的配置，设置是否自动开启事务
//自动提交事务或者遇到异常自动回滚
    @Transactional
    void deleteStudentsById(Long id);
//    @Query 与 @ Modifying 这 两 个 annotation 一起声明，可定义个性化更新操作，
    @Transactional
    @Modifying
    @Query("update Student s set s.name = ?1 where s.id = ?2")
    int UpdateStudentNameById(String name,Long id);
}
