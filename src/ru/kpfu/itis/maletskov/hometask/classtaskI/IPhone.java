package ru.kpfu.itis.maletskov.hometask.classtaskI;

/**
 * Created by User on 18.11.2017.
 */
public class IPhone extends Phone implements RecordData{
    private int model;

    public IPhone() {

    }

    public IPhone(int model) {
        this.model = model;
    }

    @Override
    public void on() {
        System.out.println("iPhone is on");
    }

    @Override
    public void off() {
        System.out.println("iPhone is off");
    }

    @Override
    public void reboot() {

    }

    @Override
    public void takePhoto() {
        System.out.println("Chick");
    }

    @Override
    public void recordVideo() {

    }

    @Override
    public void recordSlowMoVideo() {
        System.out.println("Chiiiiiiiiiiiick");
    }

    @Override
    public void writeANote() {

    }

    public int hashCode() {
        final int prime = 33;
        int result = 2;
        result = (prime * result + this.model);
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
        IPhone other = (IPhone) o;
        if (other.model != this.model) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "I'm iPhone " + model;
    }
}
