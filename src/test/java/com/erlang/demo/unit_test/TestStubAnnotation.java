package com.erlang.demo.unit_test;

import com.erlang.demo.TestBase;
import com.erlang.demo.unit_test.domain.Student;
import com.erlang.demo.unit_test.service.TeacherService;
import com.erlang.demo.unit_test.service.impl.StudentServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Test Double
 * test stub
 *
 * @author yj
 * @since 2021-02-18 8:01
 */
public class TestStubAnnotation extends TestBase {

    @Autowired
    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private TeacherService teacherService;

    List<Student> students = Lists.newArrayList();

    @Before
    public void before() {
        MockitoAnnotations.openMocks(this);

        students.add(new Student(1, "张三", 10));
        students.add(new Student(2, "小明", 10));
        students.add(new Student(3, "小红", 10));

        Mockito.when(teacherService.findAllStudentById(1))
                .thenReturn(students);

    }

    @Test
    public void testFindAll() {
        List<Student> studentList = studentService.findAllStudentByTeacherId(1);
        Assert.assertNotNull(studentList);
        Assert.assertSame(studentList, students);
    }
}
