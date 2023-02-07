import java.util.ArrayList;
import java.util.Scanner;

class Player {
  private String charName;
  private int race;
  private int classSelect;
  private int health = 30;
  private static int money = 100;
  private weapon equipped;
  private int str;
  private int dex;
  private int con;
  private int intel;
  private int wis;
  private int cha;
  ArrayList<weapon> weaponInv;
  ArrayList<potion> potionInv;
  static ArrayList<item> inv = new ArrayList<item>();

  public Player(int x) {
    weaponInv = new ArrayList<weapon>();
    potionInv = new ArrayList<potion>();
    // Getting name of character
    // genName(x);
    // Getting race of character
    // getRace();
    // Getting class of character
    // classSelect();
    // Getting and assigning stat #'s
    // statSelect();
    // Add the race bonuses to the stats
    // raceBonus(race);
  }

  private String genName(int x) {
    Scanner getName = new Scanner(System.in);
    System.out.println("What is the name of character " + x + "?");
    charName = getName.nextLine();
    System.out.println("Name set to: " + charName);
    return charName;
  }

  private int getRace() {
    while (true) {
      Scanner getRace = new Scanner(System.in);
      System.out.println("Each race determines certain beginning status boosts.");
      System.out.println("Select from this list which race you would like:");
      System.out.println(
          "(0) Humans, +1 to all ability scores\n(1) Dragonborn, +2 Strength and +1 Charisma\n(2) Dwarf, +2 Constitution\n(3) Elf +2 Dexterity\n(4) Gnome, +2 intelligence\n(5) Half-Orc, +2 Strength and +1 Constitution\n(6) Tiefling, +2 Charisma and +1 intelligence");
      race = getRace.nextInt();
      if (race < 0 || race > 0) {
        System.out.println("Please provide a valid input. (0-0)");
      } else {
        String[] races = { "Human", "Dragonborn", "Dwarf", "Elf",
            "Gnome", "Half-Orc", "Tiefling" };
        System.out.println("You've selected " + races[race] + " as your race.");
        // https://www.dndbeyond.com/races
        // getRace.close();
        break;
      }
    }
    return race;
  }

  private int classSelect() {
    while (true) {
      Scanner getClass = new Scanner(System.in);
      System.out.println("Each class determines the type of weapon and attacks you will use.");
      System.out.println("Select from this list which class you would like:");
      System.out.println(
          "(0) Knight, uses a sword, good for short range combat\n(1) Mage, uses a magical staff and good at a distance\n(2) Ranger, uses a bow and arrow, good at a distance\n(3) Assassain, has dual weild knives for short range quick attacks\n(4) Paladin, a tanky figure weilding a large hammer for slow but strong attacks.");
      classSelect = getClass.nextInt();
      if (classSelect < 0 || classSelect > 4) {
        System.out.println("Please provide a valid input. (0-4)");
      } else {
        String[] classes = { "Knight", "Mage", "Ranger", "Assassin", "Paladin" };
        System.out.println("You've selected " + classes[classSelect] + " as your class.");
        // https://www.dndbeyond.com/classes
        break;
      }
    }
    return classSelect;
  }

  private void statSelect() {
    ArrayList<String> stats = new ArrayList<String>();
    stats.add("Strength");
    stats.add("Dexterity");
    stats.add("Constitution");
    stats.add("Intelligence");
    stats.add("Wisdom");
    stats.add("Charisma");

    ArrayList<Integer> values = new ArrayList<Integer>();

    for (int i = 0; i < 6; i++) {
      int a = (int) (Math.random() * 6) + 1;
      int b = (int) (Math.random() * 6) + 1;
      int c = (int) (Math.random() * 6) + 1;
      values.add(a + b + c);
    } // Generate the stat values
    System.out.println("Assign each value to a stat.");
    for (int i = 6; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        System.out.println("(" + j + ")" + stats.get(j));
      }
      Scanner scan = new Scanner(System.in);
      System.out.println("Pick a stat");
      int a = scan.nextInt();
      for (int j = 0; j < i; j++) {
        System.out.println("(" + j + ")" + values.get(j));
      }
      Scanner scan2 = new Scanner(System.in);
      System.out.println("Pick a value");
      int b = scan2.nextInt();

      System.out.println(values.get(b) + " has been assigned to " + stats.get(a));

      switch (stats.get(a)) {
        case "Strength":
          str += values.get(b);
          break;
        case "Dexterity":
          dex += values.get(b);
          break;
        case "Constitution":
          con += values.get(b);
          break;
        case "Intelligence":
          intel += values.get(b);
          break;
        case "Wisdom":
          wis += values.get(b);
          break;
        case "Charisma":
          cha += values.get(b);
          break;
      }
      values.remove(b);
      stats.remove(a);

    }
  }

  private void raceBonus(int raceSel) {
    switch (raceSel) {
      case 0:
        str++;
        dex++;
        intel++;
        con++;
        wis++;
        cha++;
        break;
      case 1:
        str += 2;
        cha++;
        break;
      case 2:
        con += 2;
        break;
      case 3:
        dex += 2;
        break;
      case 4:
        intel += 2;
        break;
      case 5:
        str += 2;
        con++;
        break;
      case 6:
        cha += 2;
        intel++;
    }
    System.out.println("Race bonuses have been added");
  }

  public String getProfile(int x) {
    String profile = charName + "'s profile: \nStrength:\t" + str + "\nDexterity:\t" + dex + "\nConstitution:\t" + con
        + "\nIntelligence:\t" + intel + "\nWisdom:\t" + wis + "\nCharisma:\t" + cha + "\nHealth:\t" + health;
    return profile;
  }

  public int getHealth() {
    return health;
  }

  public void addHealth(int x) {
    health += x;
  }

  public void removeHealth(int x) {
    health -= x;
  }

  public int getPlrClass() {
    return classSelect;
  }

  public void addWeaponInv(weapon weapon) {
    weaponInv.add(weapon);
  }

  public static void addInv(item item) {
    inv.add(item);
  }

  public void removeWeaponInv(int x) {
    weaponInv.remove(x);
  }

  public static void removeInv(int x) {
    inv.remove(x);
  }

  public static void addMoney(int x) {
    money += x;
    System.out.println(x + " money has been added to your balance");
  }

  public static void removeMoney(int x) {
    money -= x;
    System.out.println(x + " money has been deducted from your balance.");
  }

  public static int getMoney() {
    return money;
  }

  public void displayInv() {
    for(int i = 0; i < weaponInv.size(); i++) {
      System.out.println(i + ") " + weaponInv.get(i).getType() + " " + weaponInv.get(i).getName() + " which does " + weaponInv.get(i).getDmg() + " damage and sells for " + weaponInv.get(i).getSellPrice());
    }
  }

  public static void displayCommonInv() {
    for(int i = 0; i < inv.size(); i++) {
      System.out.println(i + ") " + inv.get(i).getName() + " for " + inv.get(i).getSellPrice() + " money.");
    }
  }

  public String getName() {
    return charName;
  }
  public void equip(weapon weapon) {
    equipped = weapon;
    System.out.println(weapon + " has been equipped.");
  }

  public int lightAttack() {
    int dmg = equipped.getDmg();
    return str + dmg;
  }

  public int heavyAttack() {
    int dmg = equipped.getDmg();
    return str + dmg + 10;
  }
}