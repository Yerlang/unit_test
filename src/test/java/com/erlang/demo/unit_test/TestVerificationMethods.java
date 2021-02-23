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
 * 自定义验证方法
 *
 * @author yj
 * @since 2021-02-03 8:50
 */
public class TestVerificationMethods extends TestBase {

    @Autowired
    private StudentService studentService;

    @Test
    public void testDeleteDuplicate() {
        Student s1 = studentService.findById(1);
        Student s2 = studentService.findById(4);
        deleteDuplicate(s1, s2);
    }

    private void deleteDuplicate(Student s1, Student s2) {
        Assert.assertNotNull(s1);
        Assert.assertNotNull(s2);
        Assert.assertEquals(s1.getName(), s2.getName());
        Assert.assertEquals(s1.getAge(), s2.getAge());
        studentService.deleteByIds(Lists.newArrayList(s2.getId()));
        Student existS2 = studentService.findById(s2.getId());
        Assert.assertNull(existS2);
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
