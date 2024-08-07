package br.com.lucas.clientes.controller;

import br.com.lucas.clientes.model.Cliente;
import br.com.lucas.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.criar(cliente);
    }

    @GetMapping("/{cnpj}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarPorCnpj(@PathVariable String cnpj) {
        return clienteService.buscarClientesPorCnpj(cnpj);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarTodos() {
        return clienteService.listarClientesTodos();
    }

    @DeleteMapping("/{cnpj}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable String cnpj) {
        clienteService.excluir(cnpj);
    }
}
