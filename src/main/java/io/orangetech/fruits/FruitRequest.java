package io.orangetech.fruits;

public class FruitRequest {
    private String name;
    private String color;
    private int quantity;

    public FruitRequest(String name, String color, int quantity) {
        this.name = name;
        this.color = color;
        this.quantity = quantity;
    }

    public FruitRequest(){}

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

    @Override
    public String toString() {
        return "FruitRequest{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
