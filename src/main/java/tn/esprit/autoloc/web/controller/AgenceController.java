package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;
import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {
    private final IAgenceService service;

    @PostMapping public Agence addAgence(@RequestBody Agence agence) { return service.addAgence(agence); }
    @GetMapping public List<Agence> getAllAgences() { return service.getAllAgences(); }
    @GetMapping("/{id}") public Agence getAgenceById(@PathVariable Long id) { return service.getAgenceById(id); }
    @PutMapping("/{id}") public Agence updateAgence(@PathVariable Long id, @RequestBody Agence agence) { return service.updateAgence(id, agence); }
    @DeleteMapping("/{id}") public void deleteAgence(@PathVariable Long id) { service.deleteAgence(id); }
}