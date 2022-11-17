package com.example.uepb.academico.domain.professor;

import com.example.uepb.academico.dto.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<ProfessorDTO> getProfessores() {
        return repository.findAll().stream().map(ProfessorDTO::new).collect(Collectors.toList());
    }

    public Optional<ProfessorDTO> getAlunoByIdDto(Long id) {
        Optional<Professor> aluno = getProfessorById(id);
        return aluno.map(ProfessorDTO::new);
    }

    public Optional<Professor> getProfessorById(Long id) {
        return repository.findById(id);
    }

    public Professor updateProfessor(Professor professor, Professor professorDB) {
        professorDB.setMatricula(professor.getMatricula());
        professorDB.setNome(professor.getNome());
        professorDB.setEndereco(professor.getEndereco());
        professorDB.setCurso(professor.getCurso());
        return repository.save(professorDB);
    }

    public Professor saveProfessor(Professor professor) {
        return repository.save(professor);
    }

    public Professor deleteProfessor(Professor professor) {
        repository.delete(professor);
        return professor;
    }
}


