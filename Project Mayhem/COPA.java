import java.util.Random;
class COPA extends College{
  int health = 100;
  COPA()
  {
  }


  //This move will eventually turn into a move that skips the other players turn and adds 10 health to yourself
  public int move3()
  {
    //sends to clienthandler to skip next player and return back to this player
    int addsHealth = health + 10;
    return addsHealth;
  }

  //This move will eventually block the opponant's attack, for now as a place holder until we get the clienthandler
  //working I am making it an attack
  public int move4()
  {
    Random rand = new Random();
    int damage = 5 + rand.nextInt(50);
    return damage;
  }

}
