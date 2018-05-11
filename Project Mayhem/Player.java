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
import javax.swing.JTextPane;
import javax.swing.JOptionPane;


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
  String message = "Hello! Welcome to Project Mayhem, your Chapman Student fightclub.\n"
      + "We pit two players against each other. Each player starts with 100 health\n"
      + "and the fight ends when one of your health bars reaches zero.\n\n"
      + "On your right hand side are a list of fighting moves!\n"
      + "You have two basic attacks. Basic Attack 1 does 5 damage + a random amount of damage\n"
      + "between 1 and 10. Basic attack 2 does a random amount of damage between 1 and 25.\n"
      + "You also have two special moves called move 3 and move 4.\n"
      + "Those special moves are college specific! \n\n"
      + "On your left hand side, you will see a list of five colleges to choose from. \n"
      + "Each college's special skills have different effects. These effects are:\n\n"
      + "Argyros - Analyze trend: Deal 25 damage + an amount between 1 and 15.\n"
      + "Argyros - Seal the Deal: Deal 30 damage + an amount between 1 and 5.\n"
      + "COPA - Musical Enchantment: Heal for 5 + an amount between 1 and 10. Also deal 1-15 damage.\n"
      + "COPA - Power Drums: Deal 5 damage + an amount between 1 and 50. Also heal for 10.\n"
      + "Crean - Psycho-Analysis: Deal 20 damage + an amount between 1 and 15.\n"
      + "Crean - Therapy Session: Heal for 20 + an amount between 1 and 30.\n"
      + "Dodge - Script Change: deal 20 damage.\n"
      + "Dodge - Action!: Deal 10 damage + an amount between 1 and 30.\n"
      + "Schmid - Caffeine Bender: Heal for 5 + an amount between 1 and 15.\n"
      + "Schmid - DDOS Attack: You have a 50-50 chance of dealing 20 damage or healing the enemy for 20 damage!\n\n"
      + "Select wisely! Hint: COPA is the overpowered pick (until you graduate)\n"
      + "\nLook at your console/terminal to see messages from the server. You will be notified\n"
      + "when it is your turn. You will see live updates of your and your opponent's health.\n"
      + "You will also be notified of when one player wins and the other loses!"; //used in constructor
JOptionPane.showMessageDialog(null, message, "Instructions", JOptionPane.INFORMATION_MESSAGE);
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
