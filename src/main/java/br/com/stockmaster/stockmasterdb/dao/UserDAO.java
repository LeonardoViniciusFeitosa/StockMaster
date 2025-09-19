/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.dao;

import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import br.com.stockmaster.stockmasterdb.classes.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author leona
 */


public class UserDAO {
    private static User activeUser;
    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }
    
    public static void setActiveUser(User user){
    activeUser = user;
    }
    
    public static User getActiveUser(){
    return activeUser;
    }
    
    public static User findByUsername(String username){
    EntityManager em = JPAUtil.getEntityManager();
    
    try{
    TypedQuery<User> query = em.createQuery("Select u FROM User u WHERE u.username = :username", User.class);
    query.setParameter("username", username);
    
    // Pega a lista de resultados
    var results = query.getResultList();
    
    // Retorna o primeiro ou null
    if (results.isEmpty()) {
    return null;
    } else{
    return results.get(0);
    }
    } finally {
    em.close();
    }
    }
}
