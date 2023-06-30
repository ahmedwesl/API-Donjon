package com.java.apidonjon.dao;

import com.java.apidonjon.Personnage;

import java.util.List;

public interface PersonnageDao {
    List<Personnage> findAll();
    Personnage findById(int id);
    Personnage save(Personnage personnage);


}
