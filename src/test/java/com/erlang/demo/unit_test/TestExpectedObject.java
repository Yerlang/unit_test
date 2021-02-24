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
 * 使用对象比较，优化测试代码
 *
 * @author yj
 * @since 2021-02-02 8:44
 */
public class TestExpectedObject extends TestBase {

    @Autowired
    private StudentService studentService;

    /**
     * 对比对象的属性是否相等，判断两个对象是否相等
     */
    @Test
    public void testEquals_Property() {
        Student s1 = studentService.findById(1);
        Student s2 = studentService.findById(4);

        Assert.assertNotNull(s1);
        Assert.assertNotNull(s2);
        Assert.assertEquals(s1.getName(), s2.getName());
        Assert.assertEquals(s1.getAge(), s2.getAge());
    }

    /**
     * 重写对象的 hashCode、equals 方法后，直接对比两个对象对比
     */
    @Test
    public void testEquals_Object() {
        Student s1 = studentService.findById(1);
        Student s2 = studentService.findById(4);

        Assert.assertNotNull(s1);
        Assert.assertNotNull(s2);
        Assert.assertEquals(s1, s2);
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
