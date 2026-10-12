package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
    private final AgenceRepository repository;

    @Override public Agence addAgence(Agence agence) { return repository.save(agence); }
    @Override public List<Agence> getAllAgences() { return repository.findAll(); }
    @Override public Agence getAgenceById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public Agence updateAgence(Long id, Agence agence) {
        if(repository.existsById(id)) {
            agence.setIdAgence(id);
            return repository.save(agence);
        }
        return null;
    }

    @Override public void deleteAgence(Long id) { repository.deleteById(id); }
}