package sockets;

import java.util.Scanner;

/**
 * Created by imesha on 6/3/16.
 */
public class CLIApp {
    public static void main(String[] args) {
        Client client = Client.getInstance();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the message :");
            String msg = scanner.nextLine();
            if (msg.equals("-1")) {
                break;
            }
            client.sendMessage(msg);
            System.out.println(client.readMessage());
        }
    }
}
