import java.io.FileNotFoundException;
import java.util.ArrayList;

class weaponsmith extends villager {
  
  ArrayList<weapon> weapons = new ArrayList<weapon>();

  public weaponsmith() throws FileNotFoundException {
    super();
    for(int i = 0; i < 15; i++) {
      weapons.add(weaponGen());
    }
    
  }

  private weapon weaponGen() {
    switch((int)(Math.random() * 5) + 1) {
      case 1:
        return new sword();
      case 2:
        return new staff();
      case 3:
        return new bow();
      case 4:
        return new knife();
      case 5:
        return new hammer();
    }
    return new weapon();
  }

  public void displayInv() {
      for(int i = 0; i < weapons.size(); i++) {
        System.out.println("(" + i + ")" + " " + weapons.get(i));
      }
    }
}