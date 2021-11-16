package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSender implements Runnable {
    private DataOutputStream dos;
    private final Scanner scanner = new Scanner(System.in);
    private final Socket socket;


    public ClientSender(Socket socket, DataOutputStream dos) {
        this.socket = socket;
        this.dos = dos;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                synchronized (this) {
                    String msg = scanner.nextLine();
                    dos.writeUTF(msg);
                    if (msg.equals("/exit")) {
                        socket.close();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
