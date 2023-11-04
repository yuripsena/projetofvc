package com.projetopi.repositories;

import com.projetopi.entidades.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    public Long countById(Integer id);

    List<User> findByNomeContaining(String name);

}
