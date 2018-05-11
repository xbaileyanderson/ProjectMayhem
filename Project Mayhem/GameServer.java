
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;

public class GameServer {
  // Maintain list of all client sockets for broadcast
  private ArrayList<Socket> socketList;

  public GameServer() {
    socketList = new ArrayList<Socket>();
  }

  private void getConnection() {
    // Wait for a connection from the client
    try {
      System.out.println("Waiting for client connections on port 7654.");
      ServerSocket serverSock = new ServerSocket(7654);
      // This is an infinite loop, the user will have to shut it down
      // using control-c
      while (true) {
        Thread.yield();
        Socket connectionSock = serverSock.accept();
        Thread.yield();
        // Add this socket to the list
        if(connectionSock != null){
          socketList.add(connectionSock);
          // Send to ClientHandler the socket and arraylist of all sockets
          ClientHandler handler = new ClientHandler(this.socketList);
          Thread.yield();
          Thread theThread = new Thread(handler);
          theThread.start();
          Thread.yield();
          System.out.println("Conn Thread 1 Started");
          try{
            theThread.wait(1000);
          }
          catch(Exception e){
            System.out.println(e.getMessage());
          }
          break;
        }
      }

      while(true) {
        Thread.yield();
        Socket connectionSock = serverSock.accept();
        Thread.yield();
        // Add this socket to the list
        if(connectionSock != null){
          socketList.add(connectionSock);
          // Send to ClientHandler the socket and arraylist of all sockets
          ClientHandler handler = new ClientHandler(this.socketList);
          Thread.yield();
          Thread theThread = new Thread(handler);
          theThread.start();
          Thread.yield();
          System.out.println("Conn Thread 2 Started");
          try{
            theThread.wait(1000);
          }
          catch(Exception e){
            System.out.println(e.getMessage());
          }
          break;
        }
      }

      // Will never get here, but if the above loop is given
      // an exit condition then we'll go ahead and close the socket
      serverSock.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    GameServer server = new GameServer();
    server.getConnection();
  }
}
