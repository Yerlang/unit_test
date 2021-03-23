package com.erlang.demo.unit_test.test_smell;

import com.erlang.demo.TestBase;
import com.erlang.demo.unit_test.domain.Student;
import com.erlang.demo.unit_test.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yj
 * @since 2021-03-10 9:19
 */
public class StudentServiceTest extends TestBase {

    @Autowired
    private StudentService studentService;

    @Test
    public void testUpdateAgeById1() {
        studentService.add(new Student(1, "张三", 10));
        studentService.add(new Student(2, "小明", 10));
        studentService.add(new Student(3, "小红", 10));
        int age = 20;
        studentService.updateAgeById(age, 1);
        Student student = studentService.findById(1);
        Assert.assertTrue(true);
    }

    @Test(expected = Exception.class)
    public void testUpdateAgeById2() {
        studentService.add(new Student(1, "张三", 10));
        studentService.add(new Student(2, "小明", 10));
        studentService.add(new Student(3, "小红", 10));
        int age = 20;
        studentService.updateAgeById(age, 0);
        Assert.assertTrue(true);
    }

    @Test
    public void testUpdateAgeById3() {
        studentService.add(new Student(1, "张三", 10));
        studentService.add(new Student(2, "小明", 10));
        studentService.add(new Student(3, "小红", 10));
        int age = 20;
        studentService.updateAgeById(age, 0);
        Student student = studentService.findById(0);
        Assert.assertNull(student);
    }
}
