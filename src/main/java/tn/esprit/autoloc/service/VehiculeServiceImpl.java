package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {
    private final VehiculeRepository repository;

    @Override public Vehicule addVehicule(Vehicule vehicule) { return repository.save(vehicule); }
    @Override public List<Vehicule> getAllVehicules() { return repository.findAll(); }
    @Override public Vehicule getVehiculeById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public Vehicule updateVehicule(Long id, Vehicule vehicule) {
        if(repository.existsById(id)) {
            vehicule.setIdVehicule(id);
            return repository.save(vehicule);
        }
        return null;
    }

    @Override public void deleteVehicule(Long id) { repository.deleteById(id); }
}