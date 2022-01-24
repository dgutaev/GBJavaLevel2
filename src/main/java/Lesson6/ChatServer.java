package Lesson6;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class ChatServer {
    public static void main(String[] args) {
        new ChatServer().start();
    }

    private void start() {
        Socket socket = null;
        try(ServerSocket serverSocket = new ServerSocket(8100)){

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
