class item {
  private String itemName;
  private int buyPrice;
  private int sellPrice;

  public item() {

  }

  protected void setName(String x) {
    itemName = x;
  }

  protected void setBuy(int x) {
    buyPrice = x;
  }

  protected void setSell(int x) {
    sellPrice = x;
  }

  public String getName() {
    return itemName;
  }

  public int getBuyPrice() {
    return buyPrice;
  }

  public int getSellPrice() {
    return sellPrice;
  }
}