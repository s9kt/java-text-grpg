class item {
  private String itemName;
  private int buyPrice;
  private int sellPrice;

  public item() {

  }

  public item(String name, int sell) {
    itemName = name;
    sellPrice = sell;
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