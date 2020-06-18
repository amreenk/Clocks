
/**
 * 
 * @author Amreen Khandaker
 * @lab-section 21A
 */

public class Clock {
	private int hours, minutes, seconds;

	public Clock(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		if(hours > 23 || minutes > 59 || seconds > 59) throw new IllegalClockException(this);
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

   public void setMinutes(int minutes) {
       this.minutes = minutes;
   }

   public void setSeconds(int seconds) {
	   this.seconds = seconds;
   }

   public int getHours() {
      return hours;
   }

   public int getMinutes() {
      return minutes;
   }

   public int getSeconds() {
      return seconds;
   }
    
   /**
    * A compareTo method added to compare between hours, minutes, and seconds.
    * For clocks hours can be same while minutes and seconds can differ,
    * so  this method compares them to differentiate the clocks.
    */
   public int compareTo(Clock other) {
	   if(this.hours < other.hours) {
		   return -1;
	   }
	   if(this.hours > other.hours) {
		   return 1;
	   }
	   if(this.hours == other.hours && this.minutes < other.minutes) {
		   return -1;
	   }
		
	   if(this.hours == other.hours && this.minutes > other.minutes) {
		   return 1;
	   }
		
	   if(this.hours == other.hours && this.minutes == other.minutes && this.seconds < other.seconds) {
		   return -1;
	   }
		
	   if(this.hours == other.hours && this.minutes == other.minutes && this.seconds > other.seconds) {
		   return 1;
	   }
	   if(this.hours == other.hours && this.minutes == other.minutes && this.seconds == other.seconds) {
		   return 0;
	   }
	   return 1;
   }//compareTo
   
	//overrides toString method with returning file info
	@Override
	public String toString() { 
	   return "\n" + hours + ":" + minutes + ":" + seconds + "\n";
	}
}//Clock