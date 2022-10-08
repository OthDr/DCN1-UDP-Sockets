package UdpClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Client {


    static final int PORT = 4562;

    public static void main(String[] args) throws IOException {


        //********************** SENDING ***********************

        // get the address off destination host
        InetAddress address;
        try {
            //address = InetAddress.getByName("rainbow.essi.fr");
            address = InetAddress.getByName("localhost"); //for 127.0.0.1 IP
            System.out.println(address);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        String strMessage = "mon message";
        int msgLength = strMessage.length();
        byte[] message = new byte[msgLength];
        System.out.println(message[1]);

        DatagramSocket clientSocket = new DatagramSocket();

        DatagramPacket packet = new DatagramPacket(message, msgLength, address, PORT);

        clientSocket.send(packet);

        System.out.println(address + " port=" + packet.getPort());


// ************************* RECEIVE *********************************

        byte[] rcvBuffer = new byte[1024];

        DatagramPacket rcvPacket = new DatagramPacket(rcvBuffer, rcvBuffer.length);

        // receiving Socket


        while (true) {
            //scan from keyboard
            // ... scanner here
            //send scanned message to the server
            //wait for packet
            clientSocket.receive(rcvPacket);
            String rcvMessage = new String(rcvBuffer, rcvBuffer.length);
        }
    }


}
