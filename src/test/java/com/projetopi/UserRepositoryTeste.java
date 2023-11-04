package com.projetopi;

import com.projetopi.repositories.UserRepository;
import com.projetopi.entidades.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTeste {
    @Autowired
    private UserRepository repo;

    @Test
    public void testAddNew() {
        User users = new User();
        users.setCargo("aa");
        users.setEmail("ssasasa");
        users.setNome("aaaa");
        users.setLogin("aaaaa");
        users.setSenha("senha");

        User savedUser = repo.save(users);

       Assertions.assertThat(savedUser).isNotNull();
       Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
