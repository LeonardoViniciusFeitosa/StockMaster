package classes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe que representa uma venda de produto
 * Cada instância representa um registro de venda, associando produto, cliente, quantidade, valor e lucro
 */
public class Sale {
    // Contador estático para gerar IDs automaticamente
    private static int count = 0;

    // Formato de data brasileiro
    private static final DateTimeFormatter BRAZILIAN_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Atributos da venda
    private int id;
    private Product product;    // produto vendido
    private Customer customer;  // cliente que comprou
    private int quantity;       // quantidade vendida
    private LocalDate date;     // data da venda
    private BigDecimal value;   // valor total da venda
    private BigDecimal profit;  // lucro obtido

    /**
     * Construtor da classe Sale
     * @param dateString recebe a data da venda no formato DD/MM/YYYY
     */
    public Sale(Product product, Customer customer, int quantity, String dateString, BigDecimal value, BigDecimal profit) {
        this.id = count++;
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
        this.date = LocalDate.parse(dateString, BRAZILIAN_FORMATTER);
        this.value = value;
        this.profit = profit;
    }

    // Métodos estáticos para contar vendas
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Sale.count = count;
    }

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

    // Aceita data como String no formato DD/MM/YYYY
    public void setDate(String dateString) {
        this.date = LocalDate.parse(dateString, BRAZILIAN_FORMATTER);
    }

    // Retorna a data como String no formato DD/MM/YYYY
    public String getDateAsString() {
        return date.format(BRAZILIAN_FORMATTER);
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