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
    static JTextArea unsortedTextArea;
    static JTextArea sortedTextArea;
	
    //constructor
    ClockGUI(String title, int height, int width){       
        setTitle(title);
        setSize(height,width);
        setLocation(500,100);
        createFileMenu(); 	//file menu handler    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Method that creates the File Menu to Open or Quit
     */
    private void createFileMenu() {
		//make "File" in the menu		
		JMenuItem item; //instantiate item		
		JMenuBar menuBar = new JMenuBar();	
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh  = new FileMenuHandler(this); //instantiates from FileMenuHandler class
		
		//make "Open" in menu
		item = new JMenuItem("Open");    
		item.addActionListener(fmh); //processes action event
		fileMenu.add(item);
		fileMenu.addSeparator(); 
		
		//make "Quit" in menu
		item = new JMenuItem("Quit");       		
		item.addActionListener(fmh);		
		fileMenu.add(item);
		
		setJMenuBar(menuBar);		
		menuBar.add(fileMenu);
    }

    /**
     * Method that fills the text area with clocks
     * @param clockList: the clock linked list
     *        myText: the JTextArea to display the results
     */
    public void displayClock(ClockList unsortedClockList, ClockList sortedClockList){
    	setVisible(true);		
		setLayout(new GridLayout(1,2));
		
		unsortedTextArea = new JTextArea();
		String unsortedHeader= "Unsorted\n";		
		unsortedTextArea.append(unsortedHeader);	
		unsortedTextArea.append(unsortedClockList.toString()); //calls toString method to convert ClockList	
		getContentPane().add(unsortedTextArea); //puts content inside frame
		unsortedTextArea.setEditable(false);
		
		sortedTextArea = new JTextArea();
		String sortedHeader="Sorted\n";
		sortedTextArea.append(sortedHeader);	
		sortedTextArea.append(sortedClockList.toString());		
		getContentPane().add(sortedTextArea);			
		sortedTextArea.setEditable(false);
    }
}