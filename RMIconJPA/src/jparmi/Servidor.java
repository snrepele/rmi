
package jparmi;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

      public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        
            ObtenerDatosImpl r = new ObtenerDatosImpl();
            Registry registro = LocateRegistry.getRegistry(5099);
            registro.rebind("persona", r);
            System.out.println("Servidor listo");
             
}
      
}
