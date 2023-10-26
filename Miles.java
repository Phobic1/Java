// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  06-Part-2.2-Miles
//  IDE: IntelliJ IDEA
public class Miles { //Miles class
    public static void main(String[] args){ //main method in Miles class
        float [] miles = {0,10,20,30,40,45,50,55,60,65,70,80,90}; //array of miles values -- some values other than provided ones included (left as a way to see conversions between mph to kph, figured it would be okay to leave in)
        float [] kilometers = new float [miles.length]; //kilometers array of same length as miles array

        for(int i = 0; i < miles.length; i++){ //for loop traverses miles array -> time complexity O(n) since it is a single loop that iterates n times with constant calculation time
            kilometers[i] = miles[i] * 1.6f; //multiplies each index of miles by 1.6 and applies it to matching index in kilometers array
        }//end calculation for loop
        printArrays(miles, kilometers); //call to print arrays method, passes both arrays to method and prints them -- could be solved with 2 calls to one method, preferred to call just once

        System.out.println("""
                
                This program uses two loops
                Loop 1: Calculation time is constant = c, items in array n = 10; T(n) = c * 10 = O(n).
                Loop 2: Print time is constant = c, items in array n = 10; T(n) = c * 10 = O(n) + O(n) = O(n)
                Total time complexity: 2(O(n)) = O(n), meaning O(n) is the worst-case efficiency""");
    } //lines 17-22 were a recommendation by the IDE to insert a text block, that was a good call by the IDE
    public static void printArrays(float [] miles, float [] kilometers){ //print arrays methods, accepts 2 float arrays
        for(int i = 0; i < miles.length; i++){ //for loop traverses both arrays -> time complexity O(n) since it is a single loop that iterates n times with constant print time
            System.out.print(miles[i] + " miles = "+kilometers[i] + " kilometers"); //miles and kilometers at i + end (whatever end is) is printed
            System.out.println(); // line printed at the end of prior print statement
        }//end for
    }//end printArrays method
} //end Miles
