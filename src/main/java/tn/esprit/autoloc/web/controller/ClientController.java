package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@Tag(name = "Gestion des Clients", description = "Endpoints CRUD pour la gestion des clients de l'agence")
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @Operation(summary = "Ajouter un client", description = "Permet d'enregistrer un nouveau client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client enregistré avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @Operation(summary = "Liste des clients", description = "Obtenir tous les clients enregistrés")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @Operation(summary = "Obtenir un client par ID", description = "Recherche un client par sa clé primaire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client trouvé"),
            @ApiResponse(responseCode = "404", description = "Client non trouvé")
    })
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @Operation(summary = "Mettre à jour un client", description = "Met à jour les informations d'un client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mise à jour réussie"),
            @ApiResponse(responseCode = "404", description = "Client non trouvé")
    })
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @Operation(summary = "Supprimer un client", description = "Supprime un client par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suppression réussie")
    })
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}