class enemy {
  private int health;
  private int lightAttack;

  public enemy(int level) {
    health = ((int) (Math.random() * 5) + 1) * 10;
    lightAttack = (int) (Math.random() * health) + (level * 5);
  }

  public void removeHealth(int x) {
    health -= x;
    System.out.println("The enemy now has " + health + " health.");
  }

  public void lightAttack(Player player, int playerNum) {
    System.out.println("The enemy performed a light attack on player " + playerNum + "!");
    player.removeHealth(lightAttack);
  }

  public void heavyAttack(Player player, int playerNum) {

  }
}