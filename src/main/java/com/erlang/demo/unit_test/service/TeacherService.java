package com.erlang.demo.unit_test.service;

import com.erlang.demo.unit_test.domain.Student;
import com.erlang.demo.unit_test.domain.Teacher;

import java.util.List;

/**
 * @author yj
 * @since 2021-02-18 9:18
 */
public interface TeacherService {

    /**
     * 根据学校 id 查询所有学生
     *
     * @param id teacher id
     * @return 老师的学生列表
     */
    List<Student> findAllStudentById(int id);

    /**
     * 根据 id 查询老师
     *
     * @param id 老师 id
     * @return 老师
     */
    Teacher findById(int id);

    /**
     * 新增
     *
     * @param teacher 老师
     */
    void add(Teacher teacher);

    /**
     * 布置作业
     *
     * @param teacherId teacher id
     * @param studentId student id
     */
    void setHomework(int teacherId, int studentId);

    /**
     * 根据老师 id 删除老师信息
     *
     * @param ids 老师 id 列表
     */
    void deleteByIds(List<Integer> ids);
}
