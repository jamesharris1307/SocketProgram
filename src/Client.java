// Imports
import java.io.*;
import java.net.*;

// Client Class
public class Client {
    // Initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // Constructor to put ip address and port
    public Client(String address, int port)
    {
        // Establish Connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // Takes input from terminal
            input = new DataInputStream(System.in);

            // Sends output to the socket
            out = new DataOutputStream(
                    socket.getOutputStream());
        }
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }

        // String to read message from input
        String line = "";

        // Keep reading until "Over" is input
        while (!line.equals("Over")) {
        try {
            line = input.readLine();
            out.writeUTF(line);
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }

    // Close the connection
        try {
            input.close();
            out.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 5000);
    }
}

// Testing changes to client class
