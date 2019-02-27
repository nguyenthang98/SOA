import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.RemoteException;

public class Server implements Echo {
    public Server() {}

    public String echo() throws RemoteException{
        return "Hello";
    }

    public static void main(String []args) {
        try {
            Server sv = new Server();

            Echo stub = (Echo)UnicastRemoteObject.exportObject(sv, 0);
            Registry rgt = LocateRegistry.getRegistry();

            rgt.bind("Echo", stub);

            System.out.println("Echo server is listening");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
