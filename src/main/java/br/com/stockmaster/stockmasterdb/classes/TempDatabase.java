package br.com.stockmaster.stockmasterdb.classes;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe que simula um banco de dados temporário na memória
 * Armazena listas de produtos, fornecedores, clientes, funcionários, entradas, saídas e vendas
 */
public class TempDatabase {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Supplier> suppliers = new ArrayList<>();
    private static List<Employer> employers = new ArrayList<>();
    private static List<StockEntry> entries = new ArrayList<>();
    private static List<StockOut> outs = new ArrayList<>();
    private static List<Sale> sales = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static User activeUser;
    
    // Users
    public static void setActiveUser(User u) {
    activeUser = u;
}

public static User getActiveUser() {
    return activeUser;
}

public static void addUser(User u) {
    users.add(u);
}

public static User getUserByUsername(String username) {
    for (User u : users) {
        if (u.getUsername().equalsIgnoreCase(username)) {
            return u;
        }
    }
    return null;
}

public static List<User> getUsers() {
    return users;
}


    // Products
    public static void addProduct(Product p){
        products.add(p);
    }
    
    public static void removeProduct(Product p){
        products.remove(p);
    }
    
    public static List<Product> getProducts(){
        return products;
    }
    
    public static Product getProductById(int id){
        for (Product p : products){
            if (p.getId() == id) return p;
        }
        return null;
    }
    
    // Suppliers
    public static void addSupplier(Supplier s){
        suppliers.add(s);
    }
    
    public static void removeSupplier(Supplier s){
        suppliers.remove(s);
    }
    
    public static List<Supplier> getSuppliers(){
        return suppliers;
    }
    
    public static Supplier getSupplierById(int id){
        for (Supplier s : suppliers){
            if (s.getId() == id) return s;
        }
        return null;
    }
    
    // Customers
    public static void addCustomer(Customer c){
        customers.add(c);
    }
    
    public static void removeCustomer(Customer c){
        customers.remove(c);
    }
    
    public static List<Customer> getCustomers(){
        return customers;
    }
    
    public static Customer getCustomerById(int id){
        for (Customer c : customers){
            if (c.getId() == id) return c;
        }
        return null;
    }
    
    // Employers
    public static void addEmployer(Employer e){
        employers.add(e);
    }
    
    public static void removeEmployer(Employer e){
        employers.remove(e);
    }
    
    public static List<Employer> getEmployers(){
        return employers;
    }
    
    public static Employer getEmployerById(int id){
        for (Employer e : employers){
            if (e.getId() == id) return e;
        }
        return null;
    }
    
    // Stock Entries
    public static void addStockEntry(StockEntry e){
        entries.add(e);
    }
    
    public static List<StockEntry> getEntries(){
        return entries;
    }
    
    public static StockEntry getEntryById(int id){
        for (StockEntry e : entries){
            if (e.getId() == id) return e;
        }
        return null;
    }
    
    // Stock Outs
    public static void addStockOut(StockOut o){
        outs.add(o);
    }
    
    public static List<StockOut> getOuts(){
        return outs;
    }
    
    public static StockOut getOutById(int id){
        for (StockOut o : outs){
            if (o.getId() == id) return o;
        }
        return null;
    }
    
    // Sales
    public static void addSale(Sale s){
        sales.add(s);
    }
    
    public static List<Sale> getSales(){
        return sales;
    }
    
    public static Sale getSaleById(int id){
        for(Sale s : sales){
            if (s.getId() == id) return s;
        }
        return null;
    }
}
