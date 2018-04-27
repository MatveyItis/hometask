package ru.kpfu.itis.maletskov.hometask.reflection;

import java.util.Objects;

/**
 * Created by Maletskov on 23.04.2018.
 */
public class Product {
    private int price;
    private String name;
    private String data;

    public Product(String name, int price, int dd, int mm, int yyyy) {
        this.name = name;
        this.price = price;
        this.data = dd + "." + mm + "." + yyyy;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(name, product.name) &&
                Objects.equals(data, product.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, data);
    }
}
