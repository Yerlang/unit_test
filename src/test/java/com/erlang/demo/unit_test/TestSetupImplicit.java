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
 * Implicit Setup
 *
 * @author yj
 * @since 2021-02-01 8:21
 */
public class TestSetupImplicit extends TestBase {

    @Autowired
    private StudentService studentService;

    @Test
    public void testFindById() {
        Student student = studentService.findById(1);
        Assert.assertNotNull(student);
        Assert.assertEquals(student.getName(), "张三");
    }

    @Test
    public void testUpdate() {
        int age = 20;
        studentService.updateAgeById(age, 1);
        Student student = studentService.findById(1);
        Assert.assertNotNull(student);
        Assert.assertEquals(age, student.getAge());
    }

    @Before
    public void setup() {
        studentService.add(new Student(1, "张三", 10));
        studentService.add(new Student(2, "小明", 10));
        studentService.add(new Student(3, "小红", 10));
    }

    @After
    public void teardown() {
        studentService.deleteByIds(Lists.newArrayList(1, 2, 3));
    }
}
