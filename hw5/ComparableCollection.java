import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * @author nwang89
 * @version 2.0
 * @param <T> a generic type
 */
public class ComparableCollection<T extends Comparable<T>>
            implements CollectionInterface<T>, Iterable<T> {
    private T[] array;
    private int size;
    /**
     * construct a ComparableCollection
     * initialize an array of capacity 5
     * initialize the size to be zero
    */
    public ComparableCollection() {
        this.array = (T[]) new Comparable[5];
        this.size = 0;
    }

    /**
     * @param elem the element adding to backup array
    */
    public void add(T elem) {
        size++;
        if (size > array.length) {
            T[] temp = (T[]) new Comparable[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[size - 1] = elem;
    }
    /**
     * @param elems an array adding to backup array
     */
    public void addAll(T[] elems) {
        for (int i = 0; i < elems.length; i++) {
            this.add(elems[i]);
        }
    }
    /**
     * @param elem the element removing from backup array
     * @return true if the operation is successful
     */
    public boolean remove(T elem) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(elem)) {
                array[i] = null;
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }
    /**
     * @param elems the array removing from backup array
     * @return true if the operation is successful
     */
    public boolean removeAll(T[] elems) {
        boolean hasRemoved = false;
        for (int i = 0; i < elems.length; i++) {
            hasRemoved = (this.remove(elems[i]) || hasRemoved);
        }
        return hasRemoved;
    }
    /**
     * @param elem the element being checked
     * @return true if the backup array contains the element
     */
    public boolean contains(T elem) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }
    /**
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     * @throws NoSuchElementException if index is in bounds but after
     * element
     */
    public T get(int index) throws NoSuchElementException {
        if (index < 0 || index > size - 1) {
            throw new NoSuchElementException();
        }
        return (T) array[index];
    }
    /**
     * @return The size of the collection.
     */
    public int size() {
        return this.size;
    }
    /**
     * @return The capactity of the collection.
     */
    public int capacity() {
        return this.array.length;
    }
    /**
     * @inheritDoc
     */
    public void clear() {
        T[] temp = (T[]) new Comparable[5];
        this.array = temp;
        this.size = 0;
    }
    /**
     * @inheritDoc
     * @return true if size is zero
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * @inheritDoc
     * @return a string representation of the array
     */
    public String toString() {
        String result = "";
        for (T elem : array) {
            result += elem;
        }
        return result;
    }
    /**
     * @return a iterator instance of myIterator
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private int cursor = 0;
        /**
        * @return true if there is next element in the collection
        * and false otherwise
        */
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        /**
        * @return the next element in the collection
        * @throws NoSuchElementException if the cursor reaches
        * the end of the collection
        */
        @Override
        public T next() throws NoSuchElementException {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T answer = get(cursor++);
            return answer;
        }
    }


}