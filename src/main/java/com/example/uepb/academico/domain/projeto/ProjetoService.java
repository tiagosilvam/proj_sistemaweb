package com.example.uepb.academico.domain.projeto;

import com.example.uepb.academico.dto.ProjetoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    public List<ProjetoDTO> getProjetos() {
        return repository.findAll().stream().map(ProjetoDTO::new).collect(Collectors.toList());
    }

    public Optional<ProjetoDTO> getAlunoByIdDto(Long id) {
        Optional<Projeto> aluno = getProjetoById(id);
        return aluno.map(ProjetoDTO::new);
    }

    public Optional<Projeto> getProjetoById(Long id) {
        return repository.findById(id);
    }

    public Projeto updateProjeto(Projeto projeto, Projeto projetoDB) {
        projetoDB.setTitulo(projeto.getTitulo());
        projetoDB.setProfessorResponsavel(projeto.getProfessorResponsavel());
        projetoDB.setArea(projeto.getArea());
        projetoDB.setResumo(projeto.getResumo());
        projetoDB.setPalavraChave1(projeto.getPalavraChave1());
        projetoDB.setPalavraChave2(projeto.getPalavraChave2());
        projetoDB.setPalavraChave3(projeto.getPalavraChave3());
        projetoDB.setUrl(projeto.getUrl());
        return repository.save(projetoDB);
    }

    public Projeto saveProfessor(Projeto projeto) {
        return repository.save(projeto);
    }

    public Projeto deleteProfessor(Projeto projeto) {
        repository.delete(projeto);
        return projeto;
    }
}


