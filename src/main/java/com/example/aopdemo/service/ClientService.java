package com.example.aopdemo.service;

import com.example.aopdemo.entity.Client;
import com.example.aopdemo.repository.ClientRepository;
import com.example.aopdemo.util.CustomResponse;
import com.example.aopdemo.util.CustomStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public CustomResponse<Client> getAll() {
        List<Client> clientList = clientRepository.findAll();
        return new CustomResponse<>(clientList, CustomStatus.SUCCESS);
    }

    public CustomResponse<Client> getClientByName(String name) {
        Client client = clientRepository.findClientByName(name).orElseThrow();
        return new CustomResponse<>(Stream.of(client).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }

    public CustomResponse<Client> addClient(Client client) {
        Client newClient;
        newClient = clientRepository.save(client);// newClient have id, client does not

        return new CustomResponse<>(Stream.of(newClient).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }
}
