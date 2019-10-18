import junit.framework.TestCase;

import java.util.NoSuchElementException;

public class MyStackTest extends TestCase
{

    public void testPop()
    {
        MyStack<Integer> test = new MyStack<>();
        test.push(9);
        int x = test.pop();
        assertEquals(9,x);
        test.push(8);
        test.push(7);
        test.push(6);
        assertEquals(6,(int)test.pop());
        assertEquals(7,(int)test.pop());
        assertEquals(8,(int)test.pop());
        //assertEquals(new NoSuchElementException(),test.pop()); //code does what its suppose to do
        boolean caught = false;
        try
        {
            test.pop();
        }
        catch(NoSuchElementException e)
        {
            caught = true;
        }
        assertEquals(true,caught);
    }
    public void testTop()
    {
        MyStack<Integer> test = new MyStack<>();
        test.push(9);
        assertEquals(9,(int)test.top());
        test.push(8);
        test.push(7);
        test.push(6);
        assertEquals(6,(int)test.top());
    }

    public void testSize()
    {
        MyStack<Integer> test = new MyStack<>();
        test.push(9);
        assertEquals(1,test.size());
        test.push(8);
        test.push(7);
        test.push(6);
        assertEquals(4,test.size());
    }

    public void testIsEmpty()
    {
        MyStack<Integer> test = new MyStack<>();
        assertEquals(true,test.isEmpty());
        test.push(9);
        test.push(8);
        assertEquals(false,test.isEmpty());
    }

    public void testClear()
    {
        MyStack<Integer> test = new MyStack<>();
        test.push(8);
        test.push(7);
        test.push(6);
        test.clear();
        assertEquals(0,test.size());
    }
}
