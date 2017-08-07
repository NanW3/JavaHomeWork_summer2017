/**
* An exception of not findng food and drink
*
* @author nwang89
* @version 1
*/

public class FoodAndDrinkNotFoundException extends Exception {
    /**
    * construct a FoodAndDrinkNotFoundException
    * @param message an error message
    */
    public FoodAndDrinkNotFoundException(String message) {
        super(message);
    }
}