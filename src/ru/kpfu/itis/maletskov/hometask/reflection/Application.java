package ru.kpfu.itis.maletskov.hometask.reflection;

import ru.kpfu.itis.maletskov.hometask.csv.CSVReader;
import ru.kpfu.itis.maletskov.hometask.csv.CSVWriter;

import java.io.File;

public class Application {
   public static void main(String[] args) throws InvalidEntityException {
      GenericRepository<Student> studrepo = new GenericRepository<>();
      System.out.println(studrepo.getAsCsvString(new Student("Danis", 18)));
      CSVWriter csvw = new CSVWriter();

   }
}
