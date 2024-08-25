package io.orangetech.fruits;

import jakarta.persistence.*;

@Entity
@Table(name="Fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String color;
    private int quantity;

    public Fruit(long id, String name, String color, int quantity) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.quantity = quantity;
    }

    public Fruit(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
