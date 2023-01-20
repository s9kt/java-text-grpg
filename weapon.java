class weapon extends item {
  private int dmg;
  private int classMatch;

  public weapon() {
    dmg = (int)(Math.random() * 100) + 15;
    int buyPrice = (int)(Math.random() * 75) + (dmg + 20);
    int sellPrice = (buyPrice / 2) + 5;
    super.setBuy(buyPrice);
    super.setSell(sellPrice);
  }

  protected void setName(String x) {
    super.setName(x);
  }

  protected void setClassMatch(int x) {
    classMatch = x;
  }

  public int getClassMatch() {
    return classMatch;
  }

  public int getDmg() {
    return dmg;
  }

  
}