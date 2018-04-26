package ru.kpfu.itis.maletskov.hometask.controlsystemdb.db;

import ru.kpfu.itis.maletskov.hometask.controlsystemdb.App;
import ru.kpfu.itis.maletskov.hometask.controlsystemdb.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Maletskov on 01.04.2018.
 */
public class StudentsDataBase implements DataBase<Student> {
    protected final String path;
    private final File file;
    private List<Student> list;


    public StudentsDataBase(String path) {
        this.path = path;
        this.file = new File(path);
        list = new ArrayList<>();
    }

    public void saveListOfStudents() throws DbException, IOException {
        try(ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (int i = 0; i < list.size(); i++) {
                dos.writeObject(list.get(i));
            }
            dos.close();
        } catch (FileNotFoundException e) {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(Student student) throws DbException, IOException {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(student)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            list.add(student);
            saveListOfStudents();
            return true;
        }
        System.out.println("This student was added! Read a new student!");
        return false;
    }

    @Override
    public void printAll() {
        try(ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            //list.clear();
            int i = list.size();
            while (i > 0) {
                System.out.println(dis.readObject());
                i--;
            }
            dis.close();
            //while(dis.available() > 0) {
            //    name = dis.readUTF();
            //    age = dis.readInt();
            //    sex = dis.readInt();
            //    //list.add(new Student(name, age, sex));
            //    System.out.println(name + " " + age + " " + (sex == 1 ? "man" : "woman"));
            //}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
