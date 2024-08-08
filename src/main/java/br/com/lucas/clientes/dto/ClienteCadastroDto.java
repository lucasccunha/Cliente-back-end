package br.com.lucas.clientes.dto;

import br.com.lucas.clientes.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteCadastroDto(
        @NotBlank(message = "CNPJ é obrigatório")
        String cnpj,

        @NotBlank(message = "Razão Social é obrigatório")
        String razaoSocial,
        @NotBlank(message = "Nome Obrigatório")
        String usuario,

        @NotBlank(message = "Senha é Obrigatória")
                @Size(min = 6, max= 10, message = "A senha deve conter entre 6 e 10 caracteres.")
        String senha,

        Status status
) {
}
