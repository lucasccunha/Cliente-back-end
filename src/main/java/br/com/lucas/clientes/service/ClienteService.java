package br.com.lucas.clientes.service;

import br.com.lucas.clientes.model.Cliente;
import br.com.lucas.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientesTodos() {
        return clienteRepository.findAll();

    }

    public Cliente buscarClientesPorCnpj(String cnpj) {
        var clienteOptional = clienteRepository.findById(cnpj);

        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new RuntimeException("Cliente não Existe!");
        }
    }

    public void excluir(String cnpj) {
        clienteRepository.deleteById(cnpj);
    }

    public Cliente editar(Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getCnpj());
        if (clienteOptional.isPresent()) {
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public Cliente buscarPorRazaoSocial(String razaoSocial) {
        Optional<Cliente> clienteOptional = clienteRepository.findByRazaoSocial(razaoSocial);

        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }
}
