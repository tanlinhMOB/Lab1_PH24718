package com.example.lab1_ph24718.DTO;

public class CatDTO {

//    public CatDTO(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "CatDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int id ;
    String name;

}
