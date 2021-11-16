package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final String ADDRESS = "127.0.0.1";
    private final int PORT = 44447;

    public static void main(String[] args) {
        new Server().start();
    }

    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                ServerReceiver receiver = new ServerReceiver(dis);
                ServerSender sender = new ServerSender(dos);
                ExecutorService executorService = Executors.newCachedThreadPool();

                executorService.submit(sender);
                executorService.submit(receiver);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
