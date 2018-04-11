public class College {
  private String name = "College";
  private int health = 100;
  private int damage;

  public College() {
    System.out.println("constructed");
  }
  public int move1() {
    //roll = 1 for demonstration
    int roll = 1;
    //roll = dice roll (random number between -3 and 3)
    damage = 5 + roll;
    return damage;
  }
}

class Dodge extends College {
  //can make everything in player class or each college can be a different class.

}
