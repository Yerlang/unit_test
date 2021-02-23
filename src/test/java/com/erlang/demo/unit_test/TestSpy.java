package com.erlang.demo.unit_test;

import com.erlang.demo.AopReflectUtils;
import com.erlang.demo.TestBase;
import com.erlang.demo.unit_test.domain.DingTalkMessage;
import com.erlang.demo.unit_test.domain.Student;
import com.erlang.demo.unit_test.domain.Teacher;
import com.erlang.demo.unit_test.service.DingTalkService;
import com.erlang.demo.unit_test.service.StudentService;
import com.erlang.demo.unit_test.service.impl.TeacherServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test Double
 * Test Spy
 *
 * @author yj
 * @since 2021-02-22 8:44
 */
public class TestSpy extends TestBase {

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private StudentService studentService;

    @Spy
    private DingTalkService dingTalkService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        studentService.add(new Student(1, "张三", 10));
        studentService.add(new Student(2, "小明", 10));
        studentService.add(new Student(3, "小红", 10));

        teacherService.add(new Teacher(1, "默", 30, "数学", Lists.newArrayList(1, 2)));

        AopReflectUtils.setObjectTargetField(teacherService, dingTalkService, "dingTalkService");
    }

    @Test
    public void testSetHomework() {
        teacherService.setHomework(1, 1);
        ArgumentCaptor<DingTalkMessage> argCaptor = ArgumentCaptor.forClass(DingTalkMessage.class);
        Mockito.verify(dingTalkService).sendNotice(argCaptor.capture());
        Assert.assertEquals(argCaptor.getValue().getMsgtype(), "text");
        Assert.assertTrue(argCaptor.getValue().getText().contains("张三"));
    }

    @After
    public void tearDown() {
        studentService.deleteByIds(Lists.newArrayList(1, 2, 3));
        teacherService.deleteByIds(Lists.newArrayList(1, 2, 3));
    }
}
