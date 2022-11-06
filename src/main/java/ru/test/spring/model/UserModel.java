package ru.test.spring.model;

import ru.test.spring.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
    private Long id;
    private String username;

    private List<ToDoModel> tasks;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<ToDoModel> getTasks() {
        return tasks;
    }

    public UserModel(Long id, String username, List<ToDoModel> tasks) {
        this.id = id;
        this.username = username;
        this.tasks = tasks;
    }

    public static UserModel toModel(UserEntity entity){
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername()+" made by ModelBeast");
        model.setTasks(entity.getChores().stream().map(ToDoModel::toModel).collect(Collectors.toList()));
        return model;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserModel() {
    }

    public void setTasks(List<ToDoModel> tasks) {
        this.tasks = tasks;
    }
}
