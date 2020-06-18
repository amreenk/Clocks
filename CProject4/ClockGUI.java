import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.*;

/**
 * The ClockGUI class allows the user to display
 * the results of Clock linked lists and sorted Treemap.
 *
 * @author Amreen Khandaker
 * @lab-section: 21A
 */

public class ClockGUI extends JFrame {
    static JTextArea unsortedTextArea;
    static JTextArea sortedTextArea;
    static JTextArea searchedText;
	
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
     * 
     * Method that creates the File Menu to Open or Quit
     * creates Edit Menu to search
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
		
		//make "Edit" MenuBar		
		JMenu editMenu = new JMenu("Edit");		
		EditMenuHandler emh = new EditMenuHandler(this);			      
		item = new JMenuItem("Search"); //implement "Search"			      
		item.addActionListener(emh);			      
		editMenu.add(item);			    
		menuBar.add(editMenu);			    
		setJMenuBar(menuBar);
    }

    /**
     * Method that fills the text area with clocks
     * @param clockList: the clock linked list
     *        myText: the JTextArea to display the results
     */
    public void displayClock(ClockList unsortedList, TreeMap <Clock, Integer> sortedMap){
    	setVisible(true);		
		setLayout(new GridLayout(1,2));
		
		unsortedTextArea = new JTextArea();
		String unsortedHeader= "Unsorted\n";		
		unsortedTextArea.append(unsortedHeader);	
		unsortedTextArea.append(unsortedList.toString()); //calls toString method to convert ClockList	
		getContentPane().add(unsortedTextArea); //puts content inside frame
		unsortedTextArea.setEditable(false);
		
		sortedTextArea = new JTextArea();
		String sortedHeader="Sorted\n";
		sortedTextArea.append(sortedHeader);	
		
		//use iterator to put key values Clocks into sortedPane JTextArea		
		Set set = sortedMap.keySet(); 	
		   Iterator i = set.iterator(); 		   
		   Clock me;	   
		   while(i.hasNext()) { 		   
			   me = (Clock)i.next(); 
			   sortedTextArea.append(me.toString()); //convert Clock me to string for sortedPane
		   }
	
		//sortedTextArea.append(sortedClockList.toString());		
		getContentPane().add(sortedTextArea);			
		sortedTextArea.setEditable(false);
    }
	/**
	 * The following method will take the passed list (from user input) and display in the GUI
	 * @param UnsortedClock searchedFor
	 * @return void
	 */
	
	public void displaySearched(UnsortedClockList searchedFor) {		
		getContentPane().removeAll();		
		setVisible(true);		
		setLayout(new GridLayout(1,1));		
		searchedText= new JTextArea();		
		String searchedHeader= "Searched\n";		
		searchedText.append(searchedHeader);	
		searchedText.append(searchedFor.toString());		
		getContentPane().add(searchedText);	
		searchedText.setEditable(false);		
	}   
}