package sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Created by imesha on 6/3/16.
 */
public class Client {
    private String HOST = "192.168.43.213";
    private int PORT = 8080;
    private Socket socket;

    private static Client client;

    private Client() {
        try {
            this.socket = new Socket(HOST, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client getInstance() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public void sendMessage(String message) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readMessage() {
        String message = "";
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1000];
            while (inputStream.available() > 0) {
                inputStream.read(bytes);
            }
            message = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

}
