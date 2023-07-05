package com.java.apidonjon.dao;

import com.java.apidonjon.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnageDao extends JpaRepository<Personnage,Integer> {

    //   static {
    //       personnages.add(new Personnage(1,"Jean","Guerrier",10));
    //       personnages.add(new Personnage(2,"Sofia","Guerrier",5));
    //       personnages.add(new Personnage(3,"Irek","Mage",8));
    //   }
    List<Personnage> findAll();

    Personnage findById(long id);
    Personnage save(Personnage personnage);

//   void deleteById(long id);


}
