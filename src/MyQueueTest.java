import junit.framework.TestCase;
import java.util.NoSuchElementException;


public class MyQueueTest extends TestCase {

    public void testEnqueue() {
        MyQueue q = new MyQueue();
        q.enqueue(5);
        assertEquals(1,q.size());
        assertEquals(5, q.front());


    }

    public void testDequeue() {
        MyQueue q = new MyQueue();
        q.enqueue(5);
        assertEquals(5, q.dequeue());
        assertEquals(0,q.size());
        boolean caught = false;
        try
        {
            q.dequeue();
        }
        catch(NoSuchElementException e)
        {
            caught = true;
        }
        assertEquals(true,caught);
    }

    public void testFront() {
        MyQueue q = new MyQueue();
        q.enqueue(5);
        q.enqueue(6);
        assertEquals(5, q.front());
        MyQueue r = new MyQueue();
        boolean caught = false;
        try
        {
            r.dequeue();
        }
        catch(NoSuchElementException e)
        {
            caught = true;
        }
        assertEquals(true,caught);
    }

    public void testSize() {
        MyQueue q = new MyQueue();
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        assertEquals(3, q.size());
    }

    public void testIsEmpty() {
        MyQueue q = new MyQueue();
        MyQueue r = new MyQueue();
        r.enqueue(5);
        assertEquals(true, q.isEmpty());
        assertEquals(false, r.isEmpty());
    }

    public void testClear() {
        MyQueue q = new MyQueue();
        q.enqueue(5);
        q.enqueue(6);
        q.clear();
        assertEquals(true, q.isEmpty());
    }
}