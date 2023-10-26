// Name:	Paden Wood
// Class:	CS 3305/CRN 85335
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  07-Part-3-Bonus-Trees
//  IDE: IntelliJ IDEA

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Trees { //trees class
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String> list = readFile(); //list set to readFile function
        System.out.println(list); //print out for list
        MorseCodeTree tree = new MorseCodeTree(list); //tree set to new MorseCodeTree
        //for(String s : list) tree.encode(s); //encode called for each list item -- this doesn't work
    }
    public static LinkedList<String> readFile() throws FileNotFoundException { //readFile method
        var path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath(); //var path set to default directory path
        File file = new File(path+"\\morse.txt"); //finds morse.txt
        Scanner scan = new Scanner(file); //scan set to scan the file
        LinkedList<String> list = new LinkedList<>(); //list initialized
        while(scan.hasNext()){
            list.add(scan.next());//each thing found on file added to the list
        }
        scan.close();//close scanner
        return list;//returns full list
    }
}
class MorseCodeTree{ //MorseCodeTree
    Node<String> root = new Node<>("*"); //root Node
    static Node<String> subRoot; //static subRoot Node
    Boolean isNull = false; //isNull set to false
    public MorseCodeTree(LinkedList<String> list){ //MorseCodeTree constructor, accepts a LinkedList
        int index = 0; //index initialized to 0
        int size = list.size();
        while(index < size){ //while list is not empty

            while(!list.get(index).equalsIgnoreCase("NULL")){ //while the String is not "NULL"
                if(root.left == null){ //if Node left of the root is null
                    root.left = new Node<>(list.pop()); //Node left of the root is set to a new node with the element set to the popped list item
                    subRoot = root.left; //subRoot set to the node left of the root
                }
                else { //else
                    subRoot.left = new Node<>(list.pop()); //Node left of the sub-root is set to a new node with the element set to the popped list item
                    subRoot = subRoot.left; //subroot is set to the node to it's left
                }
                index++; //index is iterated
            }
            while(!list.get(index).equalsIgnoreCase("NULL")){ //while list at index is not null
                if(root.right == null){ //if right of root is null
                    root.right = new Node<>(list.pop()); //node at right of root is made a new node with popped value
                    subRoot = root.right; //subRoot set to the root at the right of the root
                }
                else { //else
                    subRoot.right = new Node<>(list.pop()); //new node set to the right of the subroot
                    subRoot = subRoot.right; //subroot set to the new node to its right
                }
                index++;//index iterated
            }
        }
    }

    public String encode(String content){ //encode method -- currently does...nothing
        if (content.equals("NULL")){
            isNull = true;
        }
        return "";
    }
    public String decode(String letters){ //decode method -- currently does nothing either
        return "";
    }
    static class Node<E>{ //node class
        protected E element; //element of arbitrary type
        protected Node<E> left; //node left
        protected Node<E> right; //node right
        public Node(E e){ //constructor takes in object
            this.element = e; //element set to passed object
        }
    }
}
//This is not a finished solution -- hence why the output screenshot makes no sense
//Logic for creating the tree is flawed, but it is nearing completion
//This is a bonus point problem, but the clock for the actual assignment is ticking, so I am submitting it all
//Hopefully the intent behind this code makes sense -- specifically the constructor and use of the Node class as portrayed in the book