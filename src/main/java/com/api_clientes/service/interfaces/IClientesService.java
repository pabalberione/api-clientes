package com.api_clientes.service.interfaces;

import com.api_clientes.presentation.dto.ClientesDTO;

import java.util.List;

public interface IClientesService {
    List<ClientesDTO>findAll();
    ClientesDTO findById(Long id);
    ClientesDTO createCliente(ClientesDTO clientesDTO);
    ClientesDTO updateCliente(Long id, ClientesDTO clientesDTO);
    String deleteCliente(Long id);
}
