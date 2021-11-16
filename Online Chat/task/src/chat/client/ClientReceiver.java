package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceiver implements Runnable {
    private DataInputStream dis;
    private Socket socket;

    public ClientReceiver(Socket socket, DataInputStream dis) {
        this.socket = socket;
        this.dis = dis;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            String receivedMsg;
            try {
                receivedMsg = dis.readUTF();
                System.out.println(receivedMsg);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}