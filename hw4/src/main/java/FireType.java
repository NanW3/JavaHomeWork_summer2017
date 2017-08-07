import java.awt.Rectangle;
import java.util.Random;
/**
 * A fire type pokemon
 *
 * @author Farhan Tejani, nwang89
 * @version 2
 */
public abstract class FireType extends Pokemon {

    private int speed;

    /**
     * Constructor
     * @param x The X position of this Fire type
     * @param y The Y position of this Fire type
     * @param bounds The bounding Rectangle
     */
    public FireType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }
    /**
    * @override the move() method in Pokemon class
    * Every time it moves, its level increases by 1
    * its health decreases by 1
    * when it is in its orange quadrant(top-right),
    * it moves more quickly than they do in other area
    * of the map
    */

    @Override
    public void move() {

        int recW = (int) this.getBounds().getWidth();
        int recH = (int) this.getBounds().getHeight();
        int imaW = this.getImage().getIconWidth();
        int imaH = this.getImage().getIconHeight();
        int x = this.getXPos();
        int y = this.getYPos();

        if (x >= recW / 2 && x + imaW <= recW
            && y >= 0 && y <= recH / 2) {
            this.speed = 2;
        } else {
            this.speed = 1;
        }

        Random rand1 = new Random();
        Random rand2 = new Random();

        int pixel = 45;
        pixel *= speed;
        int xPosNew = 0;
        int yPosNew = 0;

        do {
            xPosNew = x + rand1.nextInt(2 * pixel + 1) - pixel;
            yPosNew = y + rand2.nextInt(2 * pixel + 1) - pixel;
        } while (xOutOfBound(xPosNew) || yOutOfBound(yPosNew)
                || (xPosNew == x && yPosNew == y));

        this.setXPos(xPosNew);
        this.setYPos(yPosNew);

        this.increaseLevel(1);
        this.increaseHealth(-1);
    }
    /**
     * @override the canHarmPokemon() method in Pokemon class
     * @param otherPokemon a Pokemon instance
     * @return whether or not the current Pokemon instance
     * can harm an instance of the other Pokemon through combat
     * FireType has a greater chance of harming a GrassType
     * and a lesser chance of harming a WaterType.
     */
    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        Random rand = new Random();
        if (otherPokemon instanceof GrassType) {
            return rand.nextInt(100) < 80;
        }

        if (otherPokemon instanceof WaterType) {
            return rand.nextInt(100) < 20;
        }

        if (otherPokemon instanceof ElectricType) {
            return rand.nextInt(100) < 70;
        }

        return super.canHarmPokemon(otherPokemon);
    }

}
