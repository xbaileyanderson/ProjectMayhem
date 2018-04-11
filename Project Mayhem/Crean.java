import java.util.Random;

public class Crean extends College{

  Crean()
  {
    int health = 100;
  }


  //Psycho-analysis. "Poke at enemy's insecurities"
  //
  public int move3(){
    Random rand = new Random();
    int baseDamage = 20;
    int damage = baseDamage+rand.nextInt(15);
    return damage;
  }

  //3 potential names
  //Therapeutic massage
  //Pep-talk
  //Therapy session
  public int move4() {
    Random rand = new Random();
    int baseHeal = 20;
    int healAmount = baseHeal+rand.nextInt(30);
    return healAmount;
  }

}
