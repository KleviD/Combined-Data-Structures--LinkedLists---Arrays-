/**
 * 
 * A GLArray class to hold the static methods. 
 *
 * Klevi Demo
 * 1/11/16
 */
public class GLArray {

    /**
     * length: takes in a node and returns the length of the GLArray. This is
     * the length of the actual elements that have been added to the array, not
     * including any additional space that has been allocated, but not yet used.
     * 
     * Returns the length of the node inserted.
     */
    public static int length(Node node) {
        if (node == null)
            return 0;
        return node.size + length(node.next);
    }

    
    /**
     * get: takes in a node and an int index, and returns the value in the GLArray
     *  corresponding to that index. 
     *
     * Returns the element accessed through the index parameter. 
     */
    public static Integer get(Node node, int index) {
        // Fail if a null node is reached or index is invalid.
        if (node == null || index < 0)
            throw new IndexOutOfBoundsException();
        // Fail if the index should be in this node, but it's empty.
        if (index >= node.size && index < node.v.length)
            throw new IndexOutOfBoundsException();
        // Return the index if it is in this node.
        if (index < node.size)
            return node.v[index];
                
        return get(node.next, index - node.size);
    }

   
     /**
     * add: takes in a node and a Integer and adds it to the end of the GLArray,
     * similar to adding to an ArrayList. If the last Java array is full,
     * it allocates another node and links it on to the end of the GLArray
     */
    public static void add(Node node, Integer n) {
        if (node.size < node.v.length) {
            node.v[node.size++] = n;
        } else { // Node full.
            if (node.next == null) { // Add a new empty node.
                node.next = new Node(node.v.length * 2);
            }
            add(node.next, n);
        }
    }
    
    /**
     *   Testing methods 
     */

    public static void main(String[] args) {
        // Create a GLArray.
        Node gla = new Node(1);

        System.out.println("Length of empty GLArray: " + length(gla));  // Testing an empty GLArray length
        System.out.println("Empty GLArray: " + gla.toString()); //Testing the toString on an empty GLArray
        System.out.println();

        System.out.println("Adding to the empty GLArray...");
        add(gla, 99);  //Adding to the empty GlArray
        System.out.println("GLArray: " + gla.toString()); //ToString on the array with one element
        System.out.println("Length: " + length(gla)); //length of the array with one element
        System.out.println();

        System.out.println("Adding to a full GLArray...");
        add(gla, 45);  //adding to a full glarray
        System.out.println("GLArray: " + gla.toString()); //toString on a full glarray
        System.out.println("Length: " + length(gla)); //length of a full glarray
        System.out.println();

        System.out.println("Adding several elements...");
        add(gla, 21); //adding multiple elemetns
        add(gla, 12); // ""
        add(gla, 0); //  ""
        System.out.println("GLArray: " + gla.toString());
        System.out.println("Length: " + length(gla));
        System.out.println();

        System.out.println("Get index 0: " + get(gla, 0)); //get method on the array with two different indexes(0,3).
        System.out.println("Get index 3: " + get(gla, 3));  
       
    }

   
}

