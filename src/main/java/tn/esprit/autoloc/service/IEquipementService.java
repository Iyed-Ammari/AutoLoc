package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import java.util.List;

public interface IEquipementService {
    Equipement addEquipement(Equipement equipement);
    List<Equipement> getAllEquipements();
}