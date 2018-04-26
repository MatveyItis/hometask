package ru.kpfu.itis.maletskov.hometask.fantasyhome;

import java.util.Comparator;

/**
 * Created by Maletskov on 20.02.2018.
 */
public class TallStudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getTall() - s2.getTall();
    }
}
