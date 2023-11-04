package com.projetopi.services;

import com.projetopi.repositories.UserRepository;
import com.projetopi.entidades.User;
import com.projetopi.entidades.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepository repo;

    public List<User> listAll() {
        var list = (List<User>) repo.findAll();
        System.out.println(list.size());
        return list;
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
       Optional<User> result = repo.findById(id);
       if (result.isPresent()) {
           return result.get();
       }
       throw new UserNotFoundException("não foi possível encontrar nenhum usuário com Id" +id);
    }
    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count ==null || count == 0) {
            throw new UserNotFoundException("não foi possível encontrar nenhum usuário com Id" +id);

        }
        repo.deleteById(id);
    }

    public List<User> searchByName(String name) {
        return repo.findByNomeContaining(name);
    }

}
