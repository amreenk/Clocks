/**
 * The SortedClockList class is an extension of the
 * ClockList class with an add method that adds the nodes
 * in order.
 *
 * @author Amreen Khandaker
 * @lab-section: 21A
 */

public class SortedClockList extends ClockList {
	//default constructor
	public SortedClockList() {}

    /**
     * Method to add a new node in order in the sorted list
     * @param c: a new clock
     */
    public void add(Clock c){      
    	ClockNode newNode = new ClockNode(c);		
		ClockNode previous = first;		
		ClockNode current = first.next;		
		while(current != null && newNode.data.compareTo(current.data)>=0) { //calls compareTo to have integer value			
			previous = previous.next;			
			current = current.next;		
		}		
		newNode.next = current; //resets current node to the next one		
		previous.next = newNode;		
		if(current == null)			
			last = newNode; //implements additional node at end of list		
		length++; 
    }
}
