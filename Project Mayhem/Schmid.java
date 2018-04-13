import java.util.Random;
public class Schmid extends College {
  int health = 120;
  int damage;
  // name: Caffeine bender (heal)
  public int move3() {
    int healAmount;
    if (health < 20)
    {
      healAmount = 30;
    }
    else {
      healAmount = 10;
    }
    return healAmount;
  }
  // name: DDOS (heal + attack)
  public int move4() {
    // move will eventually be 10 damage then next turn it will do 5 damage for 2 turns on top of whatever other move they do.
    damage = 10;
    return damage;
  }
}
