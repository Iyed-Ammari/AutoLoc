package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import java.util.List;

public interface IAgenceService {
    Agence addAgence(Agence agence);
    List<Agence> getAllAgences();
}