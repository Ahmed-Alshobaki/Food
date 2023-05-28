package com.example.myapplication;

public class Food {

    private String name;
    private String Id;
    private String description;
    private String price;
    private String rate;

    public Food(){

    }


    public Food(String name, String id, String description, String price, String rate) {
        this.name = name;
        Id = id;
        this.description = description;
        this.price = price;
        this.rate = rate;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
