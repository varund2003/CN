import java.io.*;
import java.net.*;

public class ftpserver {
    public static final int PORT = 4212;
    public static final int MAX = 4096;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established with client");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String fileName = in.readLine();
                System.out.println("Received request for file: " + fileName);

                File file = new File(fileName);
                if (file.exists()) {
                    BufferedReader fileReader = new BufferedReader(new FileReader(file));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    String line;
                    while ((line = fileReader.readLine()) != null) {
                        out.println(line);
                         System.out.println(line);
                    }

                    fileReader.close();
                    out.close();
                    System.out.println("File sent successfully");
                } else {
                    System.out.println("File not found");
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
