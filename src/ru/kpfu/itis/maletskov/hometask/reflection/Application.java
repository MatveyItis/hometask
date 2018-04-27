package ru.kpfu.itis.maletskov.hometask.reflection;

public class Application {
   public static void main(String[] args) throws InvalidEntityException {
      GenericRepository<Student> studrepo = new GenericRepository<>();
      System.out.println(studrepo.getAsCsvString(new Student("Danis", 18)));
   }
}
