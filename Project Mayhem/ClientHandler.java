import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

import java.util.ArrayList;
import java.util.Scanner;


public class ClientHandler implements Runnable
{
  private Socket connectionSock = null;
  private ArrayList<Socket> socketList;

  ClientHandler(Socket sock, ArrayList<Socket> socketList)
  {
    this.connectionSock = sock;
    this.socketList = socketList;
  }

  //received input from a client
  public void run()
    {
    try
    {
      System.out.println("Connection made with socket " + connectionSock);
      BufferedReader clientInput = new BufferedReader(
          new InputStreamReader(connectionSock.getInputStream()));
      while (true)
      {
        // Get data sent from a client
        String clientText = clientInput.readLine();
        if (clientText != null)
        {
          System.out.println("Received: " + clientText);
          for (Socket s : socketList)
          {
            if (s != connectionSock)
            {
              DataOutputStream clientOutput = new DataOutputStream(s.getOutputStream());
              clientOutput.writeBytes(clientText + "\n");
            }
          }
        }
        else
        {
          System.out.println("Closing connection for socket " + connectionSock);
          socketList.remove(connectionSock);
          connectionSock.close();
          break;
        }
      }
    }
    catch (Exception e)
    {
      System.out.println("Error: " + e.toString());
      socketList.remove(connectionSock);
    }
  }
}
