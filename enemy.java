class enemy{
  private int health;
  private int lightAttack;

  public enemy(){
    health = (int)(Math.random() * 50) + 10;
    lightAttack = (int)(Math.random() * health) + 5;
  }

  public void removeHealth(int x){
    health -= x;
    System.out.println("The enemy now has " + health + " health.");
  }

  public void lightAttack(Player player, int playerNum) {
    System.out.println("The enemy performed a light attack on player " + playerNum + "!");
    player.removeHealth();
  }
}