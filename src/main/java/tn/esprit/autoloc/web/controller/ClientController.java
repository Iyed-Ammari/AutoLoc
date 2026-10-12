package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService service;

    @PostMapping public Client addClient(@RequestBody Client client) { return service.addClient(client); }
    @GetMapping public List<Client> getAllClients() { return service.getAllClients(); }
    @GetMapping("/{id}") public Client getClientById(@PathVariable Long id) { return service.getClientById(id); }
    @PutMapping("/{id}") public Client updateClient(@PathVariable Long id, @RequestBody Client client) { return service.updateClient(id, client); }
    @DeleteMapping("/{id}") public void deleteClient(@PathVariable Long id) { service.deleteClient(id); }
}