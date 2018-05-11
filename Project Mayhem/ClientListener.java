
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

import java.util.ArrayList;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.PLAY;


public class ClientListener implements Runnable {
  private Socket connectionSock = null;
  private Player player = null;
  private boolean running;

  ClientListener(Socket sock, Player player) {
    this.connectionSock = sock;
    this.player = player;
    this.running = true;
  }

  public void run() {
    try {
      BufferedReader serverInput = new BufferedReader(
          new InputStreamReader(connectionSock.getInputStream()));
      while (running) {
        String serverText = serverInput.readLine();
        if (serverInput != null) {
          parseResponse(serverText);
        }
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.toString());
    }
  }

  private void parseResponse(String serverResponse){

    if(serverResponse.equals("PLAY")){  //Client turn
      player.play();
    }
    if(serverResponse.equals("WIN")){  //You win
      player.win();
      running = false;
    }
    if(serverResponse.equals("LOSE")){  //You lose
      player.lose();
      running = false;
    }
    else
      System.out.println(serverResponse);
  }
}
