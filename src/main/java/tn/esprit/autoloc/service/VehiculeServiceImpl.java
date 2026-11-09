package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.web.dto.VehiculeDto;
import tn.esprit.autoloc.web.mapper.VehiculeMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;
    private final VehiculeMapper vehiculeMapper;

    @Override
    public VehiculeDto addVehicule(VehiculeDto dto) {
        Agence agence = dto.getAgenceId() != null ? agenceRepository.findById(dto.getAgenceId()).orElse(null) : null;
        Vehicule vehicule = vehiculeMapper.toEntity(dto, agence);
        return vehiculeMapper.toDto(vehiculeRepository.save(vehicule));
    }

    @Override
    public List<VehiculeDto> getAllVehicules() {
        return vehiculeRepository.findAll().stream().map(vehiculeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public VehiculeDto getVehiculeById(Long id) {
        return vehiculeRepository.findById(id).map(vehiculeMapper::toDto).orElse(null);
    }

    @Override
    public VehiculeDto updateVehicule(Long id, VehiculeDto dto) {
        if (vehiculeRepository.existsById(id)) {
            Agence agence = dto.getAgenceId() != null ? agenceRepository.findById(dto.getAgenceId()).orElse(null) : null;
            Vehicule vehicule = vehiculeMapper.toEntity(dto, agence);
            vehicule.setIdVehicule(id);
            return vehiculeMapper.toDto(vehiculeRepository.save(vehicule));
        }
        return null;
    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
}