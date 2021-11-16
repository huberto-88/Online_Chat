package chat.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private final String ADDRESS = "127.0.0.1";
    private final int PORT = 44447;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket socket;
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        new Client().run();
    }

    private void run() {
        try {
            socket = new Socket(ADDRESS, PORT);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client started!");

        ClientSender sender = new ClientSender(dos);
        ClientReceiver receiver = new ClientReceiver(dis);
        executorService.submit(sender);
        executorService.submit(receiver);
    }
}
