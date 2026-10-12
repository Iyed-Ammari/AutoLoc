package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import java.util.List;

public interface IClientService {
    Client addClient(Client client);
    List<Client> getAllClients();
}