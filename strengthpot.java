class strengthpot extends potion {
  public strengthpot() {
    setName("Strength potion");
    setEffect("Strength");
    int effectVal = genEffectVal();
    setEffectVal(effectVal);
    setBuy(genPrice(effectVal));
    
  }

  private int genPrice(int x) {
    return (int)(Math.random() * 30) + x;
  }

  private int genEffectVal() {
    return (int)(Math.random() * 50);
  }

}