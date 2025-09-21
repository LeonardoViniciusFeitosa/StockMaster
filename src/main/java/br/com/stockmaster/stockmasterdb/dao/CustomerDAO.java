/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.dao;

import br.com.stockmaster.stockmasterdb.classes.Customer;
import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
    
    public Customer getById(int id) {
        return JPAUtil.find(Customer.class, id);
    }
    
    public Customer getByDoc(String document){
        EntityManager em = JPAUtil.getEntityManager();
        try{
        return em.createQuery("SELECT c FROM Customer c WHERE c.document = : document", Customer.class)
                .setParameter("document", document)
                .getSingleResult();
        }catch(NoResultException e){
        return null;
        }finally{
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
    
    public void update(Customer c,String name, String document, String address, String number, String email, String notes){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            c.setName(name);
            c.setDocument(document);
            c.setAddress(address);
            c.setNumber(number);
            c.setEmail(email);
            c.setNotes(notes);
            em.merge(c);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
}
