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
                @Size(min = 3, max= 15, message = "A senha deve conter entre 3 e 15 caracteres.")
        String senha,

        Status status
) {
}
