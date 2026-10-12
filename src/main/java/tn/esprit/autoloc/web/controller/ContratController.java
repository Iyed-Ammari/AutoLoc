package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;
import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratController {
    private final IContratService service;

    @PostMapping public Contrat addContrat(@RequestBody Contrat contrat) { return service.addContrat(contrat); }
    @GetMapping public List<Contrat> getAllContrats() { return service.getAllContrats(); }
    @GetMapping("/{id}") public Contrat getContratById(@PathVariable Long id) { return service.getContratById(id); }
    @PutMapping("/{id}") public Contrat updateContrat(@PathVariable Long id, @RequestBody Contrat contrat) { return service.updateContrat(id, contrat); }
    @DeleteMapping("/{id}") public void deleteContrat(@PathVariable Long id) { service.deleteContrat(id); }
}