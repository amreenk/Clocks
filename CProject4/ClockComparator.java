import java.util.Comparator;

/**
 * @Discription: This program returns comparator used to order key values in tree map
 * @author amreen
 *
 */
public class ClockComparator implements Comparator<Clock>{
	
	/**
	 * The compare method calls compareTo method from Clock class
	 * @param Clock clockOne
	 * @param Clock clockTwo
	 * @return integer value 1, -1, or 0
	 */
	
	public int compare(Clock clockOne, Clock clockTwo) {		
		return clockOne.compareTo(clockTwo); 	
	}
}
