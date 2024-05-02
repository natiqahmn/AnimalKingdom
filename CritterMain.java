// CSE 142 Homework 9 (Critters)
// Authors: Stuart Reges and Marty Stepp
//          modified by Kyle Thayer
//
// CritterMain provides the main method for a simple simulation program.  Alter
// the number of each critter added to the simulation if you want to experiment
// with different scenarios.  You can also alter the width and height passed to
// the CritterFrame constructor.

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame(60, 40);

        //uncomment each of these lines as you complete these classes
        //frame.add(30, Bear.class);
      // frame.add(30, Tiger.class);
    //  frame.add(30, WhiteTiger.class);
      // frame.add(30, Giant.class);
       frame.add(30, NinjaCat.class);

        frame.add(30, FlyTrap.class);
        frame.add(30, Food.class);

        frame.start();
    }
}

//concept of polymorphism. allows CritterFrame to interact with various critter types polymorphically,
// using a common set of methods defined in the superclass or interface.