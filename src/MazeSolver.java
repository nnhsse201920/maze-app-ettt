public abstract class MazeSolver
{
    public Maze maze;

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
        else
        {
            return false;
        }
    }

    public String getPath()
    {
        return "";
    }

    public Square step()
    {
        return null;
    }

    public void solve()
    {

    }





}
