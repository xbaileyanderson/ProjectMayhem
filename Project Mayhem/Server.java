import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;

public class Server
{
  private ArrayList<Socket> socketList;
    
  public Server()
  {
    socketList = new ArrayList<Socket>();
  }

  private void getConnection()
  {
    try
    {
      System.out.println("Waiting for client connections on port 7654.");
      ServerSocket serverSock = new ServerSocket(7654);
      while (true)
      {
        Socket connectionSock = serverSock.accept();
        socketList.add(connectionSock);
        ClientHandler handler = new ClientHandler(connectionSock, this.socketList);
        Thread theThread = new Thread(handler);
        theThread.start();
      }
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args)
  {
    Server server = new Server();
    server.getConnection();
  }
}
