/**
 * Interface defining methods for a MinionStack.
 *
 * @author Heather
 * @version 1
 */
public interface MinionStack {

    /**
     * Push a Minion on to the stack.
     *
     * @param m the Minion to push.
     * @throws IllegalArgumentException if data is null.
     */
    void push(Minion m);

    /**
     * Pop from the stack.
     *
     * @return the Minion from the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty.
     */
    Minion pop();
}