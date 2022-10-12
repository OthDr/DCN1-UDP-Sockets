package UdpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    static final int PORT = 4562;
    public static void main(String[] args) throws IOException {
        BufferedReader scanBuffer = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] rcvData = new byte[1024];

        System.out.print(">>");

        while (true) {
            String scannerMessage = scanBuffer.readLine();
            sendData = scannerMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PORT);
            clientSocket.send(sendPacket);
            DatagramPacket rcvPacket = new DatagramPacket(rcvData, rcvData.length);
            clientSocket.receive(rcvPacket);
            String rcvMessage = new String(rcvPacket.getData());
            System.out.println("Server: " + rcvMessage);

            if (rcvMessage.contains("bye")) {
                clientSocket.close();
            }

            System.out.print(">>");
            sendData = null;
            rcvPacket = null;
            sendPacket = null;
        }

    }


}
