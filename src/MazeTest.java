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
        Maze maze = new Maze();
        maze.loadMaze("src/maze-4");
        Square sq = new Square(0, 0, 0);
        Square sq1 = new Square(3,4,1);
        Square sq2 = new Square(0,2,0);
        Square sq3 = new Square(0,9,3);


        ArrayList<Square> l = maze.getNeighbors(sq3);



        ArrayList<Square> n = new ArrayList<Square>();
        n.add(new Square(1,9,1));
        n.add(new Square(0, 8, 0));
       /* n.add(new Square(0, 1, 0));*/

       /* n.add(new Square(3, 3, 1));*/
        assertEquals(n,l);




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