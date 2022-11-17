package com.example.uepb.academico.domain.endereco;

import com.example.uepb.academico.domain.aluno.Aluno;
import com.example.uepb.academico.dto.AlunoDTO;
import com.example.uepb.academico.dto.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<EnderecoDTO> getEnderecos() {
        return repository.findAll().stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }

    public Optional<Endereco> getEnderecoById(Long id) {
        return repository.findById(id);
    }

    public Optional<EnderecoDTO> getEnderecoByIdDto(Long id) {
        Optional<Endereco> aluno = getEnderecoById(id);
        return aluno.map(EnderecoDTO::new);
    }

    public Endereco updateEndereco(Endereco endereco, Endereco enderecoDB) {
        enderecoDB.setRua(endereco.getRua());
        enderecoDB.setNumero(endereco.getNumero());
        enderecoDB.setCep(endereco.getCep());
        enderecoDB.setCidade(endereco.getCidade());
        enderecoDB.setEstado(endereco.getEstado());
        enderecoDB.setPais(endereco.getPais());
        return repository.save(enderecoDB);
    }

    public Endereco saveEndereco(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco deleteEndereco(Endereco endereco) {
        repository.delete(endereco);
        return endereco;
    }
}


