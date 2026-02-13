package com.example.gerenciamento_usuarios.controller;

import com.example.gerenciamento_usuarios.business.UserService;
import com.example.gerenciamento_usuarios.infrastructure.entitys.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<Void> CreateProfile(@RequestBody User request){
        userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("show")
    public ResponseEntity<User> GetUserProfile(@RequestParam Integer id){
        var serviceResponse = userService.getById(id);
        return ResponseEntity.ok(serviceResponse);
    }

    @PutMapping("update")
    public ResponseEntity<Void> UpdateUserProfile(@RequestParam Integer id,@RequestBody User request){
        userService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> DeleteUserProfile(Integer id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
