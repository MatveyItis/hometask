package ru.kpfu.itis.maletskov.hometask.fantasyhome;

import java.util.Comparator;

/**
 * Created by Maletskov on 20.02.2018.
 */
public class NameStudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
