package com.example.uepb.academico.api;

import com.example.uepb.academico.domain.professor.Professor;
import com.example.uepb.academico.domain.professor.ProfessorService;
import com.example.uepb.academico.dto.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> getProfessores(){
        return ResponseEntity.ok(professorService.getProfessores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getAluno(@PathVariable("id") Long id){
        Optional<ProfessorDTO> aluno = professorService.getAlunoByIdDto(id);
        return aluno.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Professor> atualizarProfessor(@PathVariable("id") Long id, @RequestBody Professor professor) {
        Optional<Professor> professorDB = professorService.getProfessorById(id);
        return professorDB.map(pDB -> ResponseEntity.ok(professorService.updateProfessor(professor, pDB))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Professor> cadastrarProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.saveProfessor(professor));
    }

    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<Professor> deletarProfessor(@PathVariable("id") Long id) {
        Optional<Professor> professorDB = professorService.getProfessorById(id);
        return professorDB.map(pDB -> ResponseEntity.ok(professorService.deleteProfessor(professorDB.get()))).orElse(ResponseEntity.notFound().build());
    }
}
