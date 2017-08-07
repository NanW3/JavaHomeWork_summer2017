/**
* An exception of not findng drink
*
* @author nwang89
* @version 1
*/

public class DrinkNotFoundException extends Exception {
    /**
    * construct a DrinkNotFoundException
    * @param message an error message
    */
    public DrinkNotFoundException(String message) {
        super(message);
    }
}