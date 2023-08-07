package com.example.todoapp.controller;

import com.example.todoapp.entity.ToDoEntity;
import com.example.todoapp.repository.ToDoRepository;
import com.example.todoapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }
    @PostMapping("/")
    public ToDoEntity createToDo(@RequestBody ToDoEntity toDoEntity) {
        return toDoService.createToDo(toDoEntity);
    }

    @GetMapping("/")
    public List<ToDoEntity> getAllToDo() {
        return toDoService.getAllToDo();
    }

//    @GetMapping("/")
//    public String helloWorld(){
//        return "To-do Application !";
//    }

    @GetMapping("/{id}")
    public ToDoEntity getToDoById(@PathVariable Long id) {
        return toDoService.getToDoById(id);
    }

    @PatchMapping("/{id}")
    public ToDoEntity updateToDo(@PathVariable Long id, @RequestBody ToDoEntity toDoEntity) {
        return toDoService.updateToDo(id, toDoEntity);
    }

    @DeleteMapping("/")
    public void deleteAllToDo() {
        toDoService.deleteAllToDo();
    }

    @DeleteMapping("/{id}")
    public void deleteToDoById(@PathVariable Long id) {
        toDoService.deleteToDoById(id);
    }
}
