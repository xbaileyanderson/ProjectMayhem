public class Player {
  private String college;
  private String name;
  private String catchphrase;

  public void setCollege(String c)
  {
    this.college = c;
  }
  public String getCollege()
  {
    return this.college;
  }
  public void setName(String n)
  {
    this.name = n;
  }
  public String getName()
  {
    return this.name;
  }
  public void setCatchphrase(String cp)
  {
    this.catchphrase = cp;
  }
  public String getCatchphrase()
  {
    return this.catchphrase;
  }
  public int win()
  {
    return 1;
  }
  public int lose()
  {
    return 1;
  }
  public int play()
  {
    return 1;
  }
}
