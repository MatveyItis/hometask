package ru.kpfu.itis.maletskov.hometask.reflection;

import java.io.*;
import java.lang.reflect.*;
import java.sql.Types;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Maletskov on 23.04.2018.
 */
public class GenericRepository<T> {
    private static int countOfRepo = 0;
    private int currentRepo;
    private int countOfReadingRepo;
    private File f;

    public GenericRepository() throws IOException {
        countOfRepo++;
        this.currentRepo = countOfRepo;
        this.countOfReadingRepo = 0;
        this.f = new File("/Users/matveymaletskov/IdeaProjects/"
                + "oldwindows/src/ru/kpfu/itis/maletskov/hometask/reflection/"
                + this.currentRepo + ".csv");
        if (f.exists()) {
           f.createNewFile();
        }
    }

    public String getAsCsvString(T t) throws InvalidEntityException {
        Field[] fields = t.getClass().getDeclaredFields();
        String[] values = new String[fields.length];
        int i = 0;
        for (Field field : fields) {
            StringBuilder sb = new StringBuilder();
            sb.append("get");
            sb.append(field.getName().substring(0, 1).toUpperCase());
            if (field.getName().length() != 1) {
                sb.append(field.getName().substring(1));
            }
            String methodName = sb.toString();
            try {
                Method m = t.getClass().getMethod(methodName, new Class[]{});
                try {
                    values[i] = m.invoke(t).toString();
                } catch (IllegalAccessException e) {
                    throw new InvalidEntityException("The currently method doesn't have access to the definition of the specified method: " + methodName, e);
                } catch (IllegalArgumentException e) {
                    throw new InvalidEntityException("The currently method has been passed an illegal or inappropriate argument.", e);
                } catch (InvocationTargetException e) {}
                i++;
            } catch (NoSuchMethodException e) {
                try {
                    values[i] = field.get(t).toString();
                } catch (IllegalArgumentException ex1) {
                    throw new InvalidEntityException("The method doesn't match the field name: " + methodName, ex1);
                } catch (IllegalAccessException ex2) {
                    throw new InvalidEntityException("Entity class doesn't have get private method: " + methodName, ex2);
                }
                throw new InvalidEntityException("Method cannot be found: " + methodName, e);
            } catch (SecurityException e) {
                throw new InvalidEntityException("The security manager has indicate a security violation in this method: " + methodName, e);
            }
        }
        return Stream.of(values).collect(Collectors.joining(","));
    }

    public T read(T t) {
        try (Scanner sc = new Scanner(this.f)) {
            String s = sc.nextLine();
            String[] arr = s.split(",");
            Class c = Class.forName(t.getClass().getName());
            Constructor[] constructors = c.getConstructors();
            int m = 0;
            for (int i = 0; i < constructors.length; i++) {
               m = constructors[i].getParameterCount() > constructors[m].getParameterCount() ? i : m;
            }
            Constructor constructor = constructors[m];
            constructors = null;
            Class[] paramTypes = constructor.getParameterTypes();
            Object[] objects = new Object[paramTypes.length];
            Pattern numbers = Pattern.compile("^(0-9)[0-9]+");
            Matcher matcher;
            for (int i = 0; i < paramTypes.length; i++) {
               matcher = numbers.matcher(arr[i]);
               if (paramTypes[i].getName().equals(Integer.class.getName())) {
                  if (matcher.find()) {
                     objects[i] = Integer.parseInt(arr[i]);
                  } else {
                     objects[i] = 0;
                  }
                  continue;
               } if (paramTypes[i].getName().equals(Double.class.getName())) {
                  if (matcher.find()) {
                     objects[i] = Double.parseDouble(arr[i]);
                  } else {
                     objects[i] = 0d;
                  }
                  continue;
               } if (paramTypes[i].getName().equals(Long.class.getName())) {
                  if (matcher.find()) {
                     objects[i] = Long.parseLong(arr[i]);
                  } else {
                     objects[i] = 0l;
                  }
                  continue;
               } if (paramTypes[i].getName().equals(Short.class.getName())) {
                  if (matcher.find()) {
                     objects[i] = Short.parseShort(arr[i]);
                  } else {
                     objects[i] = 0;
                  }
                  continue;
               } if (paramTypes[i].getName().equals(Byte.class.getName())) {
                  if (matcher.find()) {
                     objects[i] = Byte.parseByte(arr[i]);
                  } else {
                     objects[i] = 0;
                  }
                  continue;
               } if (paramTypes[i].getName().equals(Float.class.getName())) {
                  if (matcher.find()) {
                     objects[i] = Float.parseFloat(arr[i]);
                  } else {
                     objects[i] = 0f;
                  }
                  continue;
               } if (paramTypes[i].getName().equals(Boolean.class.getName())) {
                  objects[i] = Boolean.parseBoolean(arr[i]);
                  continue;
               } if (paramTypes[i].getName().equals(Character.class.getName())) {
                  objects[i] = arr[i].charAt(0);
                  continue;
               } if (paramTypes[i].getName().equals(String.class.getName())) {
                  objects[i] = arr[i];
                  continue;
               }
            }
            T o = (T) constructor.newInstance(objects);
            sc.close();
            return t;
        } catch (IOException e) {
           e.printStackTrace();
        } catch (IllegalAccessException e) {
           e.printStackTrace();
        } catch (InvocationTargetException e) {
           e.printStackTrace();
        } catch (InstantiationException e) {
           e.printStackTrace();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
       return null;
    }

    public void save(T t) {
        try (FileWriter fw = new FileWriter(this.f, true)) {
           fw.write(getAsCsvString(t) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidEntityException e) {
           e.printStackTrace();
        }
    }

    public int getLines() {
       try (Scanner sc = new Scanner(this.f)) {
           String s = sc.nextLine();
           int c = 0;
           while (s != null) {
              c++;
              s = sc.nextLine();
           }
           return c;
       } catch (FileNotFoundException e) {
          e.printStackTrace();
       }
       return 0;
    }
}
