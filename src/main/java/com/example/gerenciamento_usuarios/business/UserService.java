package com.example.gerenciamento_usuarios.business;

import com.example.gerenciamento_usuarios.infrastructure.entitys.User;
import com.example.gerenciamento_usuarios.infrastructure.repository.UserRepository;
import com.example.gerenciamento_usuarios.shared.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public void register(User user){
        repository.saveAndFlush(user);
    }

    public User getById(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new UserNotFoundException()
        );
    }

    public void update(Integer id, User user){
        var userInDb = getById(id);
        var updatedUser = User.builder()
                .email(user.getEmail() != null ? user.getEmail() : userInDb.getEmail())
                .name(user.getName() != null ? user.getName() : userInDb.getName())
                .lastname(user.getLastname() != null ? user.getLastname() : userInDb.getLastname())
                .id(userInDb.getId())
                .build();

        repository.saveAndFlush(updatedUser);
    }

    public void delete(Integer id){
        getById(id);
        repository.deleteById(id);
    }
}
