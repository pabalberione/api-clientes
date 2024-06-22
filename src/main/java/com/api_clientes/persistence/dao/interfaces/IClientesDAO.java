package com.api_clientes.persistence.dao.interfaces;

import com.api_clientes.persistence.entity.ClientesEntity;

import java.util.List;
import java.util.Optional;

public interface IClientesDAO {
    List<ClientesEntity>findAll();
    Optional<ClientesEntity>findById(Long id);
    void createCliente(ClientesEntity clientesEntity);
    void updateCliente(ClientesEntity clientesEntity);
    void deleteCliente(ClientesEntity clientesEntity);
}
