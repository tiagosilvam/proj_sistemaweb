package com.example.uepb.academico.domain.aluno;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.uepb.academico.dto.AlunoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<AlunoDTO> getAlunos() {
        return repository.findAll().stream().map(AlunoDTO::new).collect(Collectors.toList());
    }

    public Optional<Aluno> getAlunoById(Long id) {
        return repository.findById(id);
    }

    public Optional<AlunoDTO> getAlunoByIdDto(Long id) {
        Optional<Aluno> aluno = getAlunoById(id);
        return aluno.map(AlunoDTO::new);
    }

    public Aluno updateAluno(Aluno aluno, Aluno alunoDB) {
        alunoDB.setMatricula(aluno.getMatricula());
        alunoDB.setNome(aluno.getNome());
        alunoDB.setCpf(aluno.getCpf());
        alunoDB.setEndereco(aluno.getEndereco());
        alunoDB.setCurso(aluno.getCurso());
        return repository.save(alunoDB);
    }

    public Aluno saveAluno(Aluno aluno) {
        return repository.save(aluno);
    }

    public Aluno deleteAluno(Aluno aluno) {
        repository.delete(aluno);
        return aluno;
    }
}


