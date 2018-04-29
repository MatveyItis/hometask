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
                    throw new InvalidEntityException("Entity class doesn't have get public method: " + methodName, e);
                } catch (IllegalArgumentException e) {
                    throw new InvalidEntityException("Entity class doesn't have get public method: " + methodName, e);
                } catch (InvocationTargetException e) {}
                i++;
            } catch (NoSuchMethodException e) {
                try {
                    values[i] = field.get(t).toString();
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    throw new InvalidEntityException("Entity class doesn't have get public method: " + methodName, ex);
                }
                throw new InvalidEntityException("Entity class doesn't have get method: " + methodName, e);
            } catch (SecurityException e) {
                throw new InvalidEntityException("Entity class doesn't have get public method: " + methodName, e);
            }
        }
        return Stream.of(values).collect(Collectors.joining(","));
    }

    public void read() {

    }
}
