import java.io.*;
import java.util.ArrayList;
class physician extends villager {
  
    
  ArrayList<potion> potions = new ArrayList<potion>();

  public physician() throws FileNotFoundException {
    super();
    for(int i = 0; i < 15; i++) {
      potions.add(potionGen());
    }
    
  }

  private potion potionGen() {
    switch((int)(Math.random() * 3) + 1) {
      case 1:
        return new healpot();
      case 2:
        return new speedpot();
      case 3:
        return new strengthpot();
    }
    return new potion();
  }

  public void displayInv() {
      for(int i = 0; i < potions.size(); i++) {
        System.out.println("(" + i + ")" + " " + potions.get(i));
      }
    }
}