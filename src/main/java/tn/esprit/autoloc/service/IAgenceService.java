package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import java.util.List;

public interface IAgenceService {
    Agence addAgence(Agence agence);
    List<Agence> getAllAgences();
    Agence getAgenceById(Long id);
    Agence updateAgence(Long id, Agence agence);
    void deleteAgence(Long id);
}