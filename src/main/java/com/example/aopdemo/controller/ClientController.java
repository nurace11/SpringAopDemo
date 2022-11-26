package com.example.aopdemo.controller;

import com.example.aopdemo.entity.Client;
import com.example.aopdemo.service.ClientService;
import com.example.aopdemo.util.CustomResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public CustomResponse<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("{clientName}")
    public CustomResponse<Client> getClientByName(@PathVariable("clientName") String name) {
        return clientService.getClientByName(name);
    }

    @PostMapping
    public CustomResponse<Client> addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }
}
