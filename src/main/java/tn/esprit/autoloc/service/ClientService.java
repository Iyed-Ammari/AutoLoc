package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public class ClientService implements IClientService{
    @Override
    public List<Client> retrieveAllClients() {
        return List.of();
    }

    @Override
    public Client addClient(Client c) {
        return null;
    }

    @Override
    public Client updateClient(Client c) {
        return null;
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return null;
    }

    @Override
    public void removeClient(Long idClient) {

    }

    @Override
    public List<Client> addClients(List<Client> clients) {
        return List.of();
    }
}
