package br.com.stockmaster.stockmasterdb.classes;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

/**
 * Classe que representa uma venda de produto
 * Cada instância representa um registro de venda, associando produto, cliente, quantidade, valor e lucro
 */

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product; // Produto vendido
    
    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
    
    @Column(nullable = false)
    private int quantity;
    
    @Column(name = "saleDate", nullable = false)
    private LocalDate date;
    
    @Column(nullable = false)
    private BigDecimal value;
    
    @Column(nullable = false)
    private BigDecimal profit;

  
    public Sale(){}

    
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

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }
}