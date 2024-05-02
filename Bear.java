
import java.awt.Color;

public class Bear extends Critter {
    //Bear is a derived class that extends the Critter class. (Inherit from Critter).
    //data encapsulation refers to integrating data ("polar" & "moves") and code (methods such as getColor()) into a single unit
    // "polar" is used to determine the color of the bear.
    // "moves" is used to alternate between two states for the toString method.

    private boolean polar;
    private int moves;

    // Constructor to initialize the Bear object with the "polar" property.
    // "polar" determines the color of the bear.
    public Bear(boolean polar){
        this.polar=polar; // Set the instance variable "polar" to the passed value.
    }
    // getColor is an overridden method from the Critter class that returns a Color object.
    // It uses the "polar" attribute to decide the color.
    public Color getColor() {
        if(polar==true){
            return Color.WHITE;
        }

        else{
            return Color.BLACK;
        }
    }

    //Color.WHITE when polar is true (polar bear)
    //Color.BLACK when polar is false


    /*Should substitute on each different move between a slash character(/)
    and a backslash character (\\) starting with a slash.*/

    public String toString(){
        // Use the modulo operator to alternate between "/" and "\\" every move.

        if(moves%2==0){
            return "/";
        }
        else{
            return "\\" ;
        }
    }
    /*always infect if an enemy is in front, otherwise hop if possible, 
    otherwise turn left.*/
    // getMove is an overridden method that defines the behavior of the Bear.
    // It decides the action based on the situation described by CritterInfo.
    public Action getMove(CritterInfo info){
        moves++;
        // If there's an enemy Critter in front, infect it.
        if (info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        }
        // If there's a wall in front, turn left.
        else if(info.getFront()==Neighbor.WALL){
            return Action.LEFT;
        }
        else{
            // Otherwise, if possible, hop.
            return Action.HOP;
        }
    }
}
