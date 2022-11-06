package ru.test.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.spring.entity.UserEntity;
import ru.test.spring.exception.UserAlreadyExistsException;
import ru.test.spring.exception.UserDoesNotExistException;
import ru.test.spring.model.UserModel;
import ru.test.spring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registration(UserEntity user) throws UserAlreadyExistsException {
        if(userRepository.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistsException("User exists, try again");
        }
        userRepository.save(user);
    }

    public UserModel getOne(Long id) throws UserDoesNotExistException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null){
            throw new UserDoesNotExistException("User with such id does not exist");
        } else{
            return UserModel.toModel(user);
        }
    }

    public void deleteOne(Long id){
        userRepository.deleteById(id);
    }

}
