package com.anindya.aplikasiku.Model;

public class ScheduleModel {
    public String logo;
    public String name;
    public String ket;

    public ScheduleModel(String logo, String name, String ket) {
        this.logo = logo;
        this.name = name;
        this.ket = ket;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }
}
