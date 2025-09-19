package br.com.stockmaster.stockmasterdb.dao;

import br.com.stockmaster.stockmasterdb.classes.Product;
import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductDAO {
    
    public void delete(int id){
    EntityManager em = JPAUtil.getEntityManager();
    try{
    em.getTransaction().begin();
    Product product = em.find(Product.class, id);
    
    if (product != null){
    em.remove(product);
    }
    
    em.getTransaction().commit();
    } finally{
    em.close();
    }
    }

    public void save(Product product) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(Product product) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Product findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public List<Product> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Product p", Product.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}
