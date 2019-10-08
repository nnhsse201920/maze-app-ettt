import junit.framework.TestCase;

import java.util.ArrayList;


public class MazeTest extends TestCase {

    public void testLoadMaze() {
        Maze maze = new Maze();
        boolean yes = maze.loadMaze("maze-1");
        assertEquals(true, yes);
    }

    public void testGetNeighbors() {
        Maze maze = new Maze();
        maze.loadMaze("maze-1");
        ArrayList<Square> l = new ArrayList<Square>();


    }

    public void testGetStart() {
    }

    public void testGetEnd() {
    }

    public void testReset() {
    }

    public void testToChar() {
    }

    public void testToString() {
    }
}