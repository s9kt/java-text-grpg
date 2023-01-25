class weapon extends item {
  private int dmg;
  private int classMatch;
  private String type;

  public weapon() {
    dmg = (int) (Math.random() * 100) + 15;
    int buyPrice = (int) (Math.random() * 75) + (dmg + 20);
    int sellPrice = (buyPrice / 2) + 5;
    super.setBuy(buyPrice);
    super.setSell(sellPrice);
  }

  protected void setClassMatch(int x) {
    classMatch = x;
  }

  protected void setType(String x) {
    type = x;
  }

  public int getClassMatch() {
    return classMatch;
  }

  public int getDmg() {
    return dmg;
  }

  public String getType() {
    return type;
  }

  public String toString() {
    return getType() + ": " + "\"" + getName() + "\"" + " for " + getBuyPrice() + " which does " + getDmg() + " damage";
  }

}