package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {
    private final ContratRepository repository;

    @Override public Contrat addContrat(Contrat contrat) { return repository.save(contrat); }
    @Override public List<Contrat> getAllContrats() { return repository.findAll(); }
    @Override public Contrat getContratById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public Contrat updateContrat(Long id, Contrat contrat) {
        if(repository.existsById(id)) {
            contrat.setIdContrat(id);
            return repository.save(contrat);
        }
        return null;
    }

    @Override public void deleteContrat(Long id) { repository.deleteById(id); }
}