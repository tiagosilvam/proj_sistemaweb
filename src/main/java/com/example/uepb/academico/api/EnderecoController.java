package com.example.uepb.academico.api;

import com.example.uepb.academico.domain.endereco.Endereco;
import com.example.uepb.academico.domain.endereco.EnderecoService;
import com.example.uepb.academico.dto.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> getEnderecos(){
        return ResponseEntity.ok(enderecoService.getEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getAluno(@PathVariable("id") Long id){
        Optional<EnderecoDTO> aluno = enderecoService.getEnderecoByIdDto(id);
        return aluno.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
        Optional<Endereco> enderecoDB = enderecoService.getEnderecoById(id);
        return enderecoDB.map(eDB -> ResponseEntity.ok(enderecoService.updateEndereco(endereco, eDB))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.saveEndereco(endereco));
    }

    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<Endereco> deletarEndereco(@PathVariable("id") Long id) {
        Optional<Endereco> enderecoDB = enderecoService.getEnderecoById(id);
        return enderecoDB.map(pDB -> ResponseEntity.ok(enderecoService.deleteEndereco(enderecoDB.get()))).orElse(ResponseEntity.notFound().build());
    }
}
