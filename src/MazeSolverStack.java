public class MazeSolverStack extends MazeSolver
{
    private MyStack<Square> stack;
    public MazeSolverStack(Maze maze)
    {
        super(maze);
        stack = new MyStack<Square>();
        this.add(maze.getStart());
    }

    @Override
    public void makeEmpty()
    {
        this.stack.clear();
    }

    @Override
    public boolean isEmpty()
    {
        return this.stack.isEmpty();
    }

    @Override
    public void add(Square sq)
    {
        this.stack.push(sq);
    }

    @Override
    public Square next()
    {
        return this.stack.pop();
    }

    public static void main (String[] args)
    {
        Maze a = new Maze();
        a.loadMaze("src/maze-1");
        MazeSolver solver = new MazeSolverStack(a);
        solver.solve();
        System.out.println(solver.getPath());
    }
}
