package chat.server;

import java.io.DataInputStream;
import java.io.IOException;

public class ServerReceiver implements Runnable {
    private String msg;
    private DataInputStream dis;
    private int clientNumber;

    public ServerReceiver(DataInputStream dis, int clientCounter) {
        this.dis = dis;
        this.clientNumber = clientCounter;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    msg = dis.readUTF();
                    if (msg.equals("/exit")) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                    System.out.printf("Client %d sent: %s\n", clientNumber, msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
