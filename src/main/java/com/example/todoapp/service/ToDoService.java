package com.example.todoapp.service;

import com.example.todoapp.entity.ToDoEntity;
import com.example.todoapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDoEntity createToDo(ToDoEntity toDoEntity) {
        return toDoRepository.save(toDoEntity);
    }

    public List<ToDoEntity> getAllToDo() {
        return toDoRepository.findAll();
    }

    public ToDoEntity getToDoById(Long id) {
        return toDoRepository.findById(id).orElse(null);
    }

    public ToDoEntity updateToDo(Long id, ToDoEntity toDoEntity) {
        Optional<ToDoEntity> existingToDo = toDoRepository.findById(id);
        if (existingToDo.isPresent()) {
            ToDoEntity updatedToDo = existingToDo.get();
            updatedToDo.setTitle(toDoEntity.getTitle());
            updatedToDo.setTodoOrder(toDoEntity.getTodoOrder());
            updatedToDo.setCompleted(toDoEntity.isCompleted());
            return toDoRepository.save(updatedToDo);
        }
        return null;
    }

    public void deleteAllToDo() {
        toDoRepository.deleteAll();
    }

    public void deleteToDoById(Long id) {
        toDoRepository.deleteById(id);
    }
}