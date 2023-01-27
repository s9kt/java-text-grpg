class healpot extends potion {
  int effectVal;
  public healpot() {
    setEffect("Health");
    setName("Health potion");
    effectVal = genEffectVal();
    setEffectVal(effectVal);
    setBuy(genPrice(effectVal));
    
  }

  private int genPrice(int x) {
    return (int)(Math.random() * 30) + x;
  }

  private int genEffectVal() {
    return (int)(Math.random() * 100);
  }

  public void usePot(Player player) {
    player.addHealth(effectVal);
  }

  
}