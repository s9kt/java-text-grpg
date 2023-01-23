import java.io.*;
import java.util.Scanner;

// https://stackoverflow.com/questions/14088221/accessing-objects-of-other-classes
class Main {
  static Player[] players;
  static enemy e = new enemy();
  static weapon s = new sword();

  public static void main(String[] args) throws FileNotFoundException {

    System.out.println(
        "My attempt at a DnD based RPG but in a command line.\nMade while I was bored as hell in APCSA class.");

    int x = (int) (Math.random() * 4) + 1;
    System.out.println("In this adventure, you will have " + x + " characters.");

    players = new Player[x];
    for (int i = 0; i < x; i++) {
      players[i] = new Player(i + 1);
      // Create a getStats(); method to pull information
      // Syntax would be like System.out.println(players[x].getProfile());
    }
    x = (int) (Math.random() * 10) + 1;
    Locations[] locations = new Locations[x];
    for (int i = 0; i < x; i++) {
      locations[i] = new Locations();
    }

    for (int i = 0; i < locations.length; i++) {
      enterLoc(i, locations);
    }

    // System.out.println(players[0].getProfile());

  }

  public static void enterLoc(int i, Locations[] loc) {
    System.out.println("Entering " + loc[i].getName());
    boolean exit = false;
    while (exit == false) {
      Scanner sc = new Scanner(System.in);
      System.out.println(
          "What would you like to do?\n(0) Talk to the Weaponsmith\n(1) Talk to the Physician\n(2) Talk to the General Store Owner\n(3) Quit");
      int x = sc.nextInt();
      switch (x) {
        case 0:
          System.out.println("Hi, welcome to my weapon shop! My name is " + loc[i].weaponsmith.getName());
          while (true) {
            System.out.println("What would you like to do?\n(0) Buy\n(1) Sell\n(2) Leave");
            x = sc.nextInt();
            if (x == 0) {
              while (true) {
                System.out.println("What would you like to buy? Or type -1 to exit");
                loc[i].weaponsmith.displayInv();
                x = sc.nextInt();
                if (x == -1) {
                  break;
                }
                weapon hold = loc[i].weaponsmith.weapons.get(x);
                if (hold.getBuyPrice() > Player.getMoney()) {
                  System.out.println("You do not have enough money to purchase this item.");
                  continue;
                }
                Player.removeMoney(hold.getBuyPrice());
                loc[i].weaponsmith.weapons.remove(x);
                System.out.println("Which player would you like to give this item to?");
                for (int j = 0; j < players.length; j++) {
                  System.out.println("Player " + (j + 1));
                }
                x = sc.nextInt() - 1;
                players[x].weaponInv.add(hold);
              }
            }
            if (x == 1) {
              while (true) {
                System.out.println("What would you like to sell? Select a Player, or type -1 to exit.");
                for (int j = 0; j < players.length; j++) {
                  System.out.println("Player " + (j + 1));
                }
                x = sc.nextInt() - 1;

                if (x == -2) {
                  break;
                }
                System.out.println("Player " + (x + 1) + "'s inventory");
                players[x].displayInv();
                System.out.println("What do you wish to sell?");
                int sell = sc.nextInt();
                Player.addMoney(players[x].weaponInv.get(sell).getSellPrice());
                players[x].removeWeaponInv(sell);
              }
            }
            if (x == 2) {
              break;
            }
          }
          break;

        case 3:
          exit = true;
          break;

      }
    }
  }

}