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
    x = (int) (Math.random() * 7) + 3;
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
      if (validInput(x, 0, 3) == false) {
        continue;
      }
      switch (x) {
        case 0:
          System.out.println("Hi, welcome to my weapon shop! My name is " + loc[i].weaponsmith.getName());
          while (true) {
            System.out.println("What would you like to do?\n(0) Buy\n(1) Sell\n(2) Leave");
            x = sc.nextInt();
            if (validInput(x, 0, 2) == false) {
              continue;
            }
            if (x == 0) {
              while (true) {
                System.out.println("What would you like to buy? Or type -1 to exit");
                System.out.println("Note the following matches for weapon types and classes:");
                System.out.println("Knight: Sword\nMage: Staff\nRanger Bow\nAssassain: Knife\nPaladin: Hammer");
                loc[i].weaponsmith.displayInv();
                System.out.println("You have " + Player.getMoney() + " money");
                x = sc.nextInt();
                if (x == -1) {
                  break;
                } else if (validInput(x, 0, loc[i].weaponsmith.weapons.size() - 1) == false) {
                  continue;
                }
                weapon hold = loc[i].weaponsmith.weapons.get(x);
                if (hold.getBuyPrice() > Player.getMoney()) {
                  System.out.println("You do not have enough money to purchase this item. You have " + Player.getMoney() + " money.");
                  continue;
                }
                Player.removeMoney(hold.getBuyPrice());
                loc[i].weaponsmith.weapons.remove(x);
                while (true) {
                  System.out.println("Which player would you like to give this item to?");
                  for (int j = 0; j < players.length; j++) {
                    System.out.println("Player " + "(" + (j + 1) + ")");
                  }
                  x = sc.nextInt() - 1;
                  if (validInput(x, 0, players.length - 1) == false) {
                    continue;
                  }
                  players[x].weaponInv.add(hold);
                    break;
                }
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
                } else if (validInput(x, 0, players.length - 1) == false) {
                  continue;
                } else if (players[x].weaponInv.size() == 0) {
                  System.out.println("Player " + (x + 1) +  "'s inventory is empty.");
                  continue;
                }

                System.out.println("Player " + (x + 1) + "'s inventory");
                players[x].displayWeaponInv();
                System.out.println("What do you wish to sell?");
                int sell = sc.nextInt();
                if(validInput(sell, 1, Player.inv.size()) == false) {
                  continue;
                }
                Player.addMoney(players[x].weaponInv.get(sell).getSellPrice());
                players[x].removeWeaponInv(sell);
              }
            }
            if (x == 2) {
              break;
            }
          }
          break;
        case 1:
          System.out.println("Hi, welcome to my Pharmacy! My name is " + loc[i].physician.getName());
          while (true) {
            System.out.println("What would you like to do?\n(0) Buy\n(1) Leave");
            x = sc.nextInt();
            if(x == 1) {
              break;
            }
            if(validInput(x, 0, 1) == false) {
              continue;
            }
            if(x == 0) {
              System.out.println("What potion would you like to purchase? Or type -1 to exit.");
              System.out.println("Healing Potions give you health\nStrength potions give you extra damage\nSpeed potions give you a higher chance of dodging.");
              while(true) {
                loc[i].physician.displayInv();
                System.out.println("You have " + Player.getMoney() + " money.");
                x = sc.nextInt();
                if (x == -1) {
                  break;
                } else if (validInput(x, 0, loc[i].weaponsmith.weapons.size() - 1) == false) {
                  continue;
                }
                potion hold = loc[i].physician.potions.get(x);
                if(hold.getBuyPrice() > Player.getMoney()) {
                  System.out.println("You do not have enough money to purchase this item. You have " + Player.getMoney() + " money.");
                  continue;
                }
                Player.removeMoney(hold.getBuyPrice());
                loc[i].physician.potions.remove(x);
                while (true) {
                  System.out.println("Which player would you like to give this item to?");
                  for (int j = 0; j < players.length; j++) {
                    System.out.println("Player " + "(" + (j + 1) + ")");
                  }
                  x = sc.nextInt() - 1;
                  if (validInput(x, 0, players.length - 1) == false) {
                    continue;
                  }
                  players[x].potionInv.add(hold);
                    break;
                }

                
              }
            }
          }
          break;
        
          case 2:
          System.out.println("Welcome to my store! My name is " + loc[i].genStore.getName());
          while(true) {
            System.out.println("What would you like to do?\n(0) Sell\n(1) Leave");
            x = sc.nextInt();
            if(validInput(x, 0, 1) == false) {
              continue;
            }
            else if(x == 1) {
              break;
            }
            if(x == 0) {
              while (true) {
                System.out.println("What would you like to sell? Select a Player, or type -1 to exit.");
                for (int j = 0; j < players.length; j++) {
                  System.out.println("Player " + (j + 1));
                }
                x = sc.nextInt() - 1;
                if (x == -2) {
                  break;
                } else if (validInput(x, 0, players.length - 1) == false) {
                  continue;
                } else if (players[x].weaponInv.size() == 0) {
                  System.out.println("Player " + (x + 1) +  "'s inventory is empty.");
                  continue;
                }

                System.out.println("Player " + (x + 1) + "'s inventory");
                players[x].displayInv();
                System.out.println("What do you wish to sell?");
                int sell = sc.nextInt();
                if(validInput(sell, 1, players.length) == false) {
                  continue;
                }
                Player.addMoney(players[x].inv.get(sell).getSellPrice());
                players[x].removeInv(sell);
              }
            }
            }
            break;
            
          case 3:
            exit = true;
            break;
          }
      }
    }

  public static boolean validInput(int value, int min, int max) {
    if (min - 1 < value && value < max + 1) {
      return true;
    } else {
      System.out.println("Input is invalid, please try again.");
      return false;
    }
  }

}