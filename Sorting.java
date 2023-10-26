// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
// Instructor:  Carla McManus
// Assignment: 7-Part-1-Sorting
// IDE: IntelliJ IDEA

import java.util.LinkedList; //import LinkedList
import static java.lang.System.out; //import static System.out for ease of writing print statements

 class Sorting {
     public static void main(String[] args){//main driver method
         LinkedList<Integer> list = new LinkedList<>(); //list set to new LinkedList
         int [] temp = {1009, 21, 3, 55, 2022, 24, 99, 501, 105, 98, 178, 245, 0, 3305, 990, 76, 373, 1010, 642, 777}; //putting all values into an array
         for (int j : temp) list.add(j); //adding all values to LinkedList -- easier than having a large number of list.add(x) statements
         out.println("Unsorted List:"); //print for user
         printList(list); //printList method call, pass list
         mergeSort(list); //mergeSort call, passes list
         out.println("Sorted List:"); //print for user
         printList(list); //printList call, passes list
    }//end main
    public static void printList(LinkedList<Integer> list){ //printList method takes in a list returns void
         int n = list.size(); //n set equal to size of the list
         String cap = ", "; //String cap = ", " -- more obvious as to why later on
         for(int i = 0; i < n; i++){ //for loop used to iterate over all objects in list
             if (i == n - 1) cap = "";//if i == the last item in the list -- cap set to empty string
             out.print(list.get(i) + cap); //print statement concatenates item of list at i and the cap String
         }//end for
         out.println();//print line for user understanding
    } //end printList

     public static void mergeSort(LinkedList<Integer> list){ //mergeSort method, accepts LinkedList under name list
         int n = list.size(); // n set equal to list size for reference later
         if(n > 1){ //if n > 1
             LinkedList<Integer> frontHalf = new LinkedList<>(); //new LinkedList named frontHalf
             for(int i = 0; i < n/2; i++) frontHalf.add(list.get(i)); //for statement fills frontHalf list with first half of the list values
             mergeSort(frontHalf); //recursive call to keep subdividing list until n == 1, pops back for next part

             LinkedList<Integer> backHalf = new LinkedList<>(); //new backHalf LinkedList
             int m = n-n/2; //m set equal to size - size/2 -- so for size 8 m == 4 then for size 4 m == 2 -> helps really if n is odd
             for(int i = 0; i < m; i++) backHalf.add(list.get((n / 2) + i)); //for statement filled with values from half of original list until the last item in original list
             mergeSort(backHalf); //recursive call to mergeSort to further subdivided the back half of the original list

             mergeLists(frontHalf, backHalf,list); //mergeLists method call -- passes all lists
         }//end if
     }//end mergeSort
     public static void mergeLists(LinkedList<Integer> front,LinkedList<Integer> back,LinkedList<Integer> list){ //mergeLists method, accepts 3 linked lists
         //some inspiration taken from the textbook implementation of merge sort, really helped in understanding
         int i = 0, j = 0, k = 0; //integers i,j,k initialized to 0
         while(i < front.size() && j < back.size()) { //while loop used for merging lists
             if (front.get(i) < back.get(j)) list.set(k++, front.get(i++)); //if the item at index i in front list is less than item at index j in back list
             else list.set(k++, back.get(j++)); //main list at k set to back at j (directly compares those two values, since the lists are split versions of "list"
         }//end while
         while (i < front.size()) list.set(k++, front.get(i++)); //while loop iterates until i == length of front side list -> set list at k to front at i
         while (j < back.size()) list.set(k++, back.get(j++)); //while loop iterates until j == length of back side list -> set list at k to back at j
     }//end mergeLists
}//end Sorting class
