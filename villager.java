import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class villager {
  private String name;
  // private String occupation;  Physician, Weaponsmith, or General Store
  
  public villager()throws FileNotFoundException{
    setName(); // Getting name
  }

  private void setName() throws FileNotFoundException {
    // Sourced from https://www.usna.edu/Users/cs/roche/courses/s15si335/proj1/files.php%3Ff=names.txt.html
    File text = new File("names.txt");
    Scanner scanr = new Scanner(text); 
    int linenum = 1; 
    int desired = (int)(Math.random() * 18239) + 1;
    while(desired != linenum){
      name = scanr.nextLine();
      linenum++;
    }
  }

  public String getName() {
    return name;
  }
  

}