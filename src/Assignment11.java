// Assignment #: 11
//  Name: Rhea Mane
//  StudentID: 1222796497
//  Lecture Time: T/Th 1:30
//  Time took you to complete the assignment: 2 hours
//  Description: This is the driver class, it implements all the other classes.

public class Assignment11 {

    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver();
        mazeSolver.readMaze();

        System.out.println("Original maze: ");
        mazeSolver.printMaze();

        mazeSolver.depthFirstSearch();

        System.out.println("Maze after Easter Bunny traverse: ");
        mazeSolver.printMaze();

        if (mazeSolver.getEggFound() == 0)
            System.out.println("The Bunny was unable to recover the eggs, Easter is cancelled!");
        else
            System.out.println("The Easter Bunny found " + mazeSolver.getEggFound() + " egg(s)!");
    }
}