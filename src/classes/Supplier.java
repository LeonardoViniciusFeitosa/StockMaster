package classes;

/**
 * Classe que representa um fornecedor
 * Cada instância representa um fornecedor cadastrado no sistema
 * @author leona
 */
public class Supplier {
    // Contador estático para gerar IDs automaticamente
    private static int count = 0;
    
    // Atributos do fornecedor
    private int id;
    private String name;      // nome do fornecedor
    private String taxId;     // CNPJ
    private String address;   // endereço
    private String number;    // telefone ou número de contato
    private String email;     // e-mail
    private String notes;     // observações

    // Construtor da classe
    public Supplier(String name, String taxId, String address, String number, String email, String notes) {
        this.id = count++;
        this.name = name;
        this.taxId = taxId;
        this.address = address;
        this.number = number;
        this.email = email;
        this.notes = notes;
    }

    // Métodos estáticos para contar fornecedores
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Supplier.count = count;
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

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
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
}
