// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
// Instructor:  Carla McManus
// Assignment: 7-Part-2-Heaps
// IDE: IntelliJ IDEA

import java.util.*;
import static java.lang.System.out; //used for ease of out statements later
public class MinHeap<E extends Comparable<E>>{
    //methods pulled from Heap class in textbook, altered to reflect a min Heap
    private final ArrayList<E> list = new ArrayList<>(); //array list of any arbitrary type (E)
    //IDE also recommended it be final, we'll see how that holds up
    public MinHeap(){} //default constructor, takes in no value

    public MinHeap(E[] objects){ //overloaded constructor takes in an array of any type
        for (E object : objects) add(object); //for-each loop used for efficiency to add to heap
    }

    public void add(E newObject){ //add method, taken from textbook, altered to reflect a min heap
        list.add(newObject); //add to the heap
        int currentIndex = list.size()-1; //the index of the last node of the heap

        while(currentIndex > 0){ //while currentIndex is greater than 0
            int parentIndex = (currentIndex - 1) / 2; //parent index is the (current index - 1) / 2, so if the current index is 10, parent index is 4
            if(list.get(parentIndex).compareTo(
                    list.get(currentIndex)) > 0){ //if the compareTo method yields a value greater than 0 for a compare between the parentIndex and currentIndex -- meaning currentIndex < parentIndex
                E temp = list.get(currentIndex); //temp set to currentIndex
                list.set(currentIndex, list.get(parentIndex)); //the value at the current index is set to the value at the parentIndex
                list.set(parentIndex, temp); //value at the parentIndex is set to the temp value
            }
            else //else
                break; //loop breaks

            currentIndex = parentIndex; //current index is then set to parent index
        }
    } //again, most of this is from the book nearly directly, just modified to be a min heap rather than a max heap

    public E remove(){ //remove method, returns value of any type
        if(list.isEmpty()) return null; //IDE recommended, I agree

        E removedObject = list.get(0); //value of removed object set to the first object in heap
        list.set(0, list.get(list.size()-1)); //list index of 0 is set to the object at the last index of the list
        list.remove(list.size()-1); //value at the final index is removed

        int currentIndex = 0; //currentIndex initialized to 0
        while(currentIndex < list.size()){ //while currentIndex less than the list size
            int leftChildIndex = 2 * currentIndex + 1; //leftChildIndex set to 2 * current + 1 -- so for current = 0; left = 1
            int rightChildIndex = 2 * currentIndex + 2; //rightChildIndex set to 2 * current + 2 -- so for current = 0; right = 2

            if(leftChildIndex >= list.size()) break; //if leftChildIndex > than the list size, loop breaks
            int maxIndex = leftChildIndex; //max Index set to leftChildIndex
            if(rightChildIndex < list.size()){ //if rightChild is less than the list size -- enter block
                if(list.get(rightChildIndex).compareTo( //if compareTo yields value less than 0 between rightChild and maxIndex
                        list.get(maxIndex)) < 0){
                    maxIndex = rightChildIndex; //maxIndex = rightChildIndex
                }
            } //if block swaps which is the maxIndex actually, if right is greater than the max when max is left, right > left
            //Swap if the current node is greater than the maximum
            if (list.get(maxIndex).compareTo(
                    list.get(currentIndex)) < 0) { //swapped maxIndex and currentIndex if max is greater than current
                E temp = list.get(maxIndex); //temp set to object at the maxIndex
                list.set(maxIndex, list.get(currentIndex)); //maxIndex set to object at currentIndex
                list.set(currentIndex, temp); //currentIndex set to stored temp
                currentIndex = maxIndex; //currentIndex = maxIndex
            }
            else //else
                break; //loop breaks
        }
        return removedObject; //returns the removed object
    }
    public int getSize() { //get size method
        return list.size(); //returns size of the list
    }

    public static void main(String[] args){ //main method, driver method
        MinHeap<Integer> heap = new MinHeap<>(); //new MinHeap object named heap
        Scanner scan = new Scanner(System.in); //scan object takes in input
        for(int i = 0; i < 5; i++){ //while i < 5 loop runs
            out.println("Enter number " + (i+1) + ": "); //print statement for ease of user
            heap.add(scan.nextInt()); //add method called with input integer
        }
        int n = heap.getSize(); //n used as a constant size, since the size changes as we remove objects from heap
        String cap = ", "; //cap String used for better looks when printing
        for(int i = 0; i < n; i++){  //while i < n
            if(i == 0) //if i == 0
                out.print("Heap: ");//statement is printed
            else if(i == n-1) cap = ""; //if i == n-1 -> cap set to empty String so last item does not have a comma behind it
            out.print(heap.remove() + cap); //object is removed from the heap and returned
        }
    }
}
