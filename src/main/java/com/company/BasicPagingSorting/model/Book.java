package com.company.BasicPagingSorting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="name")
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String authName;
    private String about;

    public Book(int id, String name, String authName, String about) {
        this.id = id;
        this.name = name;
        this.authName = authName;
        this.about = about;
    }

    public Book(String name, String authName, String about) {
        this.name = name;
        this.authName = authName;
        this.about = about;
    }

    public Book() {
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

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
