
import java.awt.Color;


public class Giant extends Critter {
    //Giant is a derived class that extends the Critter class. (Inherit from Critter).
    // Encapsulation: The state (variable "counter") of the object is kept private, thus hidden from other classes.
    private int counter;
    // Constructor initializes the counter at 1 when a new Giant object is created.
    public Giant(){
        counter =1;
    }
    // getColor() is a simple method that always returns the color GRAY for the Giant class,
    public Color getColor(){
        return Color.GRAY;
    }
    // toString() method overrides the Critter's toString() method to provide a custom string based on the counter value.
    /*"fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, lastly "fum" for 6 move, then repeat.*/
    public String toString(){
        // Reset the counter to 1 if it reaches 23, ensuring the cycle continues correctly.
        if(counter>=23){
            counter=1;
        }
        // Depending on the value of counter, return a different string
        if (counter<=6){
            return "fee";
        }
        else if(counter<=12){
            return "fie";
        }
        else if(counter<=18){
            return "foe";
        }
        return "fum";
    }
    /*	always infect if an enemy is in front, otherwise hop if possible, 
    otherwise turn right.*/
    // getMove() method dictates the behavior of the Giant in its environment.
    // It also demonstrates method overriding and the use of polymorphism.
    public Action getMove(CritterInfo info){
        counter++;
        // Prioritize infecting an enemy if one is in front.
        if (info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        }
        // If there's an empty space in front, hop.
        else if(info.getFront()==Neighbor.EMPTY){
            return Action.HOP;
        }
        else{
            // Otherwise, turn right.
            return Action.RIGHT;
        }
    }
}
