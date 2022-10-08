package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {


    static final int port = 4562;

    public static void main(String[] args) throws IOException {

    //********************** SENDING ***********************

        // get the address off destination host
        InetAddress address;
        try {
            address = InetAddress.getByName("rainbow.essi.fr");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        String strMessage = "mon message";
        int msgLength = strMessage.length();
        byte[] message = new byte[msgLength];

        DatagramPacket packet = new DatagramPacket(message, msgLength, address, port);

        DatagramSocket socket = new DatagramSocket();
        //socket.send(packet);

        System.out.println(address);


// ************************* RECEIVE *********************************

        byte[] rcvBuffer = new byte[1024];

        DatagramPacket rcvPacket = new DatagramPacket(rcvBuffer, rcvBuffer.length);

        // receiving Socket

        DatagramSocket recvSocket = new DatagramSocket();

        while (true) {
            //wait for packet
            recvSocket.receive(rcvPacket);
            String rcvMessage = new String(rcvBuffer, 0, 0, rcvBuffer.length);
        }
    }


}
