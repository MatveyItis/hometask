package ru.kpfu.itis.maletskov.hometask.fantasyhome;

/**
 * Created by Maletskov on 19.02.2018.
 */
public class App {
    public static void main(String[] args) {
        Student s1 = new Student("Danis Zamaliev", 176);
        Student s2 = new Student("Matve Maletskov", 190);
        NameStudentComparator c = new NameStudentComparator();
        System.out.println(c.compare(s1, s2));
        LessonPoint l1 = new LessonPoint("Information technology", 50);
        LessonPoint l2 = new LessonPoint("Information technology", 100);
        LessonPoint l3 = new LessonPoint("Information ", 100);
        LessonPoint l4 = new LessonPoint("Informattechnology", 50);

        s1.addLesson(l1);
        s2.addLesson(l2);
        s1.addLesson(l3);
        s2.addLesson(l4);
        PointsStudentComparator c1 = new PointsStudentComparator();
        System.out.println(c1.compare(s1, s2));

    }
}
