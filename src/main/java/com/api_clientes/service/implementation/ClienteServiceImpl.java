package com.api_clientes.service.implementation;

import com.api_clientes.persistence.dao.interfaces.IClientesDAO;
import com.api_clientes.persistence.entity.ClientesEntity;
import com.api_clientes.presentation.dto.ClientesDTO;
import com.api_clientes.service.interfaces.IClientesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements IClientesService {

    @Autowired
    private IClientesDAO iClientesDAO;

    @Override
    public List<ClientesDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();

        return this.iClientesDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ClientesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientesDTO findById(Long id) {
        Optional<ClientesEntity> clientesEntity = this.iClientesDAO.findById(id);
        if(clientesEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            ClientesEntity currentClientes = clientesEntity.get();
            return modelMapper.map(currentClientes,ClientesDTO.class);
        }
        return new ClientesDTO();
    }

    @Override
    public ClientesDTO createCliente(ClientesDTO clientesDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            ClientesEntity clientesEntity = modelMapper.map(clientesDTO, ClientesEntity.class);
            this.iClientesDAO.createCliente(clientesEntity);
            return clientesDTO;
        } catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el usuario");
        }
    }

    @Override
    public ClientesDTO updateCliente(Long id, ClientesDTO clientesDTO) {
        Optional<ClientesEntity>clientesEntity = this.iClientesDAO.findById(id);
        if(clientesEntity.isPresent()){
            ClientesEntity currentCliente = clientesEntity.get();
            currentCliente.setName(clientesDTO.getName());
            currentCliente.setEmail(clientesDTO.getEmail());
            currentCliente.setPhone(clientesDTO.getPhone());
            currentCliente.setAddress(clientesDTO.getAddress());
            this.iClientesDAO.updateCliente(currentCliente);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentCliente,ClientesDTO.class);
        } else {
            throw new IllegalArgumentException("El usuario no existe");
        }
    }

    @Override
    public String deleteCliente(Long id) {
        Optional<ClientesEntity> clientesEntity = this.iClientesDAO.findById(id);
        if(clientesEntity.isPresent()){
            ClientesEntity currentCliente = clientesEntity.get();
            this.iClientesDAO.deleteCliente(currentCliente);
            return "Cliente con id " + id + " ha sido eliminado.";
        }else {
            return "El cliente con id " + id + " no existe.";
        }

    }
}
