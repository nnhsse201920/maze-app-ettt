public class MazeSolverQueue extends MazeSolver
{
    private MyQueue<Square> q;
    public MazeSolverQueue(Maze maze)
    {
        super(maze);
        q = new MyQueue<Square>();
        q.enqueue(maze.getStart());
    }

    @Override
    public void makeEmpty()
    {
        this.q.clear();
    }

    @Override
    public boolean isEmpty()
    {
        return this.q.isEmpty();
    }

    @Override
    public void add(Square sq)
    {
        this.q.enqueue(sq);
    }

    @Override
    public Square next()
    {
        return this.q.dequeue();
    }

    public static void main (String[] args)
    {
        Maze a = new Maze();
        a.loadMaze("src/maze-1");
        MazeSolver solver = new MazeSolverQueue(a);
        solver.solve();
        System.out.println(solver.getPath());

    }
}
