package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehiculeService service;

    @PostMapping public Vehicule addVehicule(@RequestBody Vehicule vehicule) { return service.addVehicule(vehicule); }
    @GetMapping public List<Vehicule> getAllVehicules() { return service.getAllVehicules(); }
    @GetMapping("/{id}") public Vehicule getVehiculeById(@PathVariable Long id) { return service.getVehiculeById(id); }
    @PutMapping("/{id}") public Vehicule updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) { return service.updateVehicule(id, vehicule); }
    @DeleteMapping("/{id}") public void deleteVehicule(@PathVariable Long id) { service.deleteVehicule(id); }
}