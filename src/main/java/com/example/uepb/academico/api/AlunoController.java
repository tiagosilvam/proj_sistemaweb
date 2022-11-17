package com.example.uepb.academico.api;

import com.example.uepb.academico.domain.aluno.Aluno;
import com.example.uepb.academico.domain.aluno.AlunoService;
import com.example.uepb.academico.dto.AlunoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAlunos(){
        return ResponseEntity.ok(alunoService.getAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAluno(@PathVariable("id") Long id){
        Optional<AlunoDTO> aluno = alunoService.getAlunoByIdDto(id);
        return aluno.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoDB = alunoService.getAlunoById(id);
        return alunoDB.map(aDB -> ResponseEntity.ok(alunoService.updateAluno(aluno, aDB))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.saveAluno(aluno));
    }

    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<Aluno> deletarAluno(@PathVariable("id") Long id) {
        Optional<Aluno> alunoDB = alunoService.getAlunoById(id);
        return alunoDB.map(aDB -> ResponseEntity.ok(alunoService.deleteAluno(alunoDB.get()))).orElse(ResponseEntity.notFound().build());
    }
}
