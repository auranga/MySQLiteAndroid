package com.alexurangareyes.mysqlite.model;

/**
 * Created by alexurangareyes on 5/31/17.
 */

public class Place {

    protected int id;
    protected String name;
    protected String state;

    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getState() {
        return this.state;
    }

}