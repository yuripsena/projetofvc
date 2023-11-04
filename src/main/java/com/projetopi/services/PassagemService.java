package com.projetopi.services;

import com.projetopi.entidades.Passagem;
import com.projetopi.entidades.PassagemNotFoundException;
import com.projetopi.repositories.PassagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassagemService {

    @Autowired
    private PassagemRepository passagemRepository;

    public List<Passagem> listAll() {
        return (List<Passagem>) passagemRepository.findAll();
    }

    public void save(Passagem passagem) {
        passagemRepository.save(passagem);
    }

    public Passagem get(Integer id) throws PassagemNotFoundException {
        Optional<Passagem> result = passagemRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new PassagemNotFoundException("Não foi possível encontrar nenhuma passagem com ID " + id);
    }

    public void delete(Integer id) throws PassagemNotFoundException {
        if (!passagemRepository.existsById(id)) {
            throw new PassagemNotFoundException("Não foi possível encontrar nenhuma passagem com ID " + id);
        }
        passagemRepository.deleteById(id);
    }
}