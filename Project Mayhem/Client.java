import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

import java.util.Scanner;

public class Client
{
  public static void main(String[] args)
  {
    try
    {
      String hostname = "localhost";
      int port = 7654;
      Player player = new Player();

      System.out.println("Connecting to server on port " + port);
      Socket connectionSock = new Socket(hostname, port);
      DataOutputStream serverOutput = new DataOutputStream(connectionSock.getOutputStream());
      System.out.println("Connection made.");
      ClientListener listener = new ClientListener(connectionSock, player);
      Thread theThread = new Thread(listener);
      theThread.start();
      Scanner keyboard = new Scanner(System.in);
      while (true)
      {
        String data = keyboard.nextLine();
        serverOutput.writeBytes(data + "\n");
      }
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
  }
}
