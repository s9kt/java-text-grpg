class hammer extends weapon {
  public hammer() {
    super();
    super.setName(genName());
    super.setClassMatch(4);
  }

  private String genName() {
    String str = "";

    return str;
  }

  public String toString() {
    return "Hammer: " + "\"" + getName() + "\"" + " for " + getBuyPrice() + " which does " + getDmg() + " damage";
  }
}