class bow extends weapon {
  public bow() {
    super();
    super.setName(genName());
    super.setClassMatch(2);
  }

  private String genName() {
    String str = "";

    return str;
  }

  public String toString() {
    return "bow: " + "\"" + getName() + "\"" + " for " + getBuyPrice() + " which does " + getDmg() + " damage";
  }
}