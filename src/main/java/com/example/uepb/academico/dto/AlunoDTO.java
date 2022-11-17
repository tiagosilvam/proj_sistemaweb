package com.example.uepb.academico.dto;

import com.example.uepb.academico.domain.aluno.Aluno;
import com.example.uepb.academico.domain.endereco.Endereco;
import lombok.Data;

@Data
public class AlunoDTO {

    private Long id;
    private String matricula;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private String curso;

    public AlunoDTO(Aluno aluno) {
        id = aluno.getId();
        matricula = aluno.getMatricula();
        nome = aluno.getNome();
        cpf = aluno.getCpf();
        endereco = aluno.getEndereco();
        curso = aluno.getCurso();
    }

    public String getCpf() {
        if(cpf != null) {
            return cpf.replace(cpf.substring(2, 9), "*.***.*");
        }
        return cpf;
    }
}