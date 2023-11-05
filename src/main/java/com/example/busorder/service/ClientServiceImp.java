package com.example.busorder.service;

import com.example.busorder.models.dto.ClientSaveDTO;
import com.example.busorder.models.dto.LoginDTO;
import com.example.busorder.models.dto.ResponseMessageDTO;
import com.example.busorder.models.entities.Client;
import com.example.busorder.repository.ClientRepository;
import com.example.busorder.service.serviceInterfaces.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public String saveClient(ClientSaveDTO clientSaveDTO) {
        String encode = passwordEncoder.encode(clientSaveDTO.getPassword());

        Client client = Client.builder()
                .name(clientSaveDTO.getName())
                .surname(clientSaveDTO.getSurname())
                .mobilePhone(clientSaveDTO.getMobilePhone())
                .email(clientSaveDTO.getEmail())
                .password(encode)
                .build();

        clientRepository.save(client);

        return client.getName();
    }

    @Override
    public ResponseMessageDTO loginClient(LoginDTO loginDTO) {
        return new ResponseMessageDTO("", true);
    }
}
