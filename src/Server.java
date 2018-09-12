import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    //set up variables
    private Nodes node;
    private Thread t = null;

    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    Server (Nodes node) {
        this.node = node;
    }

    public void start () {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }

    // constructor with port
    public void run() {
        int port = this.node.getPortNumber();
        // starts server and waits for a connection
        try {
            Process proc = Runtime.getRuntime().exec("cmd /c start cmd.exe");

            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);

                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}