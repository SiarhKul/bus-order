package com.example.busorder.service;

import com.example.busorder.models.entities.Client;
import com.example.busorder.repository.ClientRepository;
import com.example.busorder.security.ClientDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String clientName) throws UsernameNotFoundException {
        Optional<Client> client = clientRepository.getClientByName(clientName);

        if (clientName.isEmpty()) {
            throw new UsernameNotFoundException("Client not found");
        }

        return new ClientDetails(client.get());

    }
}
