import java.util.Random;
public abstract class College {

  //Strings each class needs
  private String name;
  private String major;
  private int health;

  //moves 1 and 2 are standard for all classes
  //moves 3 and 4 are defined in derived classes
  public static int move1(){
    Random rand = new Random();
    int baseDamage = 5;
    int damage = baseDamage+rand.nextInt(15);
    return damage;
  }

  public static int move2(){
    Random rand = new Random();
    int baseDamage = 0;
    int damage = baseDamage + rand.nextInt(25);
    return damage;
  };

  public abstract int move3();
  public abstract int move4();
  public static void main(String[] args){


    //lines 31-34 compile correctly
    int j = move1();
    int k = move2();
    System.out.println(j);
    System.out.println(k);

  }

  //public College() {
  //  System.out.println("constructed");
  //}
}
