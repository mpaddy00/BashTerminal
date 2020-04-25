
package plannermanager;

/**
 * An exception thrown in the <CODE>PlannerManager</CODE> class to indicate
 * that the
 * integer used as an argument in the class methods is not within the valid
 * range accepted as elements in the set.
 * @author 
 *    Mark Paddy, SBU, 111876646
 * <dt><b>Assignment:</b><dd>
 *    Homework #1 for CSE 214, Fall 2018
 * <dt><b>Date:</b><dd>
 *    August 11, 2018
 */
public class Exceptions {
    public class FullPlannerException extends Exception{
     /**
     * Default constructor for the <CODE>IllegalElementException</CODE> that
     * passes a provided string to the <CODE>Exception</CODE> class constructor.
     * @param message
     *      the message that the object is to contain.
     * <dt><b>Postcondition:</b><dd>
     *    The object is created and contains the default message.
     */
    public FullPlannerException(){}
    public FullPlannerException(String message) {
        super(message);
        }
}
}
