public class MazeSolverStack extends MazeSolver
{
    private MyStack<Square> stack;

    public MazeSolverStack(Maze maze)
    {
        super(maze);
    }
    public void makeEmpty()
    {

        stack = new MyStack<>();
    }


    public Square next()
    {
        return stack.pop();
    }

    public void add(Square sq)
    {
        stack.push(sq);
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public static void main (String[] args)
    {
        Maze m = new Maze();
        m.loadMaze("src/maze-1");
        MazeSolver solver = new MazeSolverStack(m);
        solver.solve();
        System.out.println(solver.getPath());
        System.out.println(m.getFinish().getPrev());
    }
}
