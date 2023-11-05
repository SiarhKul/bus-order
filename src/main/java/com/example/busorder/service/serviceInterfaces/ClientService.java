package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.dto.ClientSaveDTO;
import com.example.busorder.models.dto.LoginDTO;
import com.example.busorder.models.dto.ResponseMessageDTO;

public interface ClientService {

    String saveClient(ClientSaveDTO clientSaveDTO);

    ResponseMessageDTO loginClient(LoginDTO loginDTO);
}
