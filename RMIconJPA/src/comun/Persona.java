
package comun;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Santiago
 */
public interface Persona extends Remote{
    
    public DatosCliente ObtenerDatosImpl(int numeroCedula) throws RemoteException;


}