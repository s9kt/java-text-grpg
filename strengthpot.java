class strengthpot extends potion {
  int effectVal;
  public strengthpot() {
    setEffect("Strength");
    setName("Strength potion");
    effectVal = genEffectVal();
    setEffectVal(effectVal);
    setBuy(genPrice(effectVal));
    
  }

  private int genPrice(int x) {
    return (int)(Math.random() * 30) + x;
  }

  private int genEffectVal() {
    return (int)(Math.random() * 50);
  }

  public void use(Player player) {
    player.addHealth(effectVal);
  }

}