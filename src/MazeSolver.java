// Assignment #: 11
//  Name: Rhea Mane
//  StudentID: 1222796497
//  Lecture Time: T/Th 1:30
//  Time took you to complete the assignment: 2 hours
//  Description: This is the MazeSolver class, it contains the methods to implement the depth first search algorithm and
//  printing the grid also returning the number of eggs found.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MazeSolver {
    private Stack<Node> stack;
    private char[][] maze;
    private int eggFound;
    private int mHeight;
    private int mWidth;

    public MazeSolver() {
        stack = new Stack<Node>();
        eggFound = 0;
    }

    public void printMaze() {
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void depthFirstSearch() {
        stack.push(new Node(0, 0)); // Initial element
        while (!stack.isEmpty()) {
            //Pop a node from the stack
            //Check if the node has any egg (collect egg and increase egg count if yes)
            //Mark the current node as visited
            Node node = stack.pop();
            if (maze[node.getX()][node.getY()] == 'E') {
                maze[node.getX()][node.getY()] = 'x';
                eggFound++;
            }
            if (maze[node.getX()][node.getY()] == 'B' || maze[node.getX()][node.getY()] == '.')
                maze[node.getX()][node.getY()] = 'x';


//            Calculate the coordinate of the adjacent node to the south
//            Check if the node coordinates are in bounds of the maze (no negative numbers, etc)
//            Check if the adjacent node is not yet visited and it is not a wall
//            Create a new node from that coordinate and push it into the stack

            int southX = node.getX() + 1;
            int southY = node.getY();
            if (((southX > -1) && (southX < mHeight)) && ((southY > -1) && (southY < mWidth))) {
                if (maze[southX][southY] == '.' || maze[southX][southY] == 'E') {
                    Node newNode = new Node(southX, southY);
                    stack.push(newNode);
                }
            }

//            Calculate the coordinate of the node to the east
//            Check if the node coordinates are in bounds of the maze (no negative numbers, etc)
//            Check if the adjacent node is not yet visited and it is not a wall
//            Create a new node from that coordinate and push it into the stack

            int eastX = node.getX();
            int eastY = node.getY() + 1;
            if (((eastX > -1) && (eastX < mHeight)) && ((eastY > -1) && (eastY < mWidth))) {
                if (maze[eastX][eastY] == '.' || maze[eastX][eastY] == 'E') {
                    Node newNode1 = new Node(eastX, eastY);
                    stack.push(newNode1);
                }
            }

//            Calculate the coordinate of the node to the north
//            Check if the node coordinates are in bounds of the maze (no negative numbers, etc)
//            Check if the adjacent node is not yet visited and it is not a wall
//            Create a new node from that coordinate and push it into the stack

            int northX = node.getX() - 1;
            int northY = node.getY();
            if (((northX > -1) && (northX < mHeight)) && ((northY > -1) && (northY < mWidth))) {
                if (maze[northX][northY] == '.' || maze[northX][northY] == 'E') {
                    Node newNode2 = new Node(northX, northY);
                    stack.push(newNode2);
                }
            }

//            Calculate the coordinate of the node to the west
//            Check if the coordinate is in the bound of the maze (no negative numbers, etc)
//            Check if the adjacent node is not yet visited and it is not a wall
//            Create a new node from that coordinate and push it into the stack

            int westX = node.getX();
            int westY = node.getY() - 1;
            if (((westX > -1) && (westX < mHeight)) && ((westY > -1) && (westY < mWidth))) {
                if (maze[westX][westY] == '.' || maze[westX][westY] == 'E') {
                    Node newNode3 = new Node(westX, westY);
                    stack.push(newNode3);
                }
            }
        }
    }

    public int getEggFound() {
        return eggFound;
    }

    // ************************************************************************************
    // ************** Utility method to read maze from user input *************************
    // ************************************************************************************
    public void readMaze() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Height of the maze: ");
            String line = reader.readLine();
            mHeight = Integer.parseInt(line);

            System.out.println("Width of the maze: ");
            line = reader.readLine();
            mWidth = Integer.parseInt(line);
            maze = new char[mHeight][mWidth];

            for (int i = 0; i < mHeight; i++) {
                line = reader.readLine();
                for (int j = 0; j < mWidth; j++) {
                    maze[i][j] = line.charAt(j);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

