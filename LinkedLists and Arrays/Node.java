import java.util.Arrays;

/**
 * Write a node class suitable for use in a GLArray
 * 
 * Klevi Demo
 * 1/11/16
 *  
 */
public class Node{
    
    /** The three fields required to make a node the first field 
     * will hold the next node in the linked list. The second field 
     * stores the array of elements. The third indicates the 
     * size of the array. 
     */
    
    Node next; //Next node in the list
    Integer[] v; //Java array of Integer elements
    int size; //The size of the array
    
    

    /**
     * Constructor for objects of class Node.
     */
    public Node(int capacity) {
        this.v = new Integer[capacity];
        this.size = 0;
        this.next = null;
     
    }

    /**
     * Turn the array into a string.
     */
    @Override
    public String toString() {
        return Arrays.deepToString(v)
                + (next != null ? " " + next.toString() : "");
    }
}
