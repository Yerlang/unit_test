package com.erlang.demo.unit_test;

import com.erlang.demo.TestBase;
import com.erlang.demo.unit_test.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test Double
 * Dummy Object
 *
 * @author yj
 * @since 2021-02-10 9:25
 */
public class TestDummy extends TestBase {

    @Autowired
    private StudentService studentService;

    @Test(expected = Error.class)
    public void testAdd() {
        studentService.add(null);
        System.out.println(12);
    }
}
