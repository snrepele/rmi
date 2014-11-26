/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import comun.Persona;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Cliente {
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String host;
        
        //System.out.print("Nombre del Servidor");
        //host = lector.next();
        
        try {
            Registry registro=LocateRegistry.getRegistry("rmi://localhost:5099");
            Persona persona=(Persona)registro.lookup("persona");
            System.out.printf("Datos de la Persona %s \n "+ persona.ObtenerDatosImpl(1104331739).toString());
            
            
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
