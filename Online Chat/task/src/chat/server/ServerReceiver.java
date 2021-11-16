package chat.server;

import java.io.DataInputStream;
import java.io.IOException;

public class ServerReceiver implements Runnable {
    private String msg;
    private DataInputStream dis;

    public ServerReceiver(DataInputStream dis) {
        this.dis = dis;
    }

    public void run() {
        try {
            while (true) {
            //    for (int i = 0; i < 2; i++) {
                    synchronized (this) {
                        msg = dis.readUTF();
                        System.out.println(msg);
                    }
                }
       //     }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
