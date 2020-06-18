/**
 * The ClockNode class allows the user to create
 * a node with data which is clock and a pointer to
 * the next clock
 *
 * @author Amreen Khandaker
 * @lab-section: 21A
 */

public class ClockNode {
    protected Clock data;
    protected ClockNode next;

    public ClockNode(Clock c){
        data = c;
        next = null;
    }
}