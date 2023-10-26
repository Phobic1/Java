// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  06-Part-2.1-Time
//  IDE: IntelliJ IDEA
public class Time {
    public static void main(String[] args){ //main method
        System.out.println(calcTime(100) +"\n"+ timeComplexity(100)+"\n"); //calls to two methods, passing value 100 to both
        System.out.println(calcTime(1000) +"\n"+ timeComplexity(1000)+"\n"); //calls to two methods, passing value 1000 to both
        System.out.println(calcTime(10000) +"\n"+ timeComplexity(10000)+"\n"); //calls to two methods, passing value 10000 to both
        //WARNING: This program can take a while to run, iterating 10,000 * 10,000 * 10,000 = 1,000,000,000,000 times is no easy task
    }//end main
    public static String calcTime(long n){ //timeCalc method, takes in long, returns String
        long time = System.currentTimeMillis(); //long used to store current system time at time of call
        long number = 0; //number set to 0
        for(int i = 0; i < n; i++){ // for loop has complexity O(n)
            for(int j = 0; j < n * n; j++){ //nested loop has complexity O(n)*O(n) or O(n^2)
                number = (number+1) * 2; //random calculation just to give time
            } //end inner for
        }// end outer for -- O(n) * O(n^2) = O(n^3)
        return "Time for "+ n +" items: " + (System.currentTimeMillis() - time) + " milliseconds"; //returns results in form of a String
    } //end calcTime
    public static String timeComplexity(long n){ //timeComplexity method, takes in long, returns String
        return "The time complexity for n = "+ n + " is " + (n * n)*n + " iterations or O(n^3)"; //returns String that calculates the number cubed and includes the determined big O notation
    } //end timeComplexity
}//end Time
