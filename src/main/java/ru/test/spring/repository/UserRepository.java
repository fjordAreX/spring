package ru.test.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.test.spring.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

}
