import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class Maze
{
    private Square[][] maze;
    private int row;
    private int col;

    public boolean loadMaze(String fname)
    {
        try
        {
            Scanner in = new Scanner(new File(fname));
            this.row = in.nextInt();
            this.col = in.nextInt();
            this.maze = new Square[this.row][this.col];

            for (int r = 0; r < this.row; r++) {
                for (int c = 0; c < this.col; c++)
                {
                    Square n = new Square(r, c, in.nextInt());
                    maze[r][c] = n;
                }
            }

        }
        catch(FileNotFoundException e)
        {
            return false;
        }
        return true;
    }

    public ArrayList<Square> getNeighbors(Square sq)
    {

    }
}
