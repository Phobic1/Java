//  Name:	Paden Wood
//  Class:	CS 3305/CRN 85335
//  Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  04–Part–1–Stacks
//  IDE: IntelliJ IDEA


public class Stack {
    public int top_a; //attribute for top_a
    public int top_b; //attribute for top_b
    public int [] stack = new int[16]; //integer array called stack, size 16
    public static int digitsA = 0; //digit counter for all values in A side of array
    public static int digitsB = 0; //digit counter for all values in B side of array

    public Stack(){} //default constructor

    public int pop_a(){ //pop_a... does not really work either
        int retrieve = top_a; //retrieve is set to the top integer
        int count = 1; //count = 1
        for(int i = 0; i < digitsA; i++){
            if(stack[i] == retrieve && count == 1){ //once retrieve is found
                stack[i] = 0; //index where retrieve was found is set to 0
                count--; //count is reduced
                digitsA--; //digits also reduced
            }
            int temp = stack[i+1]; //rest in a section are left-shifted
            stack[i] = temp;
            stack[i+1] = stack[i+digitsA];
        }
        top_a = stack[0]; //top of the stack is set to first index in array
        return retrieve;
    }

    public int pop_b(){
        int retrieve = top_b; //top_b is the popped item
        int count = 1; //count initially set to 1
        for(int i = stack.length-1; i > digitsB; i--){ //for b section
            if(stack[i] == retrieve && count == 1){
                stack[i] = 0; //retrieve index is set to 0
                count--; //count reduced
                digitsB--; //digits reduced
            }
            int temp = stack[i-1]; //moves all elements up
            stack[i-digitsB] = stack[i-1];
            stack[i-1] = temp;
        }
        return retrieve; //retrieve is returned as the popped element
    }

    public void push_a(int n){ //push_a method
        for(int i = 0; i < stack.length * 0.75; i++){ //counts for digits existing
            if(stack[i] != 0 && i >= digitsA -1){
                digitsA++; //if something is not equal to zero and the index has not already been counted, digits is incremented
            }
        }
        if(digitsA == 0){ //if digits is 0
            stack[0] = n; //n is added to the stack
            digitsA++; //digits is incremented
        }
        for(int i = 0; i < digitsA; i++){ //if other digits do not exist, fill them in
            if(stack[i] == 0){ //if stack[i] = 0
                stack[i] = n; //stack[i] = n
            }
        }
        if(digitsA > 1){ //if digits is greater than one
            for(int i = 0; i < digitsA/2;i++){ //the array is mirrored
                int temp = stack[i];
                stack[i] = stack[digitsA-1];
                stack[digitsA-1] = temp;
                if(digitsA % 2 == 0){ //if even all is good
                    break; //loop breaks
                }
                else{
                     temp = stack[digitsA-1]; //else flip again because the last index should be in the middle
                     stack[digitsA-1] = stack[digitsA-2];
                     stack[digitsA-2] = temp;
                }
            } //this is not perfect, I could not for the life of me figure this one out -- it is really close
        }
        top_a = stack[0]; //top_a is set to the first item of the array
    }

    public void push_b(int n){ //the same logic for push_a followed for push_b, still a flawed method nonetheless
        for(int i = stack.length-1; i > stack.length * 0.75; i--){ //counts for digits existing -- counts backward to A's section
            if(stack[i] != 0 && i >= digitsB -1){ //if stack[i] is not 0 or i is greater than or equal to digitsB - 1
                digitsB++; //digits is incremented
            }
        }
        if(digitsB == 0){ //if there are no digits in B
            stack[stack.length-1] = n; //n added to last element of array
            digitsB++; //digits incremented
        }
        for(int i = (int) (stack.length*0.25); i < digitsB; i--){ //B section is scanned for 0's
            if(stack[i] == 0){
                stack[i] = n; //if one is a zero, it is set to n
            }
        }
        if(digitsB > 1){ //if digits > 1
            for(int i = stack.length-1; i > digitsB/2;i--){ //elements are mirrored
                int temp = stack[i];
                stack[i] = stack[digitsB-1];
                stack[digitsB-1] = temp;
                if(digitsB % 2 == 0){ //if even, breaks because all should be flipped
                    break;
                }
                else{
                    temp = stack[digitsB-1]; //else flip again another index down
                    stack[digitsB-1] = stack[digitsB-2];
                    stack[digitsB-2] = temp;
                }
            }
        }
        top_b = stack[stack.length-1]; //top_b is made the last element of the full array
    }

    public boolean is_empty_a(){ //is_empty_a
        boolean isEmptyA = true; //automatically set to true
        for(int i = 0; i < (stack.length*0.75); i++){ //counts upward to B's section of the array
            if(stack[i] != 0){ //if an element does not equal zero
                isEmptyA = false; //isEmpty = false
                break;//loop breaks
            }
        }
        return isEmptyA; //returns isEmptyA
    }

    public boolean is_empty_b(){
        boolean isEmptyB = true; //isEmptyB starts at true
        for(int i = stack.length-1; i > stack.length * 0.75; i--){ //loop counts backward to A's section of the array
            if(stack[i] != 0){ //if an element does not equal zero
                isEmptyB = false; //isEmpty is false
                break; //loop breaks
            }
        }
        return isEmptyB; //return isEmptyB
    }

    public boolean isFull(){ //isFull method checks whole array
        boolean full = true; //set to true by default
        for (int n : stack) { //for each integer in stack
            if (n == 0) { //if one element = 0
                full = false; //full is false
                break; //loop breaks
            }
        }
        return full; //full is returned
    }

    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push_a(7); //pushing values to A
        stack.push_a(9); //pushing to A
        stack.push_a(13); //pushing to A
        stack.push_b(8); //pushing to B
        stack.push_b(10);
        System.out.println("Popping A: " + stack.pop_a() + ", Popping B: " + stack.pop_b() + ", Popping A again: " + stack.pop_a());
        System.out.println("Is A Empty: " + stack.is_empty_a()+ ", B: " + stack.is_empty_b());
        System.out.println("Is the stack full: " + stack.isFull());

    }
}
