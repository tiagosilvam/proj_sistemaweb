package com.example.uepb.academico.dto;

import com.example.uepb.academico.domain.professor.Professor;
import com.example.uepb.academico.domain.projeto.Projeto;
import lombok.Data;

@Data
public class ProjetoDTO {

    private Long id;
    private String titulo;
    private Professor professor;
    private String area;
    private String resumo;
    private String palavrachave1;
    private String palavrachave2;
    private String palavrachave3;
    private String url;

    public ProjetoDTO(Projeto projeto) {
        id = projeto.getId();
        titulo = projeto.getTitulo();
        professor = projeto.getProfessorResponsavel();
        area = projeto.getArea();
        resumo = projeto.getResumo();
        palavrachave1 = projeto.getPalavraChave1();
        palavrachave2 = projeto.getPalavraChave2();
        palavrachave3 = projeto.getPalavraChave3();
        url = projeto.getUrl();
    }
}