package com.erlang.demo.unit_test.service;

import com.erlang.demo.unit_test.domain.Student;

import java.util.List;

/**
 * @author yj
 * @since 2021-01-28 9:08
 */
public interface StudentService {

    /**
     * 根据 id 查询学生信息
     *
     * @param id 学生 id
     * @return 学生信息
     */
    Student findById(int id);

    /**
     * 根据 id 列表查询学生信息
     *
     * @param ids 学生 id 列表
     * @return 学生信息
     */
    List<Student> findByIds(List<Integer> ids);

    /**
     * 新增学生
     *
     * @param student 学生
     */
    void add(Student student);

    /**
     * 更新年龄
     *
     * @param age 年龄
     * @param id  学生 id
     */
    void updateAgeById(int age, int id);

    /**
     * 根据学生 id 删除学生信息
     *
     * @param ids 学生 id 列表
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 查询素有学生信息
     *
     * @param teacherId 老师 id
     * @return 学生信息
     */
    List<Student> findAllStudentByTeacherId(int teacherId);

}
