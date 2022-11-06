package ru.test.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.spring.entity.ToDoEntity;
import ru.test.spring.model.ToDoModel;
import ru.test.spring.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody ToDoEntity entity, @RequestParam Long id){

        try {
            return ResponseEntity.ok(toDoService.create(entity,id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error has occurred. Try again");
        }
    }




    @PutMapping("/{id}/complete")
    public ResponseEntity<String> complete(@PathVariable Long id){
        try{
            ToDoModel complete = toDoService.complete(id);
            return ResponseEntity.ok("the task is done: "+complete.getCompleted());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error has occurred. Try again");
        }
    }
}
