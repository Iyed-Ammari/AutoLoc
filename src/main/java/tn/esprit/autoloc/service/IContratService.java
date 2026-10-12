package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;
import java.util.List;

public interface IContratService {
    Contrat addContrat(Contrat contrat);
    List<Contrat> getAllContrats();
    Contrat getContratById(Long id);
    Contrat updateContrat(Long id, Contrat contrat);
    void deleteContrat(Long id);
}