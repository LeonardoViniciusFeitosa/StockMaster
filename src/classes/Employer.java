package classes;

/**
 * Classe que representa um funcionário da empresa
 * @author leona
 */
public class Employer {
    // Contador estático para gerar IDs automaticamente
    private static int count = 0;
    
    // Atributos do funcionário
    private int id;
    private String name;
    private String personalId; // CPF
    private String address;
    private String number;
    private String email;
    private String role;

    // Construtor da classe
    public Employer(String name, String personalId, String address, String number, String email, String role) {
        this.id = count++;
        this.name = name;
        this.personalId = personalId;
        this.address = address;
        this.number = number;
        this.email = email;
        this.role = role;
    }

    // Métodos estáticos para contar funcionários
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employer.count = count;
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

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
