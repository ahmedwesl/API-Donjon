package com.java.apidonjon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personnage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nom;
    private String type;
    private int pointsDeVie;

    public Personnage(long id, String nom, String type, int pointsDeVie) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.pointsDeVie = pointsDeVie;
    }

    public Personnage() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }



}




