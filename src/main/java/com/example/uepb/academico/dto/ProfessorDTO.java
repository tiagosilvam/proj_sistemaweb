package com.example.uepb.academico.dto;

import com.example.uepb.academico.domain.endereco.Endereco;
import com.example.uepb.academico.domain.professor.Professor;
import lombok.Data;

@Data
public class ProfessorDTO {

    private Long id;
    private String matricula;
    private String nome;
    private Endereco endereco;
    private String curso;

    public ProfessorDTO(Professor professor) {
        id = professor.getId();
        matricula = professor.getMatricula();
        nome = professor.getNome();
        endereco = professor.getEndereco();
        curso = professor.getCurso();
    }
}