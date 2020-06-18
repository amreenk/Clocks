import javax.swing.*;
import java.awt.event.*;
import java.util.StringTokenizer;

/**
 * The FileMenuHandler class implements the ActionListener
 * class that handles the menu options "Open" and "Quit" by
 * completing the appropriate actions.
 *
 * @author Amreen Khandaker
 * @lab-section: 21A
 */

public class FileMenuHandler implements ActionListener {
	//FileMenuHandler adopts attributes of ActionListener class hierarchy
	ClockGUI jframe;	
	static SortedClockList sortedList = new SortedClockList(); 	
	static UnsortedClockList unsortedList = new UnsortedClockList();
   
	//constructor
	public FileMenuHandler (ClockGUI jf) {
		jframe = jf;
   
	}
	
	/**
	 * The following method will set up action events in GUI
	 * @param ActionEvent event
	 * @return result: void
	 */
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
        	openFile();
        }
        else if (menuName.equals("Quit")) {
            System.out.println("Bye Bye");
            System.exit(0);
        }
    } //actionPerformed

    /**
     * Method that opens the file chosen by the "Open" option in the menuBar
     */
    private void openFile(){
    	JFileChooser chooser;     
    	int status;     
    	chooser = new JFileChooser("./"); //start with current directory (root directory of project 3)      
    	status = chooser.showOpenDialog(null);      
    	if (status == JFileChooser.APPROVE_OPTION)     		
    		readFile(chooser.getSelectedFile().getName());   		
    		jframe.displayClock(unsortedList, Project4.treeMap);
    }

    /**
     * Method to read the file and fill the unsorted candle list and the
     * sorted candle list
     * @param myFile
     */
    private void readFile(String myFile){
        TextFileInput inputFile = new TextFileInput(myFile);
        String line = inputFile.readLine();
        while(line != null) {			
			StringTokenizer token = new StringTokenizer(line, ":");			
			if (token.countTokens()<3) 				
				System.out.println(line);			
			else {				
				//catches illegal argument exceptions
				try {					
					//parse tokens into integers and new creates Clock object					
					Clock c = new Clock(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()));					
					sortedList.add(c); //puts object into linked list				
					unsortedList.add(c);
					Project4.treeMap.put(c, c.getHours()); //puts Clock and Integer values into treeMap from Project4 class
				}
				catch(IllegalClockException e){				
					//prints exception message declared in Clock class to console	
					System.out.println(e.getMessage() + ": " + line);					
				}//catch			
			}//else
			line = inputFile.readLine();
        }//while loop
    }//readFile()   
}//FileMenuHandler class