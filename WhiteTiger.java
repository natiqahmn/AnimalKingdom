
import java.awt.Color;

public class WhiteTiger extends Critter {
    //WhiteTiger is a derived class that extends the Critter class.  (Inherit from Critter).
    // Encapsulation: Private variable to track whether this WhiteTiger has infected another Critter.
    private boolean infected;
    // Constructor initializes the WhiteTiger as not having infected any other Critters.
    public WhiteTiger(){
        infected=false;
    }
    // getColor returns a constant color of WHITE, representing this specific type of Tiger.
    public Color getColor(){
        return Color.WHITE;
    }
    
    //“tgr” if it hasn’t infected another Critter yet, “TGR” if it has infected.
    public String toString(){
        if(infected==true){
            return "TGR";
        }
        else{
            return "tgr";
        }
    }
    
    //Same with Tiger
    public Action getMove(CritterInfo info){
        if(info.getFront()==Neighbor.OTHER){
            infected=true;
            return Action.INFECT;
        }
        // If there's another Critter in front, infect it and mark this WhiteTiger as having infected someone.
        else if(info.getFront()==Neighbor.WALL||info.getRight()==Neighbor.WALL){
            return Action.LEFT;
        }
        // If facing another WhiteTiger, then turn right.
        else if(info.getFront()==Neighbor.SAME){
            return Action.RIGHT;
        }
        // Default action is to hop forward if none of the other conditions apply.
        else{
            return Action.HOP;
        }
    }
    
}
