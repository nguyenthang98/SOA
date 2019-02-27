import java.rmi.registry.*;

public class Client {
    private Client() {};

    public static void main(String[] args) {
        try {
            Registry rgt = LocateRegistry.getRegistry();
            Echo stub = (Echo)rgt.lookup("Echo");
            System.out.println("Looking up ... Done");
            String res = stub.echo();
            System.out.println("RES: " + res);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
