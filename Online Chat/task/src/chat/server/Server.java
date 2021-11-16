package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final String ADDRESS = "127.0.0.1";
    private final int PORT = 44447;

    public static void main(String[] args) {
        new Server().start();
    }

    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started!");
            int clientCounter = 0;
            while (true) {
                Socket socket = serverSocket.accept();
                if (socket.isConnected()){
                    clientCounter++;
                    System.out.printf("Client %d connected!\n", clientCounter);
                }
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                ReceiverSender receiverSender = new ReceiverSender(socket, dos, dis, clientCounter);
                Thread thread = new Thread(receiverSender);
                thread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
