package co.com.sofka.crud.services;

import co.com.sofka.crud.models.TaskModel;
import co.com.sofka.crud.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public ArrayList<TaskModel> getAll(){
        return (ArrayList<TaskModel>) taskRepository.findAll();
    }

    public TaskModel save(TaskModel task){
        return taskRepository.save(task);
    }

    public boolean deleted(Long id){
        try{
            taskRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public TaskModel update(TaskModel task){
        return taskRepository.save(task);
    }
}
