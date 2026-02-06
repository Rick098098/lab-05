package com.example.lab5_starter;

import java.io.Serializable;

public class City implements Serializable {

    private String id;
    private String name;
    private String province;
    public City() {}
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
