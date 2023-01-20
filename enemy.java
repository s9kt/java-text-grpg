class enemy{
  private int health;
  private String enemyName;

  public enemy(){
    health = (int)(Math.random() * 30) + 1;
  }

  public void removeHealth(int x){
    health = health - x;
    System.out.println("The enemy now has " + health + " health.");
  }
}