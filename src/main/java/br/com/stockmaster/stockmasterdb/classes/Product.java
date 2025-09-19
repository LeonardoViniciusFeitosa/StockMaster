package br.com.stockmaster.stockmasterdb.classes;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Classe que representa um produto no estoque
 * Cada instância contém informações sobre um produto específico
 * @author leona
 */

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String category;
    
    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;
    
    @Column (nullable = false)
    private int quantity;
    
    @Column (nullable = false)
    private BigDecimal costValue;
    
    @Column (nullable = false)
    private BigDecimal sellValue;
    
    @Column (nullable = false)
    private String notes;

    // Construtor da classe
    public Product(){}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCostValue() {
        return costValue;
    }

    public void setCostValue(BigDecimal costValue) {
        this.costValue = costValue;
    }

    public BigDecimal getSellValue() {
        return sellValue;
    }

    public void setSellValue(BigDecimal sellValue) {
        this.sellValue = sellValue;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
   public boolean decreaseQuantity(int amount) {
    if (amount <= 0) return false; // não retirar <= 0

    if (amount > this.quantity) {
        return false; // não pode retirar mais do que tem
    }

    this.quantity -= amount;
    return true;
}
   
      public boolean increaseQuantity(int amount) {
    if (amount <= 0) return false; // não retirar <= 0

    this.quantity += amount;
    return true;
}

    @Override
    public String toString() {
        return this.getName();
    }
}
