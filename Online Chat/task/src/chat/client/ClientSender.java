package chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClientSender implements Runnable {
    private DataOutputStream dos;
    private final Scanner scanner = new Scanner(System.in);

    public ClientSender(DataOutputStream dos) {
        this.dos = dos;
    }

    @Override
    public void run() {
        while (true) {
         //   for (int i = 0; i < 1; i++) {
                try {
                    synchronized (this) {
                        String msg = scanner.nextLine();
                        dos.writeUTF(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        //    }
        }
    }
}
