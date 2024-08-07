package br.com.lucas.clientes.repository;

import br.com.lucas.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    public Optional<Cliente> findByRazaoSocial(String razaoSocial );
}
