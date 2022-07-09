
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String argv[]) throws Exception {
        Socket socket = new Socket("localhost", 3333);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            if (message.equals("quit")) {
                break;
            }
        }
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        scanner.close();
    }
}