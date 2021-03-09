package com.erlang.demo.unit_test.service.impl;

import com.erlang.demo.unit_test.domain.Student;
import com.erlang.demo.unit_test.service.TeacherService;
import com.erlang.demo.unit_test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yj
 * @since 2021-01-29 8:50
 */
@Service
public class StudentServiceImpl implements StudentService {

    private List<Student> students = new ArrayList<>();

    @Autowired
    private TeacherService teacherService;

    @Value("${test_use}")
    private String testUse;

    @Override
    public Student findById(int id) {
        return students.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateNameById(String name, int id) {
        Student student = students.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findFirst()
                .orElse(null);
        if (student == null) {
            throw new RuntimeException("学生不存在");
        }
        if ("test".equals(testUse)) {
            name = "test";
        }
        student.setName(name);
    }

    @Override
    public List<Student> findByIds(List<Integer> ids) {
        return students.stream()
                .filter(s -> ids.contains(s.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Student student) {
        if (student == null) {
            throw new Error("参数不能为空！");
        }
        students.add(student);
    }

    @Override
    public void updateAgeById(int age, int id) {
        Student student = students.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findFirst()
                .orElse(null);
        if (student == null) {
            throw new RuntimeException("学生不存在");
        }
        student.setAge(age);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        Iterator<Student> sIte = students.iterator();
        while (sIte.hasNext()) {
            Student student = sIte.next();
            if (ids.contains(student.getId())) {
                sIte.remove();
            }
        }
    }

    @Override
    public List<Student> findAllStudentByTeacherId(int teacherId) {
        return teacherService.findAllStudentById(teacherId);
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
