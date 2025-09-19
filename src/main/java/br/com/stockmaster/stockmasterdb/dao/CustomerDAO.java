/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.dao;

import br.com.stockmaster.stockmasterdb.classes.Customer;
import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CustomerDAO {
    public void delete(int id){
    EntityManager em = JPAUtil.getEntityManager();
    try{
        Customer c = em.find(Customer.class, id);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }finally{
        em.close();
    }
    }
    
    public Customer findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public List<Customer> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Customer s", Customer.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}
