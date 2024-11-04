package com.example.lab1_ph24718.DTO;

public class ProductDTO {
    int id , id_cat;
    String name;
    double price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public ProductDTO() {
    }


    public ProductDTO(int id, int id_cat, String name, double price) {
        this.id = id;
        this.id_cat = id_cat;
        this.name = name;
        this.price = price;
    }



    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", id_cat=" + id_cat +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }



}
