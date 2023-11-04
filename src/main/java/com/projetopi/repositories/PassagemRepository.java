package com.projetopi.repositories;

import com.projetopi.entidades.Passagem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository extends CrudRepository<Passagem, Integer> {

}