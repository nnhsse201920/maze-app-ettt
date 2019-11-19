import java.util.ArrayList;
import java.util.Stack;
public abstract class MazeSolver
{
    public Maze maze;
    public boolean endreached = false;
    public Square current;
    private boolean isSolved;


    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    public MazeSolver(Maze maze)
    {
        makeEmpty();
        add(maze.getStart());
        this.maze = maze;
        this.isSolved = false;
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
        Square p = maze.getFinish().getPrev();
        if(p == null)
        {

            return "You are not at the exit.";

        }
        String output = maze.getStart().toString();
        ArrayList<Square> l = new ArrayList<>();
        Square s = maze.getFinish();
        while(s!= maze.getStart())
        {
            l.add(s);
            s = s.getPrev();

            if(s != maze.getStart())
            {
                s.setExplored(3);

            }
        }


        for(int i = l.size()-1; i>0; i--)
        {
            output += "=>["+l.get(i).getRow()+","+l.get(i).getCol()+"]";
        }
        output += "=>"+ maze.getFinish().toString();
        return output;
    }

    public Square step()
    {
        if (isEmpty())
        {
            return null;
        }
        Square n = next();


        ArrayList<Square> s = maze.getNeighbors(n);
        for(int i = s.size()-1; i >= 0; i--)
        {
            if(s.get(i).getType() == 3)
            {
                s.get(i).setPrev(n);
                getPath();
                makeEmpty();
                return n;
            }
            if (s.get(i).getType() != 0 || s.get(i).getExplored() != 0)
            {
                s.remove(i);
            }
        }
        for (int i = 0; i <= s.size()-1; i++)
        {
            s.get(i).setExplored(1);
            s.get(i).setPrev(n);
            add(s.get(i));

        }
        n.setExplored(2);
        return n;
    }

    public void solve()
    {
        while (isSolved == false)
        {
            System.out.println(maze);
            Square s = step();
            if (s == maze.getFinish())
            {
                break;
            }
            else if(s == null)
            {
                isSolved = true;
            }

        }
        isSolved = true;

    }
}
