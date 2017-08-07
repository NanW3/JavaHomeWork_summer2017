import java.util.Random;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Graphics;
/**
 * The abstract Pokemon for the PokeBattle Simulation
 *
 * @author Farhan Tejani, nwang89
 * @version 2
 */
public abstract class Pokemon {

    private Rectangle bounds;
    private int xPos;
    private int yPos;
    private ImageIcon image;
    private int level = 0;
    private int health = 200;

    /**
     * Constructor
     *
     * Represents a Pokemon in the PokeWorld. Each Pokemon
     * has a location in the world and attributes which help
     * it reproduce and thrive. The constructor makes sure
     * the pokemon is not out of bound.
     * @param xPos The X position of this Pokemon
     * @param yPos The Y position of this Pokemon
     * @param bounds The boundaries of the PokeWorld where
     *               the Pokemon can exist
     */
    public Pokemon(int xPos, int yPos, Rectangle bounds) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.bounds = bounds;

        if (this.xOutOfBound(xPos)) {
            this.xPos = (int) this.bounds.getWidth() - 90;
        }

        if (this.yOutOfBound(yPos)) {
            this.yPos = (int) this.bounds.getHeight() - 90;
        }

    }
    /**
     *
     * @param x the x positon
     * @return true if x is out of bound otherwise false
     */
    public boolean xOutOfBound(int x) {
        int imaW = 90;
        int recW = (int) this.bounds.getWidth();

        return x > recW - imaW || x < 0;
    }

    /**
     *
     * @param y the y positon
     * @return true if y is out of bound otherwise false
     */
    public boolean yOutOfBound(int y) {
        int imaH = 90;
        int recH = (int) this.bounds.getHeight();

        return y > recH - imaH || y < 0;

    }

    /**
     * @return the X position of this Pokemon
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * @return the Y position of this Pokemon
     */
    public int getYPos() {
        return yPos;
    }
    /**
    * set the x postion to parameter x
    * @param x the x position
    */
    public void setXPos(int x) {
        this.xPos = x;
    }
    /**
    * set the y postion to parameter y
    * @param y the y position
    */
    public void setYPos(int y) {
        this.yPos = y;
    }

    /**
     * @return the bounding rectangle of the PokeWorld
     *             that this Pokemon exists in
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * @return the level of this Pokemon
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the health of this Pokemon
     */
    public int getHealth() {
        return health;
    }

    /**
     * increase the level by num
     * @param num an integer
     */
    public void increaseLevel(int num) {
        this.level += num;
    }
    /**
     * increase the health by num
     * @param num an integer
     */
    public void increaseHealth(int num) {
        this.health += num;
    }
    /**
     * @return the image of this Pokemon
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
    * Sets the image attribute for this pokemon
    * @param image the ImageIcon to use to represent this Pokemon
    */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * Should draw the Pokemon at its location.
     * @param g Graphics object for drawing use
     */
    public void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
    /**
     * Move the Pokemon instance in a random manner
     * Every time it moves its level should increase and
     * its health should decrease
     * make sure instance stays within the bounds of
     * Pokemon world
     */
    public void move() {
        Random rand1 = new Random();
        Random rand2 = new Random();

        int pixel = 45;
        int xPosNew = 0;
        int yPosNew = 0;

        do {
            xPosNew = xPos + rand1.nextInt(2 * pixel + 1) - pixel;
            yPosNew = yPos + rand2.nextInt(2 * pixel + 1) - pixel;
        } while (this.xOutOfBound(xPosNew) || this.yOutOfBound(yPosNew)
                || (xPosNew == xPos && yPosNew == yPos));

        this.xPos = xPosNew;
        this.yPos = yPosNew;
    }
    /**
     * determined by location and dimension
     * two pokemon overlaps if any point of the image
     * overlaps
     * @param otherPokemon a Pokemon instance
     * @return whether or not the current instance of
     * Pokemon is colliding with another givin instance
     * of Pokemon
     */
    public boolean collidesWithPokemon(Pokemon otherPokemon) {
        int imaW = this.getImage().getIconWidth();
        int imaH = this.getImage().getIconHeight();
        return (otherPokemon.getXPos() > this.xPos
             && otherPokemon.getXPos() < this.xPos + imaW
             && otherPokemon.getYPos() > this.yPos
             && otherPokemon.getYPos() < this.yPos + imaH);
    }
    /**
     * check if they are the same Pokemon species
     * @param otherPokemon a Pokemon instance
     * @return whether or not the two Pokemon instance
     * can reproduce.
     *
     */
    public abstract boolean canReproduceWithPokemon(Pokemon otherPokemon);
    /**
     *
     * @param otherPokemon a Pokemon instance
     * @return a new Pokemon of the same type in the same
     * location, if reproduction does not happen for some
     * reason, return null.
     * Give reproduction some random chance of occurring if
     * the Pokemon are colliding with each other.
     *
     */
    public abstract Pokemon reproduceWithPokemon(Pokemon otherPokemon);
    /**
     * @return whether or not the Pokemon instance has
     * surpassed some determined maximum level
     *
     */
    public abstract boolean isOld();
    /**
     * @param otherPokemon a Pokemon instance
     * @return whether or not the current Pokemon instance
     * can harm an instance of the other Pokemon through combat
     *
     * the possibility of harming Pokemon
     *
     *              Fire    Water   Grass   Electric
     *
     * a
     * t   Fire      50%      20%     80%      70%
     * t
     * a   Water     80%      50%     20%      40%
     * c
     * k   Grass     20%      80%     50%      30%
     * e
     * r   Electric  30%      60%     70%      50%
     * s
     */
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        Random rand = new Random(3);
        return rand.nextInt(100) < 50;
    }
    /**
     * @param otherPokemon a Pokemon instance
     * decrease the other Pokemon's health by some amount
     *
     */
    public abstract void harmPokemon(Pokemon otherPokemon);
     /**
     * Called when the instance faints
     * change the health of the instance to make faint
     * set the health to zero
     */
    public void faint() {
        this.increaseHealth(-this.health);
    }
    /**
     * @return whether or not the Pokemon instance has
     * fainted.(health == 0 or they have exceeded maximum
     * level).
     *
     */
    public boolean hasFainted() {
        return this.health <= 0 || this.isOld();
    }
}
