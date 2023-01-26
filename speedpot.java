class speedpot extends potion {
  int effectVal;
  public speedpot() {
    setEffect("Speed");
    effectVal = genEffectVal();
    setEffectVal(effectVal);
    setBuy(genPrice(effectVal));
  }

  private int genPrice(int x) {
    return (int)(Math.random() * 50) + x;
  }

  private int genEffectVal() {
    return (int)(Math.random() * 45);
  }

  public void usePot(Player player) {
    player.addHealth(effectVal);
  }
}