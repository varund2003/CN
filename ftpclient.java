import java.io.*;
import java.net.*;

public class ftpclient {
 public static final int PORT = 4212;
    public static final int MAX = 60;


    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("\nEnter the file name:");
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String fileName = userInput.readLine();

            out.println(fileName);

            String receivedLine;
            while ((receivedLine = in.readLine()) != null) {
                System.out.println(receivedLine);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
