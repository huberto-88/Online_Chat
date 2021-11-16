package chat.client;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientReceiver implements Runnable {
    private DataInputStream dis;

    public ClientReceiver(DataInputStream dis) {
        this.dis = dis;
    }

    @Override
    public void run() {
        while (true) {
         //   for (int i = 0; i < 2; i++) {
                String receivedMsg;
                try {
                    synchronized (this) {
                        receivedMsg = dis.readUTF();
                        System.out.println(receivedMsg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        //    }
        }
    }
}