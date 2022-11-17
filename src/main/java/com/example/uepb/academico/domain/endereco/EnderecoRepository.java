package com.example.uepb.academico.domain.endereco;

import com.example.uepb.academico.domain.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {}