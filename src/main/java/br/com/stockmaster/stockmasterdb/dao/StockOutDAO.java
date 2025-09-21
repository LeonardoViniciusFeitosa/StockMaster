/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.dao;

import br.com.stockmaster.stockmasterdb.classes.StockOut;
import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author leona
 */
public class StockOutDAO {
    public void save(StockOut out){
    JPAUtil.save(out);
    }
    
    public void delete(int id){
    EntityManager em = JPAUtil.getEntityManager();
    try{
    em.getTransaction().begin();
    StockOut out = em.find(StockOut.class, id);
    
    if (out != null){
    em.remove(out);
    }
    
    em.getTransaction().commit();
    } finally{
    em.close();
    }
    }
}
