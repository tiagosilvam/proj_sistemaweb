package com.example.uepb.academico.domain.projeto;

import com.example.uepb.academico.domain.professor.Professor;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @OneToOne
    @JoinColumn
    private Professor professorResponsavel;

    @Column
    private String area;

    @Column
    private String resumo;

    @Column
    private String palavraChave1;

    @Column
    private String palavraChave2;

    @Column
    private String palavraChave3;

    @Column
    private String url;
}
