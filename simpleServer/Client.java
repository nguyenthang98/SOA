import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String ("127.0.0.1");

        if (args.length > 0)
            serverHostname = args[0];

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 6969);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Error create socket");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("I/O error");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.print ("input numbers: ");
        while ((userInput = stdIn.readLine()) != null) {
            if(userInput.equals("Quit")) {
                break;
            }
            out.println(userInput);
            System.out.println("Server said: " + in.readLine());
            System.out.print ("input numbers: ");
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
