class knife extends weapon {
  public knife() {
    super();
    super.setName(genName());
    super.setClassMatch(3);
  }

  private String genName() {
    String str = "";

    return str;
  }

  public String toString() {
    return "Knife: " + "\"" + getName() + "\"" + " for " + getBuyPrice() + " which does " + getDmg() + " damage";
  }
}