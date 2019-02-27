import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Echo extends Remote {
    String echo() throws RemoteException;
}
