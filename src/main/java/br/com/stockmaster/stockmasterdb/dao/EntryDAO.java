/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.dao;

import br.com.stockmaster.stockmasterdb.classes.Product;
import br.com.stockmaster.stockmasterdb.classes.StockEntry;
import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author leona
 */
public class EntryDAO {
    EntityManager em = JPAUtil.getEntityManager();
    
    public void delete(int id){
    try{
    em.getTransaction().begin();
    StockEntry entry = em.find(StockEntry.class, id);
    
    if (entry != null){
    em.remove(entry);
    }
    
    em.getTransaction().commit();
    } finally{
    em.close();
    }
    }

    public void save(StockEntry entry) {
        JPAUtil.save(entry);
        Product p = JPAUtil.find(Product.class, entry.getProduct().getId());
        p.setQuantity(p.getQuantity() + entry.getQuantity());
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    public void update(StockEntry entry) {
         EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entry);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public StockEntry findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(StockEntry.class, id);
        } finally {
            em.close();
        }
    }

    public List<StockEntry> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM StockEntry p", StockEntry.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}
