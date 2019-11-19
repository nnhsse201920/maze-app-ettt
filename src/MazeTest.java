import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MazeTest extends TestCase {

    public void testLoadMaze() {
        Maze maze = new Maze();
        boolean yes = maze.loadMaze("src/maze-1");
        assertEquals(true, yes);
        Maze maze2 = new Maze();
        boolean no = maze2.loadMaze("src/donotexist");
        assertEquals(false, no);
    }

    public void testGetNeighbors() {
        Maze m = new Maze();
        m.loadMaze("src/maze-3");
        ArrayList<Square> list = new ArrayList<Square>();
        list.add(new Square(0, 3, 0));
        list.add(new Square(1, 4, 3));
        list.add(new Square(2, 3, 0));
        list.add(new Square(1, 2, 1));
        assertEquals(list, m.getNeighbors(new Square(1, 3, 0)));




    }

    public void testGetStart() {
        Maze maze = new Maze();
        maze.loadMaze("src/maze-1");
        Square st = new Square(0,0,2);
        assertEquals(st, maze.getStart());
    }

    public void testGetEnd() {
        Maze maze = new Maze();
        maze.loadMaze("src/maze-1");

        Square ed = new Square(2,2,3);
        assertEquals(ed, maze.getEnd());
    }

    public void testReset() {
    }

    public void testToChar() {
    }

    public void testToString() {
        Maze maze = new Maze();
        maze.loadMaze("src/maze-1");
        String theMaze = maze.toString();
        assertEquals("S__\n___\n__E\n", theMaze);
    }
}