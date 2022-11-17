package com.example.uepb.academico.domain.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface AlunoRepository extends CrudRepository<Aluno, Long> {}
public interface AlunoRepository extends JpaRepository<Aluno, Long> {}
