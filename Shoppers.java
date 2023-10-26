//  Name:	Paden Wood
//  Class:	CS 3305/CRN 85335
//  Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  05-Part-2-Shoppers
//  IDE: IntelliJ IDEA

import java.util.*;

public class Shoppers {
    public static void main(String[] args){
        Random rand = new Random(); //new random object called rand -- short for randy, long for ran
        Queue<Customer> checkout1 = new LinkedList<>(); //new Queue object for customers
        Queue<Customer> checkout2 = new LinkedList<>();
        Queue<Customer> checkout3 = new LinkedList<>();
        Queue<Customer> checkout4 = new LinkedList<>();
        Queue<Customer> checkout5 = new LinkedList<>();

        LinkedList<LinkedList<Customer>> customers = new LinkedList<>(); //new linked list for queues
        customers.add((LinkedList<Customer>) checkout1); //putting checkouts in LinkedList Arrays
        customers.add((LinkedList<Customer>) checkout2);
        customers.add((LinkedList<Customer>) checkout3);
        customers.add((LinkedList<Customer>) checkout4);
        customers.add((LinkedList<Customer>) checkout5);

        customers.get(0).add(new Customer()); //generating 5 customers and putting them in the queues
        customers.get(1).add(new Customer());
        customers.get(2).add(new Customer());
        customers.get(3).add(new Customer());
        customers.get(4).add(new Customer());

        //lines 12 - 31 are a VERY manual way to do it, but I could not for the life of me find a good way to make an array of Queues AND access it, so using LinkedLists did the trick
        //not technically part of the directions, but please excuse that, I figured it would probably be fine since LinkedLists and arrays are quite similar

        int totalCustomers =  rand.nextInt(21); //total customers is a value between 1 and 20 inclusive
        while(totalCustomers > 0){
            printQueue(customers); //send customers queue list to be printed
            Customer newCustomer = new Customer(); //generate new customer
            //lines 39, 44,47,50,and 53 compare to see what the lowest is, then the customer gets added to that queue

            if(customers.get(0).size() == 0 && customers.get(1).size() == 0 && customers.get(2).size() == 0 && customers.get(3).size() == 0 && customers.get(4).size() == 0){
             customers.get(0).add(newCustomer); //if all sizes are 0, the first element goes to the first queue
            }
            else if(customers.get(0).size() == customers.get(4).size() && customers.get(0).size() == customers.get(1).size() && customers.get(0).size() == customers.get(2).size()&& customers.get(0).size() == customers.get(3).size()){
                customers.get(rand.nextInt(5)).add(newCustomer); //if all are equal, then customer is put in random queue
            }
            else if(customers.get(0).size() < customers.get(1).size() || customers.get(0).size() < customers.get(2).size() || customers.get(0).size() < customers.get(3).size() || customers.get(0).size() < customers.get(4).size()){
                customers.get(0).add(newCustomer); //if the first queue has the least amount of people, the person goes to the first queue
            }
            else if(customers.get(1).size() < customers.get(0).size() || customers.get(1).size() < customers.get(2).size() || customers.get(1).size() < customers.get(3).size() || customers.get(1).size() < customers.get(4).size()){
                customers.get(1).add(newCustomer); //if the second queue has the least amount of people, the person goes to the second queue
            }
            else if(customers.get(2).size() < customers.get(0).size() || customers.get(2).size() < customers.get(1).size() || customers.get(2).size() < customers.get(3).size() || customers.get(2).size() < customers.get(4).size()){
                customers.get(2).add(newCustomer); //if the third queue has the least amount of people, the person goes to the third queue
            }
            else if(customers.get(3).size() < customers.get(0).size() || customers.get(3).size() < customers.get(1).size() || customers.get(3).size() < customers.get(2).size() || customers.get(3).size() < customers.get(4).size()){
                customers.get(3).add(newCustomer); //if the fourth queue has the least amount of people, the person goes to the fourth queue
            }else customers.get(4).add(newCustomer); //else they go to the fifth queue
            System.out.println("<--------------------------->"); //line to break up each print (looks better)
            totalCustomers--; //total customers reduced by 1
        } //while ends
        System.out.println("<-------------- Checking Out ------------->"); //line to separate filling and checkouts
        do{ //do-while loop
            checkOut(customers); //calls checkOut method, passing customers to the method
        }while(customers.size() > 1);  //while the size of customers list is > 1
    }//end main
    public static void printQueue(LinkedList<LinkedList<Customer>> customers){ //printQueue method, accepts LinkedList of Queues of Customers
        for(int i = 0; i < customers.size(); i++){ //for i < customers.size() which is equal to the amount of queues (5)
            System.out.println("Checkout aisle " + (i+1) + ": "); //Checkout aisle is printed -- i+1 because legal indices are from 0-4, so by adding one we count in not-program
            for(int j = 0; j < customers.get(i).size(); j++){ //nested for keeps track of individual queues at i, which would be like 0,1,2,3,4 -- tracks which queue is being printed
                String end = ""; //end String used for better looks
                if(j != customers.get(i).size()-1){ //if j != to the last index
                    end = ", "; //end is a comma
                }
                System.out.print(customers.get(i).get(j).getCustomerID() + end); //prints each element, getting them first at i (respective Queue), then j (respective index in queue), adds end (for looks)
            }
            System.out.println(); //print line when done
        }
        System.out.println(); //print line when both for loops are complete
    }//end printQueue
    public static void checkOut(LinkedList<LinkedList<Customer>> customers){ //checkOut method accepts LinkedList of Queues of Customers
        Random rand = new Random(); //random used for deciding random queue to "check out"
        int randomCheckout = rand.nextInt(5); //randomCheckout integer set to random number from [0,5) (5 exclusive)
        LinkedList<Customer> aisles = customers.get(randomCheckout); //the aisle being accessed is set to the aisle at the randomCheckout index
        if(aisles.size() == 0){ //if aisle size == 0, meaning the aisle is already empty, method returns
            return;
        }else{
            Thread t1 = new Thread(aisles.getFirst()); //else the thread runs the first Customer in the aisle
            t1.start(); //thread is begun
            if(t1.isAlive()){ //if the thread is alive
                customers.get(randomCheckout).pop(); //the Customer is popped, removing them from the line
            }
        }
        printQueue(customers); //queue is re-printed
    }//end checkOut
}//end Shoppers

class Customer implements Runnable{ //customer class implements Runnable (Threads used in static checkOut method in Shoppers class
    private int customerID; //customerID used to show different customers
    private static int nextCustomerID = 100; //static nextCustomerID used to change the ID from customer to customer
    private int time; //time used to determine how long thread will run for

    public Customer(){ //Customer constructor
        Random rand = new Random(); //new Random named rand
        this.customerID = nextCustomerID; //customerID is set to the next customerID
        nextCustomerID++; //nextCustomerID is iterated, since it is static, the next time a customer is instantiated the ID will be the last customer's plus 1
        this.time = rand.nextInt(250); //time is set to a random integer, [0,250) milliseconds
    }//end Customer constructor

    public int getCustomerID(){ //getCustomerID method
        return customerID; //returns customerID
    } //end getCustomerID

    public void run(){ //run method returns void
        try{ //try catch block for RuntimeException
            Thread.sleep(time); //thread sleeps for the time it takes, customer-dependent
        }catch(InterruptedException e){ //if an exception is caught
            throw new RuntimeException(e); //message is printed
        }
    } //end run
} //end Customer