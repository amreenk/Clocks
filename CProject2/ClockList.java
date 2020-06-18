/**
 * The ClockList class allows the user to create a
 * linked list of clocks comprising of a first node, a
 * last node and the length of a clockList.
 * It has an append method and a get method for length.
 *
 * @author Amreen Khandaker
 * @lab-section: 21A
 */

public abstract class ClockList {
    //first node in linked list is a dummy node
    protected ClockNode first;
    //last node in the linked list
    protected ClockNode last;
    //number of items in the list
    protected int length;

    //constructor
    public ClockList(){
        first = new ClockNode(null);
        last = first;
        length = 0;
    }

    /**
     * The append method adds a new node to the
     * ClockList
     * @param c: this is a clock object
     */
    public  void append(Clock c){
        ClockNode newNode = new ClockNode(c);
        last.next = newNode;
        last = newNode;
        length++;
    }

    /**
     * Method to get the length of the linked list
     */
    public int getLength(){
        return length;
    }

}