package com.example.uepb.academico.dto;

import com.example.uepb.academico.domain.endereco.Endereco;
import lombok.Data;

@Data
public class EnderecoDTO {

    private Long id;
    private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public EnderecoDTO(Endereco endereco) {
        id = endereco.getId();
        rua = endereco.getRua();
        numero = endereco.getNumero();
        cep = endereco.getCep();
        cidade = endereco.getCidade();
        estado = endereco.getEstado();
        pais = endereco.getPais();
    }
}