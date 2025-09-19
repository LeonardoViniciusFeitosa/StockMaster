package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe que representa uma entrada de produto no estoque
 * Cada instância representa um registro de entrada de um produto
 * @author leona
 */
public class StockEntry {
    // Contador estático para gerar IDs automaticamente
    private static int count = 0;

    // Formato de data brasileiro
    private static final DateTimeFormatter BRAZILIAN_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    // Atributos da entrada
    private int id;
    private String productName;   // nome do produto
    private String supplierName;  // fornecedor do produto
    private int quantity;         // quantidade de produtos entrando no estoque
    private LocalDate date;       // data da entrada
    private String notes;         // observações

    // Construtor da classe, recebe data como String no formato DD/MM/YYYY
    public StockEntry(String productName, String supplierName, int quantity, String dateString, String notes) {
        this.id = count++;
        this.productName = productName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.date = LocalDate.parse(dateString, BRAZILIAN_FORMATTER);
        this.notes = notes;
    }

    // Métodos estáticos para contar entradas
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        StockEntry.count = count;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    // Aceita data como String no formato DD/MM/YYYY
    public void setDate(String dateString) {
        this.date = LocalDate.parse(dateString, BRAZILIAN_FORMATTER);
    }

    // Retorna a data como String no formato DD/MM/YYYY
    public String getDateAsString() {
        return date.format(BRAZILIAN_FORMATTER);
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
