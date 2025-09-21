/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.dao;

import br.com.stockmaster.stockmasterdb.classes.Product;
import br.com.stockmaster.stockmasterdb.classes.Sale;
import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author leona
 */
public class salesDAO {
    EntityManager em = JPAUtil.getEntityManager();
    public void save(Sale s){
    JPAUtil.save(s);
    em.getTransaction().begin();
    Product p = JPAUtil.find(Product.class, s.getProduct().getId());
    p.setQuantity(p.getQuantity() - s.getQuantity());
    em.merge(p);
    em.getTransaction().commit();
    em.close();
    }
}
