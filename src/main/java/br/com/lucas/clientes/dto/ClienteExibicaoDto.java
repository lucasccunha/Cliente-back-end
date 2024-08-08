package br.com.lucas.clientes.dto;

import br.com.lucas.clientes.model.Cliente;

public record ClienteExibicaoDto(
        String cnpj,
        String razaoSocial,
        String usuario,
        String status

) {

    public ClienteExibicaoDto (Cliente cliente){
        this(
                cliente.getCnpj(),
                cliente.getUsuario(),
                cliente.getRazaoSocial(),
                cliente.getStatus().toString());
    }

}
