package ru.test.spring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_entity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<ToDoEntity> chores;

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity(Long id, String username, String password, List<ToDoEntity> chores) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.chores = chores;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDoEntity> getChores() {
        return chores;
    }

    public void setChores(List<ToDoEntity> chores) {
        this.chores = chores;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public UserEntity() {}
}
