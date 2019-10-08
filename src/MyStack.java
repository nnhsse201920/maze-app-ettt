import java.util.ArrayList;
import java.util.NoSuchElementException;
public class MyStack<T> implements StackADT<T>
{
    private ArrayList<T> list;
    private int top;

    public MyStack()
    {
        this.list = new ArrayList<>();
        this.top = -1;
    }

    public void push(T n)
    {
        this.list.add(n);
        this.top++;
    }

    public T pop()
    {
        if(this.top == -1)
        {
            throw new NoSuchElementException();
        }
        else
        {
            this.top--;
            return this.list.remove(this.top++);
        }
    }

    public T top()
    {
        if(this.top == -1)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return this.list.get(this.top);
        }
    }

    public int size()
    {
        return this.top++;
    }

    public boolean isEmpty()
    {
        if(this.top == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void clear()
    {
        this.top = -1;
        this.list = new ArrayList<>();
    }
}
