import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookInterface extends Remote {
    Book getBook(int id) throws RemoteException;
    boolean insertBook(Book newBook) throws RemoteException;
}
