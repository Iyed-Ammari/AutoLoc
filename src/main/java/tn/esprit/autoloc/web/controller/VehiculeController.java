package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@Tag(name = "Gestion des Véhicules", description = "Endpoints CRUD pour la gestion de la flotte de véhicules")
@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Ajouter un véhicule", description = "Permet de créer un nouveau véhicule dans le système")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @Operation(summary = "Liste des véhicules", description = "Récupère la liste de tous les véhicules enregistrés")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    @Operation(summary = "Obtenir un véhicule par son ID", description = "Retourne les détails d'un véhicule spécifique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule non trouvé")
    })
    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeService.getVehiculeById(id);
    }

    @Operation(summary = "Mettre à jour un véhicule", description = "Met à jour les données d'un véhicule existant via son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mise à jour réussie"),
            @ApiResponse(responseCode = "404", description = "Véhicule non trouvé")
    })
    @PutMapping("/{id}")
    public Vehicule updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(id, vehicule);
    }

    @Operation(summary = "Supprimer un véhicule", description = "Supprime un véhicule de la base de données selon son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suppression réussie"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
    }
}