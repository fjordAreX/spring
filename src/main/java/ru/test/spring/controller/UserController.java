package ru.test.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.spring.entity.UserEntity;
import ru.test.spring.exception.UserAlreadyExistsException;
import ru.test.spring.exception.UserDoesNotExistException;
import ru.test.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> getUsers(){
        try{
            return ResponseEntity.ok("Server is working");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred in Server");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("User created");

        }catch (UserAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }catch (Exception e){
            return ResponseEntity.badRequest().body("User NOT saved");
        }
    }

    @GetMapping("/show")
    public ResponseEntity getOne(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserDoesNotExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id){
        try {
            userService.deleteOne(id);
            return ResponseEntity.ok("User has been Deleted");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }

    }

}
