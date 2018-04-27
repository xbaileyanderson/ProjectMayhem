/**
 * ClientHandler.java
 *
 * This class handles communication between the client
 * and the server.  It runs in a separate thread but has a
 * link to a common list of sockets to handle broadcast.
 *
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class ClientHandler implements Runnable{
  private Socket connectionSock = null;
  private ArrayList<Socket> socketList;



  Socket player1;
  Socket player2;
  private BufferedReader player1Input;
  private DataOutputStream player1Output;
  private BufferedReader player2Input;
  private DataOutputStream player2Output;
  int Health1 = 100;
  int Health2 = 100;


  ClientHandler(Socket sock, ArrayList<Socket> socketList)
  {
    this.connectionSock = sock;
    this.socketList = socketList;
  }

  //method that creates player 1
  //need to get click data from gui character select screen
  //Player Player1 = new Player(Name, catchphrase, college)

  //method that creates player 2
  //need to get click data from gui character select screen
  //Player Player2 = new Player(Name, catchphrase, college)


  //each college will have a number corresponding to it (collegeClass)
  private void move(int moveNum, int collegeClass)
  {
    switch (moveNum)
    {
      case 1: //method with logic for move1

        break;
      case 2: // method with logic for move2
        break;
      case 3: switch (collegeClass)
      {
        case 1: // method for schmid move3
          break;
        case 2: //method for copa move3
          break;
        //etc etc repeat for move 4 as well
      }
    }
  }

  //logic for moves

  /*public void move1()
    {
      Random rand = new Random();
      int damage = 10 + rand.nextInt(10);
      return damage;
    }

  public void move2()
    {
      Random rand = new Random();
      int damage = rand.nextInt(25);
      return damage;
    }*/

  public void move3Schmid(){

  }

  public void move4Schmid(){

  }

  //etc etc for all moves

  private void clientTurn(Socket client, BufferedReader clientIn, DataOutputStream clientOut) {
    //method that determines what happens each turn (win/lose etc.)
  }



  public void run() {
    boolean playing = true;
    try {

      player1 = socketList.get(0);
      System.out.println("Player1 connected");

      //Player1's user
      try {
        player1Input = new BufferedReader(
                new InputStreamReader(player1.getInputStream()));
        player1Output = new DataOutputStream(player1.getOutputStream());
        player1Output.writeBytes("Welcome to Project Mayhem. You are the first to connect\n"
                + "Waiting for other player to connect...\n");

        //Player2's user
        while (true) {
          if (socketList.size() == 2) {
            //Init second user and send beginning message
            Socket player2 = socketList.get(1);

            player2Input = new BufferedReader(
                    new InputStreamReader(player2.getInputStream()));
            player2Output = new DataOutputStream(player2.getOutputStream());
            player2Output.writeBytes("Welcome to Project Mayhem. You are the second to connect\n");
            System.out.println("Client 2 connected");
            break;
          }
        }
        //Play the game
        System.out.println("*Beginning Game*");
        while (true) {
          if (!playing)
            break;
          clientTurn(player1, player1Input, player1Output);
          if (!playing)
            break;
          clientTurn(player2, player2Input, player2Output);
        }
      } catch (Exception e) {

      }
    }
    catch(Exception e){
    }
  }
} // ClientHandler for MtServer.java
