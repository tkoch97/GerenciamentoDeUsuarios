package com.example.gerenciamento_usuarios.infrastructure.entitys;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true, length = 254)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name="lastname")
    private String lastname;
}
