package com.erlang.demo.unit_test.service.impl;

import com.erlang.demo.unit_test.domain.DingTalkMessage;
import com.erlang.demo.unit_test.domain.Student;
import com.erlang.demo.unit_test.domain.Teacher;
import com.erlang.demo.unit_test.service.DingTalkService;
import com.erlang.demo.unit_test.service.StudentService;
import com.erlang.demo.unit_test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author yj
 * @since 2021-02-18 9:18
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private DingTalkService dingTalkService;

    @Autowired
    private StudentService studentService;

    private List<Teacher> teachers = new ArrayList<>();

    @Override
    public List<Student> findAllStudentById(int id) {

        Teacher teacher = this.findById(id);

        if (teacher == null) {
            return null;
        }

        return  studentService.findByIds(teacher.getStudentIds());
    }

    @Override
    public Teacher findById(int id) {
        return teachers.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Teacher teacher) {
        if (teacher == null) {
            return;
        }
        teachers.add(teacher);
    }

    @Override
    public void setHomework(int teacherId, int studentId) {
        Teacher teacher = this.findById(teacherId);

        if (teacher == null) {
            return;
        }

        Student student = studentService.findById(studentId);
        if (student == null) {
            return;
        }

        DingTalkMessage message = new DingTalkMessage();
        message.setText(String.format("%s老师布置了%s作业给%s", teacher.getName(), teacher.getCourse(), student.getName()));
        dingTalkService.sendNotice(message);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        Iterator<Teacher> sIte = teachers.iterator();
        while (sIte.hasNext()) {
            Teacher teacher = sIte.next();
            if (ids.contains(teacher.getId())) {
                sIte.remove();
            }
        }
    }
}
