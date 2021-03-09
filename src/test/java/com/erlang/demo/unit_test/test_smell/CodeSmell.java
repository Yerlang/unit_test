package com.erlang.demo.unit_test.test_smell;

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
 * @author yj
 * @since 2021-03-08 8:49
 */
public class CodeSmell extends TestBase {

    @Autowired
    private StudentService studentService;

    @Test
    public void testUpdateAgeById() {
        int id = 1;
        int age = 20;
        studentService.updateAgeById(20, id);
        Student student = studentService.findById(id);
        Assert.assertNotNull(student);
        Assert.assertEquals(student.getAge(), age);
    }

    @Test
    public void testUpdateAgeById_condition_logic() {
        int id = 1;
        int age = 20;
        studentService.updateAgeById(20, id);
        Student student = studentService.findById(id);
        if (student != null) {
            Assert.assertEquals(student.getAge(), age);
        }
    }

    @Test
    public void testUpdateNameById() {
        int id = 1;
        String name = "哇哈哈哈";
        studentService.updateNameById(name, id);
        Student student = studentService.findById(id);
        Assert.assertNotNull(student);
        Assert.assertEquals(student.getName(), "test");
    }

    @Test
    public void testEqualsAndUpdateAge() {
        Student s1 = studentService.findById(1);
        Student s2 = studentService.findById(4);
        assertStudentEquals(s1, s2);

        int id = 1;
        int age = 20;
        studentService.updateAgeById(20, id);
        Student student = studentService.findById(id);
        Assert.assertNotNull(student);
        Assert.assertEquals(student.getAge(), age);
    }

    private void assertStudentEquals(Student s1, Student s2) {
        Assert.assertNotNull(s1);
        Assert.assertNotNull(s2);
        Assert.assertEquals(s1.getName(), s2.getName());
        Assert.assertEquals(s1.getAge(), s2.getAge());
    }


    @Before
    public void setup() {
        studentService.add(new Student(1, "张三", 10));
        studentService.add(new Student(2, "小明", 10));
        studentService.add(new Student(3, "小红", 10));
        studentService.add(new Student(4, "张三", 10));

    }


    @After
    public void teardown() {
        studentService.deleteByIds(Lists.newArrayList(1, 2, 3, 4));
    }
}
