package com.example.uepb.academico.domain.professor;

import com.example.uepb.academico.domain.endereco.Endereco;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String matricula;

    @Column
    private String nome;

    @OneToOne
    @JoinColumn
    private Endereco endereco;

    @Column
    private String curso;
}
