package com.alexurangareyes.mysqlite.model;

/**
 * Created by alexurangareyes on 5/31/17.
 */

public class Place {

    protected int id;
    protected String name;
    protected String state;
    protected String municipality;
    protected int fav;

    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setFav(int fav) {
        this.fav = fav;
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

    public int getFav() {
        return this.fav;
    }

    public String getMucicipality() {
        return this.municipality;
    }

}