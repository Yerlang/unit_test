package com.erlang.demo.unit_test.domain;

import java.util.List;

/**
 * 老师
 *
 * @author yj
 * @since 2021-02-20 8:50
 */
public class Teacher {

    private int id;

    private String name;

    private int age;

    /**
     * 课程
     */
    private String course;

    private List<Integer> studentIds;

    public Teacher(int id, String name, int age, String course, List<Integer> studentIds) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.studentIds = studentIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }
}
