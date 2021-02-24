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
 * 验证时，不要使用一些条件相关的逻辑！比如，不要使用 if 之类的语句！
 *
 * @author yj
 * @since 2021-02-04 8:41
 */
public class TestAvoidingConditional extends TestBase {

    @Autowired
    private StudentService studentService;

    /**
     * 使用 if 的情况，该测试方法中，验证中有判断逻辑意味着可能测试案例不够单一，增加案例的理解难度
     */
    @Test
    public void testEquals_if() {
        int sid = 1;
        Student student = studentService.findById(sid);
        if (student != null) {
            Assert.assertEquals(student.getName(), "张三");
        } else {
            System.err.println("student is null for id = " + sid);
        }
    }

    /**
     * 正确的写法应该是这样的
     */
    @Test
    public void testEquals() {
        int sid = 1;
        Student student = studentService.findById(sid);
        Assert.assertNotNull(student);
        Assert.assertEquals(student.getName(), "张三");
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
