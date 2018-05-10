import java.util.Random;
public class Move {
  public int damage;
  public int heal;
  public boolean skip;
  public Move(int d, int h, boolean s){
    damage = d;
    heal = h;
    skip = s;
  }
}
