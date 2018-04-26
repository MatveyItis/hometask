package ru.kpfu.itis.maletskov.hometask.fantasyhome;

import java.util.Comparator;

/**
 * Created by Maletskov on 20.02.2018.
 */
public class PointsStudentComparator implements Comparator<Student> {
    private double s;

    @Override
    public int compare(Student s1, Student s2) {
        s = (double)s1.getLessonPoints() / s1.getCount()-
            (double)s2.getLessonPoints() / s2.getCount();
        if (s > 0) {
            return 1;
        } else if (s < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
