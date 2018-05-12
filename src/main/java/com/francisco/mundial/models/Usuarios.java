package com.francisco.mundial.models;

public class Usuarios {

    String name, lastname, identification, password, type, date;
    int idusuarios;

    public Usuarios() {
    }

    public Usuarios(String name, String lastname, String identification, String password, String type, String date) {
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.password = password;
        this.type = type;
        this.date = date;
    }

    public Usuarios(int idusuarios, String name, String lastname, String identification, String password, String type, String date) {
        this.idusuarios = idusuarios;
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.password = password;
        this.type = type;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    
}
