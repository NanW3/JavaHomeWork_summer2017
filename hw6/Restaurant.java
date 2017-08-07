import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
* A restaurant providing food and drink
*
* @author nwang89
* @version 1
*/

public class Restaurant {

    /**
     * prompts the customer to enter their food selection
     * and their drink selection
     * catch some potantial exceptions
     * @param args the commond line argument
     *
     */
    public static void main(String[] args) {

        String foodFile = args[0];
        String drinkFile = args[1];

        boolean order = false;

        while (!order) {
            try {
                System.out.println("Please enter your food selection"
                    + " and drink selection: ");

                Scanner input = new Scanner(System.in);

                String food = input.nextLine().toLowerCase().trim();
                String drink = input.nextLine().toLowerCase().trim();
                checkOrder(food, drink, foodFile, drinkFile);
                order = true;

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                order = true;

            } catch (FoodAndDrinkNotFoundException e) {
                System.out.println(e.getMessage());

            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());

            } catch (DrinkNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    /**
     * calls checkFood and checkDrink
     * @param food the food that customer orders
     * @param drink the drink that customer orders
     * @param foodFile the file that stores food
     * @param drinkFile the file that stores drinks
     * @throws FoodNotFoundException this food is not provided
     * @throws DrinkNotFoundException this drink is not provided
     * @throws FoodAndDrinkNotFoundException this food and drink
     * is not provided
     * @throws FileNotFoundException file is not found
     *
     */
    public static void checkOrder(String food, String drink,
                                   String foodFile, String drinkFile)
    throws FoodNotFoundException, DrinkNotFoundException,
           FoodAndDrinkNotFoundException, FileNotFoundException {

        boolean hasFood = checkFood(food, foodFile);
        boolean hasDrink = checkDrink(drink, drinkFile);
        if (!hasFood && !hasDrink) {
            throw new FoodAndDrinkNotFoundException("Our food menu"
            + " doesn't have " + food + " and our drink menu doesn't"
            + " have " + drink);
        } else if (!hasFood) {
            throw new FoodNotFoundException("Our food menu"
            + " doesn't have " + food);
        } else if (!hasDrink) {
            throw new DrinkNotFoundException("Our drink menu"
            + " doesn't have " + drink);
        } else {
            System.out.print("Order successful!");
        }
    }

    /**
     * read through the foodFile and check if the food
     * parameter that was passed in exists in the file
     * @param food the food that customer orders
     * @param foodFile the file that stores food
     * @return true if exists and false otherwise.
     * @throws FileNotFoundException file is not found
     */
    public static boolean checkFood(String food, String foodFile)
    throws FileNotFoundException {

        Scanner foodScan = new Scanner(new File(foodFile));

        while (foodScan.hasNext()) {
            String f = foodScan.nextLine();
            if (f.equals(food)) {
                return true;
            }
        }
        foodScan.close();
        return false;
    }
    /**
     * read through the drinkFile and check if the drink
     * parameter that was passed in exists in the file
     * @param drink the drink that customer orders
     * @param drinkFile the file that stores drink
     * @return true if exists and false otherwise.
     * @throws FileNotFoundException file is not found
     */
    public static boolean checkDrink(String drink, String drinkFile)
    throws FileNotFoundException {

        Scanner drinkScan = new Scanner(new File(drinkFile));

        while (drinkScan.hasNext()) {
            String d = drinkScan.nextLine();
            if (d.equals(drink)) {
                return true;
            }
        }
        drinkScan.close();
        return false;
    }

}