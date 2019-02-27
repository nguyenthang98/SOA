import java.net.*;
import java.io.*;
import java.util.Collections;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(6969);
        }
        catch (IOException e) {
            System.err.println("Error create server");
            System.exit(1);
        }

        Socket clientSocket = null;

        try {
            clientSocket = serverSocket.accept();
        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream()));

        String inputLine;

        ArrayList<Integer> nums = new ArrayList<Integer>();
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("Quit"))
                break;
            try {
                nums.add(Integer.parseInt(inputLine));
                if(nums.size() == 3) {
                    out.println(String.format("Max(%d, %d, %d): %d", nums.get(0), nums.get(1), nums.get(2), Collections.max(nums)));
                    nums.clear();
                } else {
                    out.println(inputLine);
                }
            } catch (NumberFormatException e) {
                out.println("Not a number");
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
