import java.util.NoSuchElementException;
import java.util.Iterator;
/**
* MinionList class.
* @author nwang89
* @version 2
*/
public class MinionList implements Iterable<Minion>, MinionQueue, MinionStack {

    private Node head;

    /**
     * Node class.
     */
    private class Node {
        private Minion data;
        private Node next;

        public Node(Minion data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    /**
    * @param i index
    * @return the minion at specified index i
    * @throws IndexOutOfBoundsException if i is out of bound
    */
    public Minion get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return getHelper(i, head, 0).data;
    }
    /**
    * @param i index
    * @param cur current node
    * @param count a counter for the list
    * @return the Node at specified index i
    */
    private Node getHelper(int i, Node cur, int count) {
        if (count == i) {
            return cur;
        }
        return getHelper(i, cur.next, ++count);
    }
    /**
    * @return a String representation of the list in
    * this format: “[minion1,minion2,minion3,]”.
    */
    public String toString() {
        return "[" + stringHelper(head) + "]";
    }
    /**
    * @param cur current node
    * @return a String representation of the list in
    * this format: “minion1,minion2,minion3,”.
    */
    private String stringHelper(Node cur) {
        if (cur == null) {
            return "";
        }
        return cur.data + "," + stringHelper(cur.next);
    }
    /**
    * @return the size of the list
    */
    public int size() {
        return sizeHelper(head);
    }
    /**
    * @param cur current node
    * @return the size of the list
    */
    private int sizeHelper(Node cur) {
        if (cur == null) {
            return 0;
        }
        return 1 + sizeHelper(cur.next);
    }
    /**
    * @return a new MinionList with the same elements
    * as this MinionList but whose elements are in
    * reverse order from this MinionList
    */
    public MinionList reverse() {
        MinionList reversed = copyList(this);
        Node newHead = reverseHelper(reversed.head, null);
        reversed.head = newHead;
        return reversed;

    }
    /**
    * @param list a MinionList
    * @return a new MinionList with the same elements
    * as this MinionList 
    */
    private MinionList copyList(MinionList list) {
        MinionList temp = new MinionList();
        Node rhead = new Node(list.head.data, null);
        Node rcur = rhead;
        Node cur = list.head.next;
        while (cur != null) {
            Node newnext = new Node(cur.data, null);
            rcur.next = newnext;
            cur = cur.next;
            rcur = rcur.next;
        }
        temp.head = rhead;
        return temp;
    }
    /**
    * @param head the head of this MinionList
    * @param prev a pointer recording previous Node
    * @return a new MinionList with the same elements
    * as this MinionList but whose elements are in
    * reverse order from this MinionList
    */
    private Node reverseHelper(Node newhead, Node prev) {
        if (newhead == null) {
            return prev;
        }
        Node temp = newhead.next;
        newhead.next = prev;
        return reverseHelper(temp, newhead);
    }


    /**
     * Checks if list is empty.
     * @return true if this list has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
    * @return a iterator for minions of MinionList
    */
    @Override
    public Iterator<Minion> iterator() {
        return new MyIterator();
    }

    /**
    * MyIterator class
    */
    private class MyIterator implements Iterator<Minion> {

        private Node cur = head;

        /**
        * @return true if there is next element in list
        */
        @Override
        public boolean hasNext() {
            return cur != null;
        }
        /**
        * @return the next element in the list
        */
        @Override
        public Minion next() {
            Node n = cur;
            cur = cur.next;
            return n.data;
        }
    }

    /**
     * Add a Minion to the back of the queue.
     *
     * @param m the Minion to add.
     * @throws IllegalArgumentException if Minion is null
     */
    @Override
    public void enqueue(Minion m) throws IllegalArgumentException {
        if (m == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty()) {
            head = new Node(m, null);
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(m, null);
        }
    }
     /**
     * Remove a Minion from the queue.
     *
     * @return the Minion from the front of the queue.
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    @Override
    public Minion dequeue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Node m = head;
        head = head.next;
        return m.data;
    }
    /**
     * Push a Minion on to the stack.
     *
     * @param m the Minion to push.
     * @throws IllegalArgumentException if data is null.
     */
    @Override
    public void push(Minion m) throws IllegalArgumentException {
        if (m == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty()) {
            head = new Node(m, null);
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(m, null);
        }
    }


    /**
     * Pop from the stack.
     *
     * @return the Minion from the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty.
     */
    @Override
    public Minion pop() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (this.size() == 1) {
            Node cur = head;
            head = null;
            return cur.data;
        } else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            Node temp = cur.next;
            cur.next = null;
            return temp.data;
        }
    }
}