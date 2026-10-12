package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import java.util.List;

public interface IClientService {
    Client addClient(Client client);
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
}