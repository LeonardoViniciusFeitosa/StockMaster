package br.com.stockmaster.stockmasterdb.classes;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Classe que representa uma entrada de produto no estoque
 * Cada instância representa um registro de entrada de um produto
 * @author leona
 */

@Entity
@Table(name = "stock_entries")
public class StockEntry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "supplierId", nullable = false)
    private Supplier supplier;
    
    @Column(nullable = false)
    private int quantity;
    
    @Column(name = "entryDate", nullable = false)
    private LocalDate date;
    
    @Column(columnDefinition = "TEXT")
    private String notes;


    public StockEntry(){}


    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct() {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplierName(String supplierName) {
        this.supplier.setName(supplierName);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String dateString) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
