//  Name:	Paden Wood
//  Class:	CS 3305/CRN 85335
//  Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  05-Part-1-Queues
//  IDE: IntelliJ IDEA

import java.util.*;

public class Queues {
    public static void main(String[] args) {
        LinkedList<String> chores = new LinkedList<>(); //new LinkedList object
        int choice; //choice initialized as an integer
        Scanner scan = new Scanner(System.in); //scan initialized
        do {
            System.out.println("Chore List: " + removeBrackets(chores) + "\n1. Add a chore\n2. Complete a chore\n3. Remove a chore\n4. Exit"); //print menu
            System.out.print("Choice: "); //print to prompt for choice
            choice = scan.nextInt(); //scan for input

            switch (choice) { //switch on choice
                case 1 -> {
                    System.out.println("What would you like to add: "); //case 1 allows to add an item to the list
                    String temp = scan.nextLine(); //temporary String scanned for twice to allow for it to actually be scanned for
                    temp = scan.nextLine();
                    System.out.println("What is the priority of the chore: "); //prompt for priority
                    int temp1 = scan.nextInt(); //scan for priority

                    if(chores.size() < temp1){ //if the size is less than the priority
                        chores.addLast(temp); //the item is just sent to the last place
                    }
                    else chores.add(temp1-1,temp); //else the priority is set to the input priority minus 1, so 1 would be 0 as an index

                    System.out.println("Chore added.\n"); //print to show operation complete
                }
                case 2 -> {
                    System.out.println("Have you completed " + chores.peek()  +"? (Y/N) : "); //prompt for if completed chore
                    String answer = scan.nextLine(); //two scans to ensure it is scanned for
                    answer = scan.nextLine();
                    if(answer.equalsIgnoreCase("Y")){ //if the answer is yes
                        System.out.println("Congratulations on completing " + chores.pop() + "!\n"); //chore is popped and message is printed
                    }
                    else System.out.println("Sorry, please complete this chore before moving on.\n"); //else nothing happens
                }
                case 3 -> {
                    System.out.println("Enter chore: "); //prompt for removed chore
                    String temp = scan.nextLine(); //scan twice for same issue as cases 1 and 2
                    temp = scan.nextLine();
                    boolean chore = false; //chore boolean set to false

                    for(String s : chores){ //for-each loop
                        if (s.equalsIgnoreCase(temp)) { //if the string == entered chore to remove
                            chore = true; //chore is true
                            break; //loop terminates
                        }
                    }
                    if(chore){ //if chore is true
                        chores.remove(temp); //chore is removed
                        System.out.println(temp + " removed from chore list.\n"); //statement of confirmation printed
                    }
                    else System.out.println(temp + " is not in the chore list.\n"); //else the chore was not found and that is printed
                }
                case 4 -> System.out.println("Good Work!"); //case 4 prints good work and terminates do-while loop
                default -> System.out.println("Invalid input, try again.\n"); //and in the case of an invalid input, that is also stated
            }
        } while (choice != 4); //do-while runs whole choice is not 4
        scan.close(); //scan closed
    }
    public static String removeBrackets(LinkedList<String> q) { //method used to remove brackets when trying to print -- developed prior to using single print statement and just left here for convenience
        return q.toString().replace("[", "").replace("]", ""); //returns the text without the brackets by replacing them with empty characters
    }

}
