package Lesson6;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8189);
            final Scanner in = new Scanner(socket.getInputStream());
            final PrintStream out = new PrintStream(socket.getOutputStream());
            final Scanner console = new Scanner(System.in);
            Thread inThread = new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.nextLine();
                        if ("/end".equals(msg)) {
                            break;
                        }
                        System.out.println("Пришло сообщение: " + msg);
                    }
                } catch (Exception e) {
                }
            });
            inThread.start();

            Thread outThread = new Thread(() -> {
                try {
                    while (true) {
                        String msg = console.nextLine();
                        out.println(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            outThread.start();
            try {
                inThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
