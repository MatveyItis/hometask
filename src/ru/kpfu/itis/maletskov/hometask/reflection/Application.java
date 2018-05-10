package ru.kpfu.itis.maletskov.hometask.reflection;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Application {
   public static void main(String[] args) throws IOException {
      /*Student obj = new Student("Danis");
      Class c = obj.getClass();
      Constructor[] constructors = c.getConstructors();
      for (Constructor constructor : constructors) {
         Class[] paramTypes = constructor.getParameterTypes();
         for (Class paramType : paramTypes) {
            System.out.print(paramType.getName() + " ");
         }
         System.out.println();
      }
      Method[] methods = c.getMethods();
      for (Method method : methods) {
         System.out.println("Имя: " + method.getName());
         System.out.println("Возвращаемый тип: " + method.getReturnType().getName());

         Class[] paramTypes = method.getParameterTypes();
         System.out.print("Типы параметров: ");
         for (Class paramType : paramTypes) {
            System.out.print(" " + paramType.getName());
         }
         System.out.println();
      }*/

      GenericRepository<Student> gr1 = new GenericRepository<>();
      gr1.save(new Student("Danis", 18));
      gr1.save(new Student("Matvey", 19));
      System.out.println(gr1.read(new Student("Danis", 18)));
      GenericRepository<Product> gr2 = new GenericRepository<>();
      gr2.save(new Product("Milk", 12));
      System.out.println(gr2.read(new Product("sdf", 9)));
      GenericRepository<Product> gr3 = new GenericRepository<>();
      gr3.save(new Product("Meat", 13));

   }
}
