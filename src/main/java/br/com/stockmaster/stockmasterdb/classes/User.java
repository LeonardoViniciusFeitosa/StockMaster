/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe que representa um usuário do sistema
 */

@Entity
@Table(name = "users") // Nome da tabela mySQL
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
    
    @Column(nullable = false, unique = true)
    private String username; // nome de usuário
    
    @Column(nullable = false)
    private String passwordHash; // senha em hash

    
    public User() {}
    
    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }
    
    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    
    @Override
    public String toString(){
    return this.getUsername();
    }
}
