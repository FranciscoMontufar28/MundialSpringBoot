
package com.francisco.mundial.models;

public class Jugadores {
    
    int idjugadores;
    String name, lastname, club;

    public Jugadores() {
    }

    public Jugadores(String name, String lastname, String club) {
        this.name = name;
        this.lastname = lastname;
        this.club = club;
    }

    public Jugadores(int idjugadores, String name, String lastname, String club) {
        this.idjugadores = idjugadores;
        this.name = name;
        this.lastname = lastname;
        this.club = club;
    }

    public int getIdjugadores() {
        return idjugadores;
    }

    public void setIdjugadores(int idjugadores) {
        this.idjugadores = idjugadores;
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

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
    
    
    
}
