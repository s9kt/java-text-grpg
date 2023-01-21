class staff extends weapon {
  public staff() {
    super();
    super.setName(genName());
    super.setClassMatch(1);
    super.setType("Staff");
  }

  private String genName() {
    String str = "";

    return str;
  }

  public String toString() {
    return "Staff: " + "\"" + getName() + "\"" + " for " + getBuyPrice() + " which does " + getDmg() + " damage";
  }
}