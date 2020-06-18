
/** 
 * Amreen Khandaker
 * CSI212
 * @author: amreen
 * @lab- section 21A
 * 
 * The main function instantiates the Clock class twice.
 * One of which are sorted and the other one is not.
 *
 * It also instantiates a ClockGUI,
 * where it displays the unsorted and
 * sorted Clock arrays side by side in two columns.
 **/

public class Project3 {
	
    static UnsortedClockList unsortedList = new UnsortedClockList();
    static SortedClockList sortedList = new SortedClockList();
    static ClockGUI cGUI;

    public static void main(String [] args){
        cGUI = new ClockGUI("Clock", 400, 600);
    }
}
