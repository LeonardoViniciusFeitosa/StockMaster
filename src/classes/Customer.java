package classes;

/**
 * Classe que representa um cliente
 * Cada instância representa um cliente com informações básicas de contato
 */
public class Customer {
    // Contador estático para gerar IDs automaticamente
    private static int count = 0;

    // Atributos do cliente
    private int id;
    private String name;
    private String document; // CPF ou CNPJ
    private String address;
    private String number;   // telefone ou celular
    private String email;
    private String notes;    // observações adicionais

    /**
     * Construtor da classe Customer
     */
    public Customer(String name, String document, String address, String number, String email, String notes) {
        this.id = count++;
        this.name = name;
        this.document = document;
        this.address = address;
        this.number = number;
        this.email = email;
        this.notes = notes;
    }

    // Métodos estáticos para contar clientes
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Customer.count = count;
    }

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
