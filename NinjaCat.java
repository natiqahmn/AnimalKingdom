
import java.awt.Color;


public class NinjaCat extends Critter {
    //NinjaCat is a derived class that extends the Critter class.  (Inherit from Critter).
    // Encapsulation: The 'infections' variable is private, managing the state of infections internally.
    private int infections;
    // Constructor to initialize NinjaCat with zero infections.
    public NinjaCat(){
        infections=0;
    }
    // toString method is overridden to display the number of infections this NinjaCat has made.
    // Returns a string that includes the number of infections made by this NinjaCat.
    public String toString(){
        return "K: "+infections+"";
    }
    //color is based on how many infections it has done
    // getColor is overridden to provide a Color based on the number of infections.
    // This method demonstrates the use of conditional logic to return different values.
    public Color getColor(){
        if(infections==0){
           return Color.YELLOW; 
        }
        else if(infections==1){
            return Color.cyan;
        }
        else if (infections==2){
            return Color.MAGENTA;
        }
        else if (infections==3){
            return Color.orange;
        }
        else if (infections==4){
            return Color.PINK;
        }
        else if (infections==5){
            return Color.GREEN;
        }
        return Color.RED;
    }

    // getMove is an overridden method that defines how NinjaCat behaves in its environment.
    // This method also uses polymorphism by defining specific behavior different from potentially other Critter objects.
    public Critter.Action getMove(CritterInfo info){
  // Check the neighbor in front and decide action based on it.
        if (info.getFront()==Critter.Neighbor.OTHER){
            infections++;
            return Critter.Action.INFECT;
      
        }
       else if(info.getFront()==Critter.Neighbor.EMPTY){
            return Critter.Action.HOP; // Hop if the space in front is empty.
        }
        else{
            return Critter.Action.RIGHT;  // Turn right if neither infecting nor hopping is possible.
        }
    }
}
