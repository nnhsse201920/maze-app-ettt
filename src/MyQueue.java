import java.util.NoSuchElementException;


public class MyQueue<T> implements QueueADT<T>
{
    private Node first;
    private Node last;
    private int n;
    public MyQueue()
    {
        this.first = null;
        this.last = null;
        n = 0;
    }
    /**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */
    public void enqueue(T item)
    {

        Node prev = last;
        last = new Node();
        last.key = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            prev.next = last;
        }
        n++;
    }

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        T item = (T) first.key;
        first = first.next;
        n--;
        if (isEmpty())
        {
            last = null;
        }
        return item;
    }

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T front()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        return (T) first.key;
    }

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size()
    {
        return n;
    }

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Clear out the data structure
     */
    public void clear()
    {
        this.first = null;
        this.last = null;
        this.n = 0;
    }
}