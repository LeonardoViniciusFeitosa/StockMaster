package classes;

import java.math.BigDecimal;

/**
 * Classe que representa um produto no estoque
 * Cada instância contém informações sobre um produto específico
 * @author leona
 */
public class Product {
    // Contador estático para gerar IDs automaticamente
    private static int count = 0;
    
    // Atributos do produto
    private int id;
    private String name;          // nome do produto
    private String category;      // categoria do produto
    private String supplier;      // fornecedor
    private int quantity;         // quantidade em estoque
    private BigDecimal costValue; // valor de custo
    private BigDecimal sellValue; // valor de venda
    private String notes;         // observações

    // Construtor da classe
    public Product(String name, String category, String supplier, int initialQuantity, BigDecimal costValue, BigDecimal sellValue, String notes) {
        this.id = count++;
        this.name = name;
        this.category = category;
        this.supplier = supplier;
        this.quantity = initialQuantity;
        this.costValue = costValue;
        this.sellValue = sellValue;
        this.notes = notes;
    }

    // Métodos estáticos para contar produtos
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
   public boolean decreaseQuantity(int amount) {
    if (amount <= 0) return false; // não faz sentido retirar <= 0

    if (amount > this.quantity) {
        return false; // não pode retirar mais do que tem
    }

    this.quantity -= amount;
    return true; // sucesso
}
   
      public boolean increaseQuantity(int amount) {
    if (amount <= 0) return false; // não faz sentido retirar <= 0

    this.quantity += amount;
    return true; // sucesso
}

    @Override
    public String toString() {
        return this.getName();
    }
}
