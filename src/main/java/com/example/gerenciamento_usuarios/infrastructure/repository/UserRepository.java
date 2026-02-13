package com.example.gerenciamento_usuarios.infrastructure.repository;

import com.example.gerenciamento_usuarios.infrastructure.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
