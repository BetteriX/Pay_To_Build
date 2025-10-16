package org.example.ui;

public class PCParts {
    private String name;
    private float price;


    public PCParts(String name, float price) {
        setName(name);
        setPrice(price);
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}
