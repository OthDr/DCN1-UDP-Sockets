package UdpServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    static final int PORT = 4562;
    
    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(PORT);
        byte[] rcvData = new byte[1024];
        byte[] sendData = new byte[1024];
        System.out.println("Server listening on port: "+PORT);

        while (true) {
            DatagramPacket rcvPacket = new DatagramPacket(rcvData, rcvData.length);
            serverSocket.receive(rcvPacket);
            String rcvMessage = new String(rcvPacket.getData());
            System.out.println("client: " + rcvMessage);
            InetAddress IPAddress = rcvPacket.getAddress();
            int port = rcvPacket.getPort();
            /*String capitalizedSentence = message.toUpperCase();
            sendData = capitalizedSentence.getBytes();*/
            String echoMessage = " echo=> "+rcvMessage;
            sendData = echoMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);

            if(rcvMessage.contains("bye")){
                String bye = "bye";
                serverSocket.send(new DatagramPacket(bye.getBytes(), bye.getBytes().length, IPAddress, port));
                serverSocket.close();
            }
            sendData = null;
            rcvPacket = null;
            sendPacket = null;
        }
    }
}
