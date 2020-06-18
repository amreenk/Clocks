/**
 * The SortedClockList class is an extension of the
 * ClockList class with an add method that adds the nodes
 * in order.
 *
 * @author Amreen Khandaker
 * @lab-section: 21A
 */

public class SortedClockList extends ClockList {
	public void add(Clock c) {
		ClockNode node = new ClockNode(c);
		if(first.next == null) {
			last.next = node;
			last = node;
			length ++;
			return;
		}
	
		ClockNode i = first;
		while(i.next !=null && i.next.data.compareTo(c)<0)
			i = i.next;
		if(i.next == null) {
			last.next = node;
			last = node;
			length++;
		}
		else {
			node.next = i.next;
			i.next = node;
			length++;
		}
	} //add
}
