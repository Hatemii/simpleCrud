package com.example.simpleCrud.Entity;

public class Bachelor {

    private int id;
    private String
            technology,
            industrial,
            business,
            political;

    public Bachelor(int id, String technology, String industrial, String business, String political) {
        this.id = id;
        this.technology = technology;
        this.industrial = industrial;
        this.business = business;
        this.political = political;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getIndustrial() {
        return industrial;
    }

    public void setIndustrial(String industrial) {
        this.industrial = industrial;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }
}
