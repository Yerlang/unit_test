package com.erlang.demo.unit_test;

import com.erlang.demo.TestBase;
import com.erlang.demo.unit_test.domain.Student;
import com.erlang.demo.unit_test.service.StudentService;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义断言
 *
 * @author yj
 * @since 2021-02-03 8:44
 */
public class TestCustomAssertions extends TestBase {

    @Autowired
    private StudentService studentService;

    @Test
    public void testEquals() {
        Student s1 = studentService.findById(1);
        Student s2 = studentService.findById(4);
        assertStudentEquals(s1, s2);
    }

    private void assertStudentEquals(Student s1, Student s2) {
        Assert.assertNotNull(s1);
        Assert.assertNotNull(s2);
        Assert.assertEquals(s1.getName(), s2.getName());
        Assert.assertEquals(s1.getAge(), s2.getAge());
    }

    @Before
    public void init() {
        studentService.add(new Student(1, "张三", 10));
        studentService.add(new Student(2, "小明", 10));
        studentService.add(new Student(3, "小红", 10));
        studentService.add(new Student(4, "张三", 10));
    }

    @After
    public void clear() {
        studentService.deleteByIds(Lists.newArrayList(1, 2, 3, 4));
    }
}
