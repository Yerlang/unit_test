package com.erlang.demo.unit_test;

import com.erlang.demo.TestBase;
import com.erlang.demo.unit_test.domain.Student;
import com.erlang.demo.unit_test.service.StudentService;
import org.assertj.core.util.Lists;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Teardown 和 SetUp 一样也有三种实现方式
 * <p>
 * In-line Fixture Teardown
 * Delegated Teardown
 * Implicit Teardown
 * <p>
 * 这里仅实现 Implicit Teardown
 *
 * @author yj
 * @since 2021-02-02 8:38
 */
public class TestShareFuture extends TestBase {

    @Autowired
    private StudentService studentService;

    @Test
    public void testFindById() {
        System.out.println("run testFindById...");
    }

    @Test
    public void testUpdate() {
        System.out.println("run testUpdate...");
    }

    @BeforeClass
    public static void setup() {
        System.out.println("run setup...");
    }

    @AfterClass
    public static void teardown() {
        System.out.println("run teardown...");
    }

}
