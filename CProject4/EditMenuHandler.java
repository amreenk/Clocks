import javax.swing.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * The EditMenuHandler class implements the ActionListener
 * class that handles the menu options "Search" by
 * completing the appropriate actions.
 * 
 * @author amreen
 *
 */
public class EditMenuHandler implements ActionListener {	
	//EditMenuHandler adopts attributes of ActionListener class hierarchy	
	ClockGUI jframe;	
	static  UnsortedClockList temp = new UnsortedClockList();
	//constructor
	public EditMenuHandler (ClockGUI jf) {	   
		jframe= jf;    
   }
	
	/**
	 * The following method will set up action events for Search in GUI
	 * @param ActionEvent event
	 * @return void
	 */
   
   public void actionPerformed(ActionEvent event) {	   
      String menuName= event.getActionCommand();     
      //prompt user for hour input    
      while(true) { //loops user input     
    	  if (menuName.equals("Search")) {   	  
    		  String searchFor = JOptionPane.showInputDialog(null, "Enter an hour value: ");   		  
    		  //range of input is 0-23  		  
			  if(Integer.parseInt(searchFor) < 0 || Integer.parseInt(searchFor) > 23) {				  
				  searchFor = JOptionPane.showInputDialog(null, "Invalid input!");				  
			  }   	  
    		  try {   		  
    			  find(searchFor);    			  
    			  break;   		  
    			  }   	  
    		  catch(NumberFormatException nfe){ //throws exception if input is not a number   		  
    			  JOptionPane.showMessageDialog(null, "Invalid input!");   		  
    		  } 
      	}//if statement   
      }//while loop     
   }//actionPerformed
   
   /**
	 * The following method will compare user input to values of the treemap
	 * @param String inputHour
	 * @return void
	 */
   
   public void find(String inputHour) {	   
	   //use iterator to find key values Clocks and put into map me	   
	   Set set = Project4.treeMap.entrySet(); 	   
	   Iterator i = set.iterator(); 	   
	   Map.Entry <Clock, Integer > me;	   
	   //loop through map to find values at or below input
	   while(i.hasNext()) { 		   
	      me = (Map.Entry)i.next(); 	      
	      if(me.getValue() <= Integer.parseInt(inputHour)) temp.add(me.getKey());    	   	  	    	  
	   }//while loop	   
	   //pass temp map into method from ClockGUI class	   
	   jframe.displaySearched(temp);      
   }//find()
}//EditMenuHandler
