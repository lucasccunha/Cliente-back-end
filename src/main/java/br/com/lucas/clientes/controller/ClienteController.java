package br.com.lucas.clientes.controller;

import br.com.lucas.clientes.dto.ClienteCadastroDto;
import br.com.lucas.clientes.dto.ClienteExibicaoDto;
import br.com.lucas.clientes.model.Cliente;
import br.com.lucas.clientes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteExibicaoDto salvar(@RequestBody @Valid ClienteCadastroDto clientecadastroDto) {
        return clienteService.criar(clientecadastroDto);
    }

    @GetMapping("/cnpj/{cnpj}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteExibicaoDto buscarPorCnpj(@PathVariable String cnpj) {
        return clienteService.buscarClientesPorCnpj(cnpj);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarTodos() {
        return clienteService.listarClientesTodos();
    }

    @PutMapping("/editar")
    @ResponseStatus(HttpStatus.OK)
    public Cliente editar(@RequestBody Cliente cliente) {
        return clienteService.editar(cliente);
    }

    @DeleteMapping("/cnpj/{cnpj}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable String cnpj) {
        clienteService.excluir(cnpj);
    }

    @GetMapping("/razaosocial/{razaoSocial}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarPorRazaoSocial(@PathVariable String razaoSocial) {
        return clienteService.buscarPorRazaoSocial(razaoSocial);
    }
}
