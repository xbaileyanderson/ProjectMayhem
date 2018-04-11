import java.util.Random;
class Argyros extends College{
  Argyros()
  {
    int health = 100;
  }


  //Analyze trend: "Enemy is spending too little on defense"
  public int move3(){
    Random rand = new Random();
    int baseDamage = 25;
    int damage = baseDamage+rand.nextInt(15);
    return damage;
  }

  //Look for investors:
  //"Raising money to buy a new weapon"
  //"Raised just enough to do: " + damage
  public int move4() {
    Random rand = new Random();
    int baseDamage = 20;
    int damage = baseDamage+rand.nextInt(50);
    return damage;
  }

}
