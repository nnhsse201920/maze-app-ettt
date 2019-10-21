import java.util.ArrayList;
import java.util.Stack;
public abstract class MazeSolver
{
    public Maze maze;
    public boolean endreached = false;
    public Square current;


    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }

    public boolean isSolved()
    {
        if(this.isEmpty())
        {
            return true;
        }
        else if(this.endreached)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getPath()
    {
        String a = "";
        if(this.isSolved())
        {
            if(this.endreached)
            {
                Stack<Square> set = new Stack<>();
                while(this.current != null)
                {
                    set.push(this.current);
                    this.current = this.current.getPrev();
                }
                while(!set.empty())
                {
                    a = a + "[" + set.peek().getRow() + ", " + set.pop().getCol() + "], ";
                }
                return a;
            }
            else
            {
                return "The maze cannot be solved";
            }
        }
        return "The maze has not been solved yet";
    }

    public Square step()
    {
        Square n = null;
        if(this.isEmpty())
        {
            this.isSolved();
        }
        else
        {
            n = this.next();
            if(n.getType() == 3)
            {
                this.endreached = true;
                this.current = n;
                this.isSolved();
            }
            else
            {
                ArrayList<Square> around = this.maze.getNeighbors(n);
                for(Square x : around)
                {
                    if(x.getPrev() == null)
                    {
                        x.setPrev(n);
                        this.add(x);
                    }
                }

            }
        }
        return n;
    }

    public void solve()
    {
        while(!this.isSolved())
        {
            this.step();
        }

    }
}
