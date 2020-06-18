/**
 * The UnSortedClockList class is an extension of the
 * ClockList class with an add method
 *
 * @author Amreen Khandaker
 * @lab-section: 21A
 */

public class UnsortedClockList extends ClockList {
    //default constructor
	public UnsortedClockList() {}

    /**
     * Method to add a new clock to the unsorted linked list
     * @param c: a clock
     */
    public void add(Clock c){
        append(c);
    }
}