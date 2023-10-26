// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  3 – Part 1 Iterator
//  IDE: IntelliJ IDEA

import java.util.LinkedList; //import Linked List utility
public class LinkedListIterator {
    static LinkedList<Integer> list = new LinkedList<>(); //new Linked List declared in class
    public static void main(String[] args){
        list.add(1); //adding values to the Linked List
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        removeRepetitions(); //call to removeRepetitions to get rid of repeat values
        //list now looks like [1,2,3,4,5,6,7]
        printRange(2,5); //calls to printRange method with passed values
        System.out.println(); //printed lines for neatness :)
        printRange(2,78);//calls to printRange method with passed values
        System.out.println();
        printRange(2,1);//calls to printRange method with passed values
        System.out.println();
        printRange(8,5);//calls to printRange method with passed values
    }

    public static void printRange(int x, int y){ //printRange method, takes in two integers, returns void
        int count = 0; //count initialized to 0
        System.out.print("List " + list); //print statement to show what the list looks like
        for (Integer integer : list){ //for-each to iterate through the list
            if ((integer >= x && integer < y) || (y < x &&  x <= integer)){ //if the current number is greater than or equal to x and less than y OR y is less than x and x is less than or equal to current value
                count++; //count is iterated
                if(count == 1) System.out.print("\n\tprints  "); //if count == 1 we print "prints"
                System.out.print(integer + " "); //and the number is printed from x to y, x inclusive y exclusive
            } //end if
        } //end for
    } //end print range

    public static void removeRepetitions(){ //removeRepetitions method, takes in no parameters and returns void
        int p, q = 0; //two new variables p and q, q initialized to 0
        for(int i = 0; i < list.size(); i++){ //for loop to iterate through the list
            p = list.get(i); //p is set to the current value in the list
            if(i < list.size()-1){ //if i is less than list size-1 (available indices), enter if block
                q = p; //q is set equal to p
                p = list.get(i++); //and p is set to the next number
            }
            if(p == q) list.remove(q); //if p and q are equal (meaning they are the same), q is removed
        }
    }//end removeRepetitions
}//end Class
