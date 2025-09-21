package br.com.stockmaster.stockmasterdb.dao;

import br.com.stockmaster.stockmasterdb.classes.Supplier;
import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;

public class SupplierDAO {
    
    public void delete(int id){
        EntityManager em = JPAUtil.getEntityManager();
    try{
        Supplier s = em.find(Supplier.class, id);
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
    }finally{
        em.close();
    }
    }
    
    public void save(Supplier s){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Supplier findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Supplier.class, id);
        } finally {
            em.close();
        }
    }
    public Supplier findByTaxId(String taxId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("select s from Supplier s where s.taxId = :taxId", Supplier.class)
                    .setParameter("taxId", taxId)
                    .getSingleResult();
        } catch(NoResultException e){
            return null;
        }finally {
            em.close();
        }
    }

    public List<Supplier> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Supplier s", Supplier.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }
    public void update(Supplier s){
        EntityManager em = JPAUtil.getEntityManager();
        try{
    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();
    }finally{
em.close();
}
    }
}
