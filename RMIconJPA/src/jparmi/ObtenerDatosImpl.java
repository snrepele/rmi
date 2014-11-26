/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jparmi;

import comun.DatosCliente;
import comun.Persona;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import servidorEntidades.Personas;

/**
 *
 * @author Santiago
 */
public  class ObtenerDatosImpl extends UnicastRemoteObject implements Persona{
    
     public DatosCliente ObtenerDatosImpl(int busCed) throws RemoteException{
    
            EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPARMIPU");
            EntityManager em=emf.createEntityManager();

            PersonasJpaController persona = new PersonasJpaController(emf);
            Personas p=new Personas();
            p= persona.findPersonas(busCed);
            
            
            return new DatosCliente(p.getNombre(),p.getApellido(),p.getEmail());
            
            }

    public ObtenerDatosImpl() throws RemoteException{
        
     
    }

   

    
     
     
}

    
