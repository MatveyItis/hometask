package ru.kpfu.itis.maletskov.hometask.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Maletskov on 23.04.2018.
 */
public class GenericRepository<T> {

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

    public void read() {

    }

    public void save(T t) {

    }
}
