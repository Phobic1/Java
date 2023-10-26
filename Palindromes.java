// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  04-Part-2-Palindromes
//  IDE: IntelliJ IDEA

import java.util.Scanner;
import java.util.Stack;

public class Palindromes {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in); //scan takes input
        System.out.println("Enter a word:"); //prompt for input
        String input = scan.nextLine(); //scan for input
        boolean isPalindrome = isPalindrome(input); //input is sent to isPalindrome method, passing the input along

        if(isPalindrome){ //if isPalindrome comes back true
            System.out.println(input + " is a palindrome!"); //word printed is declared a palindrome
        }
        else System.out.println(input + " is not a palindrome..."); //else it is not declared a palindrome
        scan.close(); //close scan
    }
    public static boolean isPalindrome(String s){ //isPalindrome method, returns boolean, accepts a String
        boolean isPalindrome = false; //isPalindrome initialized to false (innocent until proven guilty)
        Stack<Character> word = new Stack<>(); //new stack for word
        Stack<Character> temp = new Stack<>(); //new temp stack
        Stack<Character> backward = new Stack<>(); //new backward stack

        for(int i = 0; i < s.length(); i++){ //for i < length of string
            word.push(s.charAt(i)); //push character at i onto word stack
            temp.push(s.charAt(i)); //as well as push the same character to the temp stack
        }
        for(int j = 0; j < word.size(); j++){ //based on the size of the word
            backward.push(temp.pop()); //push the popped item from the temp stack to the backward stack
        }
        int count = 0; //count initialized at 0
        for(int k = 0; k < s.length(); k++){
            if(backward.pop().equals(word.pop())){ //if popped character on backward is equal to popped character in word are equal
                count++; //count is iterated
            }
            else break; //else the loop breaks
            if(count == s.length()){ //if count is equal to the length of the string (meaning all characters are equal forward as they are backward
                isPalindrome = true; //isPalindrome is set to true
            }
        }
        return isPalindrome; //return isPalindrome
    }
}
