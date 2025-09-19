/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.com.stockmaster.stockmasterdb.util;

import br.com.stockmaster.stockmasterdb.classes.Customer;
import br.com.stockmaster.stockmasterdb.util.HashUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author leona
 */
public class JPAUtil {
private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("stockmaster");

public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

// Método genérico para buscar qualquer entidade por ID
public static <T> T find(Class<T> clazz, Object id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(clazz, id);
        } finally {
            em.close();
        }
    }

// Método genérico para salvar qualquer entidade
    public static <T> void save(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void closeFactory() {
    if (emf.isOpen()) {
        emf.close();
    }
}
}