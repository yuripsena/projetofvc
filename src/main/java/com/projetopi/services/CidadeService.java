package com.projetopi.services;

import com.projetopi.entidades.Cidade;
import com.projetopi.entidades.CidadeNotFoundException;
import com.projetopi.entidades.UserNotFoundException;
import com.projetopi.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;

    public List<Cidade> listAll() {
        var list = (List<Cidade>) repo.findAll();
        System.out.println(list.size());
        return list;
    }

    public void save(Cidade cidade) {
        repo.save(cidade);
    }

    public Cidade get(Integer id) throws UserNotFoundException, CidadeNotFoundException {
        Optional<Cidade> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CidadeNotFoundException("não foi possível encontrar nenhuma cidade com Id" +id);
    }

    public void delete(Integer id) throws CidadeNotFoundException {
        Long count = repo.countById(id);
        if (count ==null || count == 0) {
            throw new CidadeNotFoundException("não foi possível encontrar nenhuma cidade com Id" +id);

        }
        repo.deleteById(id);
    }

    public List<Cidade> searchByNomeCidade(String nomeCidade) {
        return repo.findByNomeCidadeContaining(nomeCidade);
    }

}
