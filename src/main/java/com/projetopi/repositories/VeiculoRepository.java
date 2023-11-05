package com.projetopi.repositories;

import com.projetopi.entidades.Veiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo,Integer> {

    public Long countById(Integer id);

}