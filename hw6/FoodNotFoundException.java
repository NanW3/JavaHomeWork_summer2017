/**
* An exception of not findng food
*
* @author nwang89
* @version 1
*/

public class FoodNotFoundException extends Exception {
    /**
    * construct a FoodNotFoundException
    * @param message an error message
    */
    public FoodNotFoundException(String message) {
        super(message);
    }
}