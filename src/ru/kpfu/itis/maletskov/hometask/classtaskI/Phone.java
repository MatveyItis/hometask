package ru.kpfu.itis.maletskov.hometask.classtaskI;

import java.util.Date;

/**
 * Created by User on 18.11.2017.
 */
public class Phone extends Device {
    protected Date dateOfIssue;

    public Phone() {

    }

    public Phone(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public void on() {
        System.out.println("Phone is on");
    }

    @Override
    public void off() {
        System.out.printf("Phone is off");
    }

    @Override
    public void reboot() {

    }

    public int hashCode() {
        final int prime = 33;
        int result = 2;
        result = dateOfIssue.getYear()
                + dateOfIssue.getMonth() + dateOfIssue.getDay();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Phone other = (Phone) o;
        if (other.dateOfIssue != this.dateOfIssue) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "I'm Phone. My date of issue is " + dateOfIssue.toString();
    }
}
