package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.service.IVehiculeService;
import tn.esprit.autoloc.web.dto.VehiculeDto;

import java.util.List;

@Tag(name = "Gestion des Véhicules (DTO)")
@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Ajouter un véhicule")
    @PostMapping
    public VehiculeDto addVehicule(@Valid @RequestBody VehiculeDto dto) {
        return vehiculeService.addVehicule(dto);
    }

    @Operation(summary = "Lister les véhicules")
    @GetMapping
    public List<VehiculeDto> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    @Operation(summary = "Trouver un véhicule par ID")
    @GetMapping("/{id}")
    public VehiculeDto getVehiculeById(@PathVariable Long id) {
        return vehiculeService.getVehiculeById(id);
    }

    @Operation(summary = "Mettre à jour un véhicule")
    @PutMapping("/{id}")
    public VehiculeDto updateVehicule(@PathVariable Long id, @Valid @RequestBody VehiculeDto dto) {
        return vehiculeService.updateVehicule(id, dto);
    }

    @Operation(summary = "Supprimer un véhicule")
    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
    }
}