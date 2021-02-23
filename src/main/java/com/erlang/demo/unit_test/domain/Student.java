package com.erlang.demo.unit_test.domain;

import java.util.Objects;

/**
 * 学生信息
 *
 * @author yj
 * @since 2021-01-29 8:52
 */
public class Student {

    /**
     * 学生 id
     */
    private int id;

    /**
     * 学生名称
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
