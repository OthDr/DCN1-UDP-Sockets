# DCN1-UDP-Sockets
**UDP Protocol based communication JAVA**
### 1. DatagramPacket
   *In UDP’s terms, data transferred is encapsulated in a unit called datagram. A datagram is an independent, self-contained message sent over the network*.
   <br>
### 2. DatagramSocket
   You use DatagramSocket to send and receive DatagramPackets. DatagramSocket represents a UDP connection between two computers in a network.
   
#### The key methods of the DatagramSocket include:
   - `send(DatagramPacket p)`: sends a datagram packet.
   - `receive(DatagramPacket p)`: receives a datagram packet.
   - `setSoTimeout(int timeout)`: sets timeout in milliseconds, limiting the waiting time when receiving data. If the timeout expires, a SocketTimeoutException is raised.
   - `close()`: closes the socket.