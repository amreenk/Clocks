import java.util.*;

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

public class Project2 {
    public static TextFileInput inputFile;
    public static Clock[] allClocks;
    public static int clockCount;

    public static void main(String [] args){
        UnsortedClockList unsortedList = new UnsortedClockList();
        SortedClockList sortedList = new SortedClockList();
        String myFile = "input.txt";
        inputFile = new TextFileInput(myFile);
        allClocks = new Clock[100];
        clockCount = 0;

        //fills up the allCandles array
        fillArray(inputFile);

        //read from the array and add it to the two linked lists
        for(int i=0; i < clockCount; i++){
            Clock c = allClocks[i];
            unsortedList.add(c);
            sortedList.add(c);
        }

        //now to display the two linked lists
        new ClockGUI(unsortedList, sortedList);
    }

    /**
     *  Method to change the number of clocks and
     *  fill up the clocks details array
     * @param input: the TextFileInput to read the values from
     */
	public static void fillArray(TextFileInput input){
        String line = input.readLine();
        while(line!=null){
            StringTokenizer cTokens = new StringTokenizer(line, ":");
            //only if the line has three arguments
            if(cTokens.countTokens()==3){
                int h = Integer.parseInt(cTokens.nextToken());
                int m = Integer.parseInt(cTokens.nextToken());
                int s = Integer.parseInt(cTokens.nextToken());
                Clock c = new Clock(h, m, s);
                //adds clocks to the array
                allClocks[clockCount++] = c;
            }
            else{
                System.out.println(line + " does not have three tokens");
            }
            line = input.readLine();
        }
    }
    
}
