// Imports
import java.net.*;
import java.io.*;

public class Server
{
    // Initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // Variables
    String serverSide = ("Server: ");

    // Constructor with port
    public Server(int port)
    {
        // Starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println(serverSide + "Server started");

            System.out.println(serverSide + "Waiting For Client Program to be Launched");

            socket = server.accept();
            System.out.println(serverSide + "Client Program Launched and accepted");

            // Takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // Reads message from client until "Over" is sent
            while (!line.equals("Terminate"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println(serverSide + "Connection Terminated");

            // Close Connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}

// Testing changes to Server class
// Testing the new Branch Created
