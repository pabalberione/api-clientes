package com.api_clientes.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientesDTO {
    private Long id;
    private String name;
    private String email;
    private Long phone;
    private String address;
}
