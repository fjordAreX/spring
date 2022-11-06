package ru.test.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.spring.entity.ToDoEntity;
import ru.test.spring.entity.UserEntity;
import ru.test.spring.model.ToDoModel;
import ru.test.spring.repository.ToDoRepository;
import ru.test.spring.repository.UserRepository;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private UserRepository userRepository;

    public ToDoModel create(ToDoEntity entity, Long UserId) {
        UserEntity user = userRepository.findById(UserId).get();
        entity.setUser(user);
        return ToDoModel.toModel(toDoRepository.save(entity));
    }

    public ToDoModel complete(Long id) {
        ToDoEntity entity = toDoRepository.findById(id).get();
        entity.setCompleted(!entity.getCompleted());
        return ToDoModel.toModel(toDoRepository.save(entity));
    }
}
