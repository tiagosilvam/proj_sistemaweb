package com.example.uepb.academico.api;

import com.example.uepb.academico.domain.projeto.Projeto;
import com.example.uepb.academico.domain.projeto.ProjetoService;
import com.example.uepb.academico.dto.ProjetoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> getProjetos(){
        return ResponseEntity.ok(projetoService.getProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> getAluno(@PathVariable("id") Long id){
        Optional<ProjetoDTO> aluno = projetoService.getAlunoByIdDto(id);
        return aluno.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Projeto> atualizarProjeto(@PathVariable("id") Long id, @RequestBody Projeto projeto) {
        Optional<Projeto> projetoDB = projetoService.getProjetoById(id);
        return projetoDB.map(pDB -> ResponseEntity.ok(projetoService.updateProjeto(projeto, pDB))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Projeto> cadastrarProjeto(@RequestBody Projeto projeto) {
        return ResponseEntity.ok(projetoService.saveProfessor(projeto));
    }

    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<Projeto> deletarProjeto(@PathVariable("id") Long id) {
        Optional<Projeto> projetoDB = projetoService.getProjetoById(id);
        return projetoDB.map(pDB -> ResponseEntity.ok(projetoService.deleteProfessor(projetoDB.get()))).orElse(ResponseEntity.notFound().build());
    }
}
