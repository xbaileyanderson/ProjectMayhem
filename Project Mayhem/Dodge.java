import java.util.Random;
public class Dodge extends College {
  //can make everything in player class or each college can be a different class.
  int health = 80;
  //name: script change (heal + attack)
  public int move3() {
    int damage;
    health = health + 20;
    damage = 20;
    return damage;
  }
  //name: That's a wrap (attack)
  public int move4() {
    int damage;
    int dam;
    int base = 20;
    Random rand = new Random();
    if (health < 10) {
      dam = rand.nextInt(90);
    }
    else if (health < 20) {
      dam = rand.nextInt(80);
    }
    else if (health < 30) {
      dam = rand.nextInt(70);
    }
    else {
      dam = 0;
    }
    damage = base + dam;
    return damage;
  }
}
