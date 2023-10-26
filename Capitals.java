// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  3 – Part 2 Capitals
//  IDE: IntelliJ IDEA

import java.io.File; //import java IO class called File
import java.io.FileNotFoundException; //import FileNotFound exception
import java.util.ArrayList; //import ArrayList
import java.util.Arrays; //import Arrays
import java.util.Random; //import Random
import java.util.Scanner; //import Scanner

public class Capitals{
    public static void main(String[] args) throws FileNotFoundException { //class throws FileNot Found Exception
        ArrayList<String> states = new ArrayList<>(); //Array List of Strings created
        Scanner scan = new Scanner(System.in); //scan Scanner scans for INPUT
        Random rand = new Random(); //rand initialized as new Random
        File file = new File("C:\\Users\\vipad\\IdeaProjects\\DATA STRUCTURES STUFF\\src\\states.txt"); //path name varies from computer to computer, if trying to run you may have to change the path name
        Scanner fileScan = new Scanner(file);
        //Lines 20-21 deal with creating a new file to THAT FILE PATH, therefore to run the code one would need to change the file path
        //Not the IDEAL solution, but better than manually adding them all
        //text file is included with submission
        while(fileScan.hasNext()) states.add(Arrays.toString(fileScan.nextLine().split(",")));
        //Line 25 -- Scans the file, where there is something in the file it adds the contents of the file, split on the comma
        fileScan.close(); //close fileScan
        int count = 0, correct = 0; //count and correct count the amount of times the do-while loop has run and the amount of correct answers, respectively
        String answer; //answer String for comparison
        do{
            int randomInt = rand.nextInt(states.size()-1); //random number based on the size of the ArrayList-1 (for valid indices) is created

            String [] state = states.get(randomInt).replace("[","").replace("]","").split(",");
            //Line 33 puts the state and capital in a String array, removing weird characters, like brackets, with nothing, then splitting them based on the comma
            state[1] = state[1].replaceFirst(" ",""); //replaces the first space (for whatever reason a space was in front of all the capitals) with an empty character
            System.out.println("What is the capital of " + state[0]); //asks question of what the capital of a state is
            answer = scan.nextLine(); //answer is scanned for

            if(state[1].equalsIgnoreCase(answer)){ //if the capital is correct, ignoring the case, the person is correct
                System.out.println("Correct! The capital of "+ state[0] + " is " + state[1]+"\n"); //it is displayed that they are correct
                correct++; //correct count is added upon
            }
            else System.out.println("Sorry, that is incorrect\n"); //else they are wrong
            count++; //then loop count is added upon
        }while(count < 5); //this happens five times (changing this value will allow it to be more times, but 5 seemed like enough

        if(correct > 0) System.out.println("You got " + correct + " capitals correct! Nice work!"); //if they get one or more correct, it is displayed how many were correct
        else System.out.println("That's okay, better luck next time!"); //else they are told to try again.
        scan.close(); //close scan
    }
}
