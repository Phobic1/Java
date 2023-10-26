// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment: 2 – Part 1 Factorial
//  IDE: IntelliJ IDEA

import java.util.Scanner; //import Scanner
public class Factorial{ //class declaration for class Factorial
    public static void main(String[] args){ //main method
        Scanner scan = new Scanner(System.in); //new scan object of type Scanner created
        System.out.print("Enter a non-negative integer: "); //prompt for input
        long number = scan.nextInt(); //read in input and save as a long
        System.out.println("Factorial of " + number + " is " + factorial(number)); //print statement for result as well as method call passing in the value
    }
    public static long factorial(long n){ //factorial method takes in parameter long n
        if (n == 1) return 1; // of n==1, 1 is returned
        else{ //else
            return n * factorial(n-1); //n * n-1 is returned until 1 is reached
        }
    } //end factorial
} //end class Factorial
