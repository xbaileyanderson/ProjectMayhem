/**
 * MTClient.java
 *
 * This program implements a simple multithreaded chat client.  It connects to the
 * server (assumed to be localhost on port 7654) and starts two threads:
 * one for listening for data sent from the server, and another that waits
 * for the user to type something in that will be sent to the server.
 * Anything sent to the server is broadcast to all clients.
 *
 * The MTClient uses a ClientListener whose code is in a separate file.
 * The ClientListener runs in a separate thread, recieves messages form the server,
 * and displays them on the screen.
 *
 * Data received is sent to the output screen, so it is possible that as
 * a user is typing in information a message from the server will be
 * inserted.
 *
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;


public class Player {
  public static void main(String[] args) {
    Player p = new Player();
    p.startListener();

    GUI game = new GUI();
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
  });
}

  private String hostname;
  private int port;

  private DataOutputStream serverOutput;
  private Thread listenerThread;
  private Scanner keyboard;


  public Player(){
    hostname = "localhost";
    port = 7654;

    keyboard = new Scanner(System.in);
    initNetworking();
  }

  private void initNetworking(){
    try{
      //Connect & Create
      System.out.println("Creating connection objects...");

      Socket connectionSock = new Socket(hostname, port);

      serverOutput = new DataOutputStream(connectionSock.getOutputStream());
      listenerThread = new Thread(new ClientListener(connectionSock, this));

      System.out.println("*Client listener created*");
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public void startListener(){
    System.out.println("*Starting thread*");
    listenerThread.start();

    System.out.println("Connecting to server on port " + port + "...");
    Thread.yield();
    }


  public void play(){
    Scanner console = new Scanner(System.in);
    System.out.println("Make your move");
      try{
        TimeUnit.SECONDS.sleep(10);

        BufferedReader reader;
			  reader = new BufferedReader(new FileReader("Text.txt"));
			  String line = reader.readLine();

			  reader.close();

        //TimeUnit.SECONDS.sleep(10);
        //String data = console.readLine();
        ////gui input insted of keyboard input
        /*GUI g = new GUI();
        TimeUnit.SECONDS.sleep(1);
        int data = g.getMoveNum();
        System.out.println(data);
        while (data == 0){
          GUI p = new GUI();
          TimeUnit.SECONDS.sleep(1);
          data = p.moveNum;
          System.out.println(data);
        } */
        System.out.println(line);
        //String dString = Integer.toString(data);
      //  System.out.println(dString);
        serverOutput.writeBytes(line + "\n");
      }
      catch(Exception e){
        System.out.println(e.getMessage());
      }
  }

  //TODO: Add close methods
  public void success(){
    System.out.println("*Your was response was received by the server | your move was legitimate*");
    System.out.println("Now waiting for your opponents response...");
  }

  public void failure(){
    /*System.out.println("*Your response was received by the sever | your move was NOT legitimate*");
    System.out.println("PLEASE ENTER A LEGAL NUMBER BETWEEN 1-8");
    play(); */
  }

  public void finished(){
    System.out.println("*The other user disconnected, therefore you WIN (by default)*");
  }

  public void win(){
    System.out.println("YOU WON!");
  }

  public void lose(){
    System.out.println("*YOU LOST!*");
    System.out.println();
  }

  public void close(){
    try {
      System.out.println("Sending farewell msg to server...");
      serverOutput.write("GOODBYE".getBytes());

      listenerThread.join();
      System.out.println("*Thread Closed*");

      System.out.println("GOODBYE");
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}
