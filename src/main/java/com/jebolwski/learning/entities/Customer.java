package com.jebolwski.learning.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    @Column(name = "id")
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(age, customer.age) && Objects.equals(products, customer.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, age, products);
    }


    public Customer(Integer id, String name, String email, Integer age, List<Product> products) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.products = products;
    }

    public Customer(Integer id, String name, String email, Integer age) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setAge(age);
    }

    public Customer(){}

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

