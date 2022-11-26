package com.example.aopdemo.service;

import com.example.aopdemo.entity.Client;
import com.example.aopdemo.repository.ClientRepository;
import com.example.aopdemo.util.CustomResponse;
import com.example.aopdemo.util.CustomStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
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
        List<Client> clientList;
        try {
            log.info("Try to get all clients");
            clientList = clientRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }

        log.info("All clients received");
        return new CustomResponse<>(clientList, CustomStatus.SUCCESS);
    }

    public CustomResponse<Client> getClientByName(String name) {
        Client client;
        try {
            log.info("Try to get a client with name {}", name);
            client = clientRepository.findClientByName(name).orElseThrow();
        } catch (NoSuchElementException e) {
            log.error(e.getMessage(), e);
            return new CustomResponse<>(null, CustomStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }

        log.info("Client with name {} has been found", name);
        return new CustomResponse<>(Stream.of(client).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }

    public CustomResponse<Client> addClient(Client client) {
        Client newClient;

        try {
            log.info("Try to add client {} at {}", client, LocalDate.now());
            newClient = clientRepository.save(client);// newClient have id, client does not
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }

        log.info("Client {} has been added", client.getName());
        return new CustomResponse<>(Stream.of(newClient).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }
}
