package ru.kpfu.itis.maletskov.hometask.fantasyhome;

/**
 * Created by Maletskov on 19.02.2018.
 */
public class LessonPoint implements Comparable<LessonPoint> {
    private String title;
    private int points;

    public LessonPoint(String title, int points) {
        this.title = title;
        this.points = points;
    }

    @Override
    public int compareTo(LessonPoint o) {
        if (this.points > o.points) {
            return 1;
        } else if (this.points < o.points) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LessonPoint that = (LessonPoint) o;

        if (points != that.points) {
            return false;
        }
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + points;
        return result;
    }
}
