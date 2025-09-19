package br.com.stockmaster.stockmasterdb.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * Classe que representa um cliente
 * Cada instância representa um cliente com informações básicas de contato
 */
@Entity
@Table(name = "customers")
public class Customer {

    // Atributos do cliente
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String document; // CPF ou CNPJ
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String number;   // telefone ou celular
    
    @Column (nullable = false, unique = true)
    private String email;
    
    private String notes;    // observações adicionais

public Customer() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    // Setter de ID geralmente não é necessário, pois o ID é gerado automaticamente
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Retorna o nome do cliente como representação da instância
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
