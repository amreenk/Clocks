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
    protected ClockNode first = new ClockNode(null);
    //last node in the linked list
    protected ClockNode last = first;
    //number of items in the list
    protected int length = 0;

    //default constructor
    public ClockList(){}
    
    /**
     * Method to get the length of the linked list
     */
    public int getLength(){
        return length;
    }

    /**
     * The append method adds a new node to the
     * ClockList
     * @param c: this is a clock object
     */
    public  void append(Clock c){
		ClockNode newNode = new ClockNode(c);		
		ClockNode p = first;
		while(p.next != null) { //goes through list until finds null		
			p = p.next;		
		}		
		p.next = newNode;		
		last = newNode;		
		length++;
    }

	/**
	 * The following method will convert nodes in linked list to String
	 * @return result: string
	 */	
	public String toString() { 		
		ClockNode p = first.next;		
		String result = "";		
		while (p != null) {			
			result += p.data + " ";		
			p = p.next;			
		}		
		return result;
	}
}