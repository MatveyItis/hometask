package ru.kpfu.itis.maletskov.hometask.objectstreamexample;

import ru.kpfu.itis.maletskov.hometask.reflection.Student;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentOutputStream extends OutputStream {
   private DataOutputStream dos;
   private static Logger logger = Logger.getLogger(StudentOutputStream.class.getName());

   public StudentOutputStream(OutputStream os) {
      this.dos = new DataOutputStream(os);
      logger.log(Level.INFO, "Stream is created");
   }

   public void write(Student student) {
      try {
         dos.writeUTF(student.getName());
         dos.write(student.getAge());
         logger.log(Level.INFO, "Student is added");
      } catch (IOException e) {
         logger.log(Level.WARNING, "Warning! Student is not added");
         e.printStackTrace();
      }
   }

   @Override
   public void write(int b) throws IOException {
      dos.write(b);
   }
}
