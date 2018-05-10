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
  int health1;
  int health2;


  ClientHandler(ArrayList<Socket> socketList)
  {
    //this.connectionSock = sock;
    this.socketList = socketList;
    health1 = 100;
    health2 = 100;
  }

  //method that creates player 1
  //need to get click data from gui character select screen
  //Player Player1 = new Player(Name, catchphrase, college)

  //method that creates player 2
  //need to get click data from gui character select screen
  //Player Player2 = new Player(Name, catchphrase, college)


  //each college will have a number corresponding to it (collegeClass)
  //int player to determine which player (1 or 2)
    public Move move(int moveNum) {
    int d = 0;
    int h = 0;
    boolean s = false;
    Move m = new Move(0,0,false);


    //
    // can simplify switch to be like: move4schmid is moveNum = 8 and just have one switch statement
    // instead of having to have "int collegeClass" as a parameter
    //
switch (moveNum)
    {
      case 1: //method with logic for move1
        m = move1();
        break;
      case 2: // method with logic for move2
        m = move2();
        break;
      case 3:
        m = move3Schmid();
        break;
      case 4:
        m = move3COPA();
        break;
      case 5:
        m = move3Dodge();
        break;
      case 6:
        m = move3Crean();
        break;
      case 7:
        m = move3Argyros();
        break;
      case 8:
        m = move4Schmid();
        break;
      case 9:
        m = move4COPA();
        break;
      case 10:
        m = move4Dodge();
        break;
      case 11:
        m = move4Crean();
        break;
      case 12:
        m = move4Argyros();
        break;
    }
  return m;
}

  //logic for moves

  public Move move1()
    {
      Move m = new Move(0,0,false);
      Random rand = new Random();
      int damage = 5 + rand.nextInt(10);
      m.damage = damage;
      return m;
    }

  public Move move2()
    {
      Move m = new Move(0,0,false);
      Random rand = new Random();
      int damage = rand.nextInt(25);
      m.damage = damage;
      return m;
    }

    //heals base 5 plus rand 15
    public Move move3Schmid()
    {
    Move m = new Move(0, 0, false);
    Random rand = new Random();
    int healthSave = 5;
    int addsHealth = healthSave + rand.nextInt(15);
    m.heal = addsHealth;
    System.out.println("this is schmid");
    return m;
    }

  //name: script change (heal + attack)
  public Move move3Dodge()
  {
    Move m = new Move(0, 0, false);
    int damage = 20;
    m.damage = damage;
    return m;
  }

  //Psycho-analysis. "Poke at enemy's insecurities"
  //
  public Move move3Crean()
  {
    Move m = new Move(0, 0, false);
    Random rand = new Random();
    int baseDamage = 20;
    int damage = baseDamage+rand.nextInt(15);
    m.damage = damage;
    return m;
  }

  //Analyze trend: "Enemy is spending too little on defense"
  public Move move3Argyros()
  {
    Move m = new Move(0, 0, false);
    Random rand = new Random();
    int baseDamage = 25;
    int damage = baseDamage+rand.nextInt(15);
    m.damage = damage;
    return m;
  }

  //Musical Enchantment - heals base of 5 plus rand 10 and attacks w random 15
  public Move move3COPA()
  {
  Move m = new Move(0, 0, false);
  Random rand = new Random();
  int healthSave = 5;
  int damage = rand.nextInt(15);
  int addsHealth = healthSave + rand.nextInt(10);
  m.heal = addsHealth;
  m.damage = damage;
  return m;
  }


  public Move move4Schmid() {
    Move m = new Move(0,0,false);
    Random rand = new Random();
    int flip = rand.nextInt(1);
    int damage;
    if (flip == 0) {
      damage = 20;
    }
    else {
      damage = -20;
    }
    m.damage = damage;
    return m;
  }

  //name: That's a wrap (attack)
  public Move move4Dodge() {
    Move m = new Move(0,0,false);
    int damage;
    int dam;
    int base = 20;
    Random rand = new Random();
    dam = 10;
    base = rand.nextInt(30);
    damage = base + dam;
    return m;
  }

  //3 potential names
  //Therapeutic massage
  //Pep-talk
  //Therapy session
  public Move move4Crean() {
    Move m = new Move(0,0,false);
    Random rand = new Random();
    int baseHeal = 20;
    int healAmount = baseHeal+rand.nextInt(30);
    m.heal = healAmount;
    return m;
  }

  //Look for investors:
  //"Raising money to buy a new weapon"
  //"Raised just enough to do: " + damage
  public Move move4Argyros() {
    Move m = new Move(0,0,false);
    Random rand = new Random();
    int baseDamage = 20;
    int damage = baseDamage+rand.nextInt(50);
    m.damage = damage;
    return m;
  }

  //This move will eventually block the opponant's attack, for now as a place holder until we get the clienthandler
  //working I am making it an attack
  public Move move4COPA()
  {
    Move m = new Move(0,0,false);
    Random rand = new Random();
    int damage = 5 + rand.nextInt(50);
    int healing = 10;
    m.damage = damage;
    m.heal = healing;
    return m;
  }

  //etc etc for all moves


  private boolean CheckIfWin(int pNum) {
    if (pNum == 0) {
      if (health2 <= 0) {
        return true;
      }
    }
    else if (pNum == 1) {
      if (health1 <= 0) {
        return true;
      }
    }
    return false;
  }

  private void clientTurn(Socket client, BufferedReader clientIn, DataOutputStream clientOut, int moveNum, int collegeClass) {
    //method that determines what happens each turn (win/lose etc.)
    try {
      String play = "PLAY\n";
      clientOut.writeBytes(play);
      // send opponent health to player
      //
      // receive move selection from player
      //receive whether move is done by player 1 or player 2
      int playerNum = 0; //remove later
      String clientMove = clientIn.readLine();
      moveNum = Integer.parseInt(clientMove);
      if(client == socketList.get(0)) {
                 playerNum = 0;
               }
               else {
                 playerNum = 1;
               }

      int damage = 0;
      int heal = 0;
      Move m = move(moveNum);
      damage = m.damage;
      heal = m.heal;
      if (playerNum == 0){
        health2 = health2 - damage;
        health1 = health1 + heal;
        System.out.println("Player 1 health: " + health1);
        System.out.println("Player 2 health: " + health2);
      }
      else {
        health2 = health2 + heal;
        health1 = health1 - damage;
        System.out.println("Player 1 health: " + health1);
        System.out.println("Player 2 health: " + health2);
      }

      //check if win
      if (CheckIfWin(playerNum)) {
        if (playerNum == 0){
          player1Output.writeBytes("WIN\n");
          player2Output.writeBytes("LOSE\n");
          System.out.println("GAME OVER");
        }
        else if (playerNum == 1){
          player2Output.writeBytes("WIN\n");
          player1Output.writeBytes("LOSE\n");
          System.out.println("GAME OVER");
      }
    }
  }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

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
          clientTurn(player1, player1Input, player1Output, 0, 0);
          if (!playing)
            break;
          clientTurn(player2, player2Input, player2Output, 1, 1);
        }
      } catch (Exception e) {

      }
    }
    catch(Exception e){
    }
  }
} // ClientHandler for MtServer.java
