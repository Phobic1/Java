// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
// Instructor:  Carla McManus
// Assignment: 2 – Part 2 Recursion
// IDE: IntelliJ IDEA

import java.util.Scanner; //Import Scanner
import java.util.Arrays; //Import Arrays
public class Recursion{ //class declaration for class Recursion
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //new Scanner object named scan
        System.out.print("Enter the level of recursion: "); //print for input
        int level = scanner.nextInt(); //level to determine how many times program runs
        scanner.close(); //close scanner to mitigate risk of memory leaks
        recursiveText(level, 1);//method call to recursiveText function with the max level and current level
    }
    public static void recursiveText(int level, int currentLevel){ //recursiveText function takes in two integers, one that tracks the levels required and the other that tracks the current level
        String [] space = new String[currentLevel-1]; //create a new String array titled space to allow the progressing indentations, uses current level to determine how many spaces to put ahead of the print statement
        Arrays.fill(space, " "); //fills array with spaces
        if (currentLevel <= level) { //if the current level is less than or equal to the maximum level
            for (String s : space) System.out.print(s); //print out the spaces
            for (int i = currentLevel; i <= currentLevel; i++) {
                System.out.println("This was written by call number " + i + "."); //for loop prints as many times as the current level will allow
            } //since this is before the recursive call the print statements will be in ascending order
            recursiveText(level, currentLevel + 1); //recursive call to the function to increase the current level
            for (String s : space) System.out.print(s); //prints spaces for the "ALSO" calls
            for (int i = currentLevel; i >= currentLevel; i--){ //since this is AFTER the recursive call, statements will be in descending order
                System.out.println("This was ALSO written by call number " + i + "."); //for loops prints as many times as the current level will allow
            }
        }
    }//end recursiveText function
}//end class Recursion
