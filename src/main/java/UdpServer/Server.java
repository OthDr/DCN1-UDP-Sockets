package UdpServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    static final int PORT = 4562;

    public static void main(String[] args) throws IOException {

        DatagramSocket serverSocket = new DatagramSocket(PORT, InetAddress.getByName("localhost"));

        // ******* Receiving *******
        byte[] rcvBuffer = new byte[256];

        DatagramPacket rcvPacket = new DatagramPacket(rcvBuffer, rcvBuffer.length);

        // receiving Socket

        System.out.println("Server is listening on port" + PORT);

        InetAddress clientAddress = rcvPacket.getAddress();

        if (clientAddress != null) {
            System.out.println("A client has requested: IP=" + clientAddress);
        }

        while (true) {
            //wait for packet
            serverSocket.receive(rcvPacket);
            String rcvMessage = new String(rcvBuffer, rcvBuffer.length);
            System.out.println("client: " + rcvMessage);
            //serverSocket.send(new DatagramPacket(rcvMessage.getBytes(), rcvMessage.length()));


        }
    }
}
