
import java.awt.Color;

public class Tiger extends Critter {
    //Tiger is a derived class that extends the Critter class.  (Inherit from Critter).
    // Encapsulation: Private variables to store the number of moves and the current color.
    private int moves;
    private Color currentColor;
    // Constructor initializes the moves to zero.
    public Tiger(){
        moves=0;

    }

    /*Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE)
    and uses that color for three moves, then randomly picks one of those colors
    again for the next three moves then randomly picks another one of those
    colors for the next three moves, and so on.*/
    public Color getColor(){
        int rand;
        // Change color every three moves.
        if(moves%3==0){
            rand=(int) (Math.random()*3);
            if(rand==0){
                currentColor=Color.RED;
            }
            if(rand==1){
                currentColor=Color.BLUE;
            }
            if(rand==2){
                currentColor=Color.GREEN;
            }
        }
        return currentColor;

    }
    // toString provides a consistent representation of the Tiger class, showing "TGR".
    public String toString(){
        return "TGR";
    }

    /*always infect if an enemy is in front, otherwise if a wall is in front or
    to the right, then turn left, otherwise if a fellow Tiger is in front, then
    turn right, otherwise hop.*/
    public Critter.Action getMove(CritterInfo info){
        moves++;
        if(info.getFront()== Critter.Neighbor.OTHER){
            return Critter.Action.INFECT;
        }
        else if(info.getFront()== Critter.Neighbor.WALL||info.getRight()== Critter.Neighbor.WALL){
            return Critter.Action.LEFT;
        }
        else if(info.getFront()== Critter.Neighbor.SAME){
            return Critter.Action.RIGHT;
        }
        else{
            return Critter.Action.HOP;
        }
    }
}

