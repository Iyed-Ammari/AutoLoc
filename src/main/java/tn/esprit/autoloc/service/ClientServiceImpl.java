package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {
    private final ClientRepository repository;

    @Override public Client addClient(Client client) { return repository.save(client); }
    @Override public List<Client> getAllClients() { return repository.findAll(); }
    @Override public Client getClientById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public Client updateClient(Long id, Client client) {
        if(repository.existsById(id)) {
            client.setIdClient(id);
            return repository.save(client);
        }
        return null;
    }

    @Override public void deleteClient(Long id) { repository.deleteById(id); }
}