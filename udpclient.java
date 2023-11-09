import java.io.*;
import java.net.*;

public class udpclient {
    public sde
        public int hashCode() {
            return Objects.hash(address, port);
        }
    }
} void main(String[] args) {
        final String serverHost = "192.168.109.35";
        final int serverPort = 12000;

        try {
            DatagramSocket socket = new DatagramSocket();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String clientName = reader.readLine();

            Thread receiveThread = new Thread(() -> {
                try {
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                    while (true) {
                        socket.receive(receivePacket);
                        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            receiveThread.start();


            while (true) {
                System.out.print("Enter your message: ");
                String message = reader.readLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                String combinedMessage = clientName + ": " + message;
                byte[] sendData = combinedMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        InetAddress.getByName(serverHost), serverPort);
  }

            receiveThread.interrupt();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
