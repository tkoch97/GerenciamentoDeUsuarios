package com.example.gerenciamento_usuarios.shared.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("Usuário não encontrado no banco de dados.");
    }
}
