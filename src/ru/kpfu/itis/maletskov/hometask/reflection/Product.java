package ru.kpfu.itis.maletskov.hometask.reflection;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Maletskov on 23.04.2018.
 */
public class Product{
    private int price;
    private String name;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(name, product.name);
    }

    public String toString() {
        return name + " " + price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
