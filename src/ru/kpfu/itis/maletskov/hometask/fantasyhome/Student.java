package ru.kpfu.itis.maletskov.hometask.fantasyhome;

import java.util.Arrays;

/**
 * Created by Maletskov on 19.02.2018.
 */

public class Student {
    private String name;
    private int tall;
    private LessonPoint[] lessonPoints;
    private int count;
    private int sumPoints;

    public Student(String name, int tall) {
        lessonPoints = new LessonPoint[10];
        count = 0;
        this.name = name;
        this.tall = tall;
    }

    public void addLesson(LessonPoint l) {
        if (count < 10) {
            lessonPoints[count] = l;
            count++;
        } else {
            System.out.println("Quantity of lessons is full." +
                               "You cannot add lessons");
        }
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public int getTall() {
        return tall;
    }

    public int getLessonPoints() {
        for (int i = 0; i < count; i++) {
            sumPoints += lessonPoints[i].getPoints();
        }
        return sumPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (tall != student.tall) return false;
        if (count != student.count) return false;
        if (sumPoints != student.sumPoints) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(lessonPoints, student.lessonPoints);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + tall;
        result = 31 * result + Arrays.hashCode(lessonPoints);
        result = 31 * result + count;
        result = 31 * result + sumPoints;
        return result;
    }
}
