import java.awt.GridLayout;
import javax.swing.*;

/**
 * The ClockGUI class allows the user to display
 * the results of Clock linked lists.
 *
 * @author Amreen Khandaker
 * @lab-section: 21A
 */

public class ClockGUI extends JFrame {
    //constructor
    ClockGUI(UnsortedClockList clockList1, SortedClockList clockList2){
        super();
        setTitle("Clock");
        setSize(400,200);
        setLocation(100,100);
        setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JTextArea textAreaLeft = new JTextArea(20,20);
        JTextArea textAreaRight = new JTextArea(20,20);
        textAreaLeft.setEditable(false);
        textAreaRight.setEditable(false);

        getContentPane().add(textAreaLeft);
        getContentPane().add(textAreaRight);
        textAreaLeft.setText("Unsorted Clock\n");
        textAreaRight.setText("Sorted Clock\n");

        pack();
        setVisible(true);

        displayClock(clockList1, textAreaLeft);
        displayClock(clockList2, textAreaRight);
    }


    /**
     * Method that fills the text area with clocks
     * @param clockList: the clock linked list
     *        myText: the JTextArea to display the results
     */
    public static void displayClock(ClockList clockList, JTextArea myText){
        ClockNode current = clockList.first.next;
        while(current!=null){
            myText.append(current.data + "\n");
            current= current.next;
        }
    }

//
}