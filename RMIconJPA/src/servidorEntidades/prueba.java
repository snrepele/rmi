/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEntidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jparmi.PersonasJpaController;

/**
 *
 * @author Santiago
 */
public class prueba {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPARMIPU");
        EntityManager em=emf.createEntityManager();
        
        PersonasJpaController persona = new PersonasJpaController(emf);
        Personas p=new Personas();
        p= persona.findPersonas(1104331739);
        
        System.out.println("estos son los datos"+p.toString());
        
        //persona.setApellido("Penarreta");
        //persona.setEmail("email");
        
//        em.getTransaction().begin();
//        em.persist(persona);
//        
//        em.getTransaction().commit();
//                  
//        em.close();
//        emf.close();
    }
    
    
    
}
