/**
 * Interface defining methods for a MinionQueue.
 *
 * @author Heather
 * @version 1
 */
public interface MinionQueue {

    /**
     * Add a Minion to the back of the queue.
     *
     * @param m the Minion to add.
     * @throws IllegalArgumentException if Minion is null
     */
    void enqueue(Minion m);

    /**
     * Remove a Minion from the queue.
     *
     * @return the Minion from the front of the queue.
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    Minion dequeue();
}