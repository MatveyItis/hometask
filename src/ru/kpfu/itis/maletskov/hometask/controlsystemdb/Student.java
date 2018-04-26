package ru.kpfu.itis.maletskov.hometask.controlsystemdb;

import java.io.Serializable;

/**
 * Created by Maletskov on 01.04.2018.
 */
public class Student implements Serializable{
    private String name;
    private int age;
    private byte sex;//1 - man, 0 - woman

    public Student(String name, int age, byte sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public byte getSex() {
        return sex;
    }

    public String toString() {
        return getName() + " " + getAge() + " " + (getSex() == 1 ? "man" : "woman");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (sex != student.sex) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + sex;
        return result;
    }
}
