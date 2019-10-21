import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MazeTest extends TestCase {

    public void testLoadMaze() {
        Maze maze = new Maze();
        boolean yes = maze.loadMaze("maze-1");
        assertEquals(true, yes);
    }

    public void testGetNeighbors() {
        Maze maze = new Maze();
        maze.loadMaze("maze-4");
        Square sq = new Square(0, 0, 0);
        ArrayList<Square> l = maze.getNeighbors(sq);
        ArrayList<Square> n = new ArrayList<Square>();
        n.add(new Square(0,1,0));
        n.add(new Square(1, 0, 0));
        assertEquals(n,l);
        




    }

    public void testGetStart() {
        Maze maze = new Maze();
        maze.loadMaze("maze-1");
        Square st = new Square(0,0,2);
        assertEquals(st, maze.getStart());
    }

    public void testGetEnd() {
        Maze maze = new Maze();
        maze.loadMaze("maze-1");
        Square ed = new Square(2,2,3);
        assertEquals(ed, maze.getEnd());
    }

    public void testReset() {
    }

    public void testToChar() {
    }

    public void testToString() {
        Maze maze = new Maze();
        maze.loadMaze("maze-1");
        String theMaze = maze.toString();
        assertEquals("S__\n___\n__E", theMaze);
    }
}