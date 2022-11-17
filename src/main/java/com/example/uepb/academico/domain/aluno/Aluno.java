package com.example.uepb.academico.domain.aluno;

import com.example.uepb.academico.domain.endereco.Endereco;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String matricula;

    @Column
    private String nome;

    @Column
    private String cpf;

    @OneToOne
    @JoinColumn
    private Endereco endereco;

    @Column
    private String curso;

    public Aluno(Long id, String matricula, String nome, String cpf, Endereco endereco, String curso) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.curso = curso;
    }
}
