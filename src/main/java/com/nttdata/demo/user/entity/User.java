package com.nttdata.demo.user.entity;

import lombok.Data;

@Data
public class User {

    private int id;
    private String doc;
    private TypeDoc typeDoc;
    private String name;
    private String middleName;
    private String lastName;
    private String secondSurname;
    private String phone;
    private String address;
    private String city;

    public User() {
        super();
    }

    public User(int id, TypeDoc typeDoc,String doc, String name, String middleName, String lastName, String secondSurname, String phone, String address, String city) {
        this.id = id;
        this.doc = doc;
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondSurname = secondSurname;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }
}