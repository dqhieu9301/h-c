
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.net.ServerSocket;

public class Server {

    public static void main(String argv[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(3333);
        Socket socket = serverSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String result = dataInputStream.readUTF();
            if (result.equals("quit")) {
                break;
            }
            System.out.println("client: " + result);

            // String message = scanner.nextLine();
            // System.out.println("server: " + message);
            // dataOutputStream.writeUTF(message);
            // dataOutputStream.flush();
        }
        serverSocket.close();
        dataInputStream.close();
        dataOutputStream.close();
        scanner.close();
    }
}