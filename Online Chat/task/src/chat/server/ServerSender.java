package chat.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ServerSender implements Runnable {
    private String msg;
    private final Scanner scanner = new Scanner(System.in);
    private DataOutputStream dos;

    public ServerSender(DataOutputStream dos) {
        this.dos = dos;
    }

    @Override
    public void run() {
        while (true) {
                synchronized (this) {
                    msg = scanner.nextLine();
                    try {
                        dos.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}
