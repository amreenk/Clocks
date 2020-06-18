/**
 * IllegalArgument for Clock constructor to throw
 * @author amreen
 *
 */
public class IllegalClockException extends IllegalArgumentException {
   /**
    * Constructor 
    * @param clock - Clock object to be passed to print it's value
    */
   public IllegalClockException(Clock clock) {
      super(clock + " This is not a valid Clock format!");
   }
}