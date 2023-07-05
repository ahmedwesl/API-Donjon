package com.java.apidonjon;//package com.java.apidonjon;//package com.java.apidonjon;
////import com.java.apidonjon.dao.PersonnageDao;
////import org.springframework.web.bind.annotation.*;
////import java.util.ArrayList;
////import java.util.List;
//
//@RestController
//@RequestMapping("/personnages") // utilisée pour mapper les requêtes HTTP aux méthodes de gestion des contrôleurs MVC et REST.
//public class PersonnageController  {
//    private List<Personnage> personnages = new ArrayList<>();
//    private static long idCounter = 1;
//
//    @GetMapping
//    public List<Personnage> afficherListePersonnages() {
//        return personnages;
//    }
//
//    @PostMapping //gère les requêtes HTTPPOST correspondant à l'expression URI donnée
//    public Personnage creerPersonnage(@RequestBody Personnage personnage) {
//        personnage.setId(idCounter++);
//        personnages.add(personnage);
//        return personnage;
//    }
//
//    @GetMapping("/{id}") //gère les requêtes HTTPGET correspondant à l'expression URI donnée
//    public Personnage afficherFichePersonnage(@PathVariable("id") long id) {
//        return trouverPersonnageParId(id);
//    }
//
//    @PutMapping("/{id}") //methode qui envoie une demande
//    public Personnage modifierPersonnage(@PathVariable("id") long id, @RequestBody Personnage personnage) {
//        Personnage personnageExistant = trouverPersonnageParId(id);
//        if (personnageExistant != null) {
//            personnageExistant.setNom(personnage.getNom());
//            personnageExistant.setType(personnage.getType());
//            personnageExistant.setPointsDeVie(personnage.getPointsDeVie());
//        }
//        return personnageExistant;
//    }
//
//    @DeleteMapping("/{id}") //envoie une demande au Restful Service pour supprimer une ressource de données.
//    public void supprimerPersonnage(@PathVariable("id") long id) {
//        Personnage personnage = trouverPersonnageParId(id);
//        if (personnage != null) {
//            personnages.remove(personnage);
//        }
//    }
//
//    private Personnage trouverPersonnageParId(long id) {
//        for (Personnage personnage : personnages) {
//            if (personnage.getId() == id) {
//                return personnage;
//            }
//        }
//        return null;
//    }
//}

import com.java.apidonjon.Personnage;
import com.java.apidonjon.dao.PersonnageDao;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/personnages")
@CrossOrigin
public class PersonnageController {

    public PersonnageController(PersonnageDao personnageDao) {
        this.personnageDao = personnageDao;
    }

    @Autowired
    private PersonnageDao personnageDao;



    @GetMapping
    public List<Personnage> afficherListePersonnages() {
        return personnageDao.findAll();
    }

    @PostMapping
    public Personnage creerPersonnage(@RequestBody Personnage personnage) {
        return personnageDao.save(personnage);
    }

    @GetMapping("/{id}")
    public Personnage afficherFichePersonnage(@PathVariable("id") long id) {
        return personnageDao.findById(id);
    }

    @PutMapping("/{id}")
    public Personnage modifierPersonnage(@PathVariable("id") long id, @RequestBody Personnage personnage) {
        Personnage personnageExistant = personnageDao.findById((int) id);
        if (personnageExistant != null) {
            personnageExistant.setNom(personnage.getNom());
            personnageExistant.setType(personnage.getType());
            personnageExistant.setPointsDeVie(personnage.getPointsDeVie());
            return personnageDao.save(personnageExistant);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void supprimerPersonnage(@PathVariable("id") int id) {
        personnageDao.deleteById(id);
    }
}


