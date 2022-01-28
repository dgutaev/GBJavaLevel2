package Lesson6;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");

            socket = server.accept();
            System.out.println("Клиент подключился");

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
                }
            });
            outThread.setDaemon(true);
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}