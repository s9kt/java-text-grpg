class healpot extends potion {
  public healpot() {
    setName("Healing potion");
    setEffect("Healing");
    int effectVal = genEffectVal();
    setEffectVal(effectVal);
    setBuy(genPrice(effectVal));
    
  }

  private int genPrice(int x) {
    return (int)(Math.random() * 30) + x;
  }

  private int genEffectVal() {
    return (int)(Math.random() * 100);
  }

  
}