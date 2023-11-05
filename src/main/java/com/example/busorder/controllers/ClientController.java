package com.example.busorder.controllers;

import com.example.busorder.models.dto.ClientSaveDTO;
import com.example.busorder.models.dto.LoginDTO;
import com.example.busorder.models.dto.ResponseMessageDTO;
import com.example.busorder.service.serviceInterfaces.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/client")
@RestController
@CrossOrigin
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("save")
    public String saveClient(@RequestBody ClientSaveDTO clientSaveDTO) {
        return clientService.saveClient(clientSaveDTO);

    }

    @PostMapping("login")
    public ResponseEntity<?> saveClient(@RequestBody LoginDTO loginDTO) {

        ResponseMessageDTO message = clientService.loginClient(loginDTO);

        return ResponseEntity.ok(message);

    }

}
