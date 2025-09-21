/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.dao;

import br.com.stockmaster.stockmasterdb.classes.Employer;
import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;

/**
 *
 * @author leona
 */
public class EmployerDAO {
    public void delete(int id){
    EntityManager em = JPAUtil.getEntityManager();
    try{
    em.getTransaction().begin();
    Employer employer = em.find(Employer.class, id);
    
    if (employer != null){
    em.remove(employer);
    }
    
    em.getTransaction().commit();
    } finally{
    em.close();
    }
    }

    public void save(Employer employer) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employer);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(Employer e, String name, String doc, String address, String number, String email, String role) {
         EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            e.setAddress(address);
            e.setEmail(email);
            e.setName(name);
            e.setNumber(number);
            e.setPersonalId(doc);
            e.setRole(role);
            em.merge(e);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Employer findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Employer.class, id);
        } finally {
            em.close();
        }
    }
    
    public Employer findByDoc(String personalId) {
        EntityManager em = JPAUtil.getEntityManager();
        try{
        return (Employer) em.createQuery("SELECT e FROM Employer e WHERE e.personalId = :personalId")
                .setParameter("personalId", personalId).getSingleResult();
        }catch(NoResultException e){
        return null;
        }finally{
        em.close();
        }
    }

    public List<Employer> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Employer p", Employer.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}
