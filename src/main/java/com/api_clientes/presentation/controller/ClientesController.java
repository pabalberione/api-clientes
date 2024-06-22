package com.api_clientes.presentation.controller;

import com.api_clientes.presentation.dto.ClientesDTO;
import com.api_clientes.service.interfaces.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    @Autowired
    IClientesService iClientesService;

    //Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<ClientesDTO>>findAll(){
        return new ResponseEntity<>(this.iClientesService.findAll(), HttpStatus.OK);
    }

    //Obtener clientes por id
    @GetMapping("/{id}")
    public ResponseEntity<ClientesDTO>findById(@PathVariable Long id){
        return new ResponseEntity<>(this.iClientesService.findById(id),HttpStatus.OK);
    }

    //Crear clientes
    @PostMapping()
    public ResponseEntity<ClientesDTO> createCliente(@RequestBody ClientesDTO clientesDTO){
        return new ResponseEntity<>(this.iClientesService.createCliente(clientesDTO), HttpStatus.CREATED);
    }

    //Modificar cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClientesDTO> updateCliente(@PathVariable Long id, @RequestBody ClientesDTO clientesDTO){
        return new ResponseEntity<>(this.iClientesService.updateCliente(id, clientesDTO), HttpStatus.OK);
    }

    //Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id){
        return new ResponseEntity<>(this.iClientesService.deleteCliente(id), HttpStatus.NO_CONTENT);
    }
}
