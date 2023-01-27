class potion extends item {
  private String effect;
  private int effectVal;

  public potion() {
    
  }

  protected void setEffect(String x) {
    effect = x;
  }

  
  protected void setEffectVal(int x) {
    effectVal = x;
  }

  public String getEffect() {
    return effect;
  }
  
  public int getEffectVal() {
   return effectVal; 
  }


  public String toString() {
    return "This is a " +  getName() + " that gives " + getEffectVal() + " " + getEffect() + " and costs " + getBuyPrice();
  }
}