package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.TaskModel;
import co.com.sofka.crud.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping()
    public ArrayList<TaskModel> getAll(){
        return taskService.getAll();
    }

    @PostMapping()
    public TaskModel save(@RequestBody TaskModel task){
        return this.taskService.save(task);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean correct = this.taskService.deleted(id);
        if (correct){
            return "Se eliminó el usuario con id: " + id;
        }else{
            return "No se pudo eliminar el usuario con id: " + id;
        }
    }

    @PutMapping()
    public TaskModel update(@RequestBody TaskModel task){
        return this.taskService.update(task);
    }
}
