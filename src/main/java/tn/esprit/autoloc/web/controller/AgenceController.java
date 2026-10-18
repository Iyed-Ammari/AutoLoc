package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Tag(name = "Gestion des Agences", description = "Endpoints CRUD pour la gestion des agences")
@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @Operation(summary = "Créer une agence", description = "Ajoute une nouvelle agence au système")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @Operation(summary = "Obtenir la liste des agences", description = "Récupère la liste de toutes les agences enregistrées")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.getAllAgences();
    }

    @Operation(summary = "Obtenir une agence par ID", description = "Retourne les détails d'une agence spécifique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence trouvée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    @GetMapping("/{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return agenceService.getAgenceById(id);
    }

    @Operation(summary = "Mettre à jour une agence", description = "Modifie les informations d'une agence")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mise à jour effectuée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    @PutMapping("/{id}")
    public Agence updateAgence(@PathVariable Long id, @RequestBody Agence agence) {
        return agenceService.updateAgence(id, agence);
    }

    @Operation(summary = "Supprimer une agence", description = "Supprime l'agence identifiée par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence supprimée")
    })
    @DeleteMapping("/{id}")
    public void deleteAgence(@PathVariable Long id) {
        agenceService.deleteAgence(id);
    }
}