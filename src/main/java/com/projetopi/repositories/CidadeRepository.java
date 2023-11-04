package com.projetopi.repositories;

import com.projetopi.entidades.Cidade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CidadeRepository extends CrudRepository<Cidade, Integer> {

    public Long countById(Integer id);

    List<Cidade> findByNomeCidadeContaining(String nomeCidade);

}
