import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class Maze
{
    private Square[][] maze;
    private int row;
    private int col;
    private Square start;
    private Square end;

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
                    if(n.getType() == 2)
                    {
                        this.start = n;
                    }
                    else if(n.getType() == 3)
                    {
                        this.end = n;
                    }
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
        ArrayList<Square> nay = new ArrayList<>();
        int sC = sq.getCol();
        int sR = sq.getRow();
        if(sR == 0)
        {
            if(sC == 0)
            {
                Square n = maze[sR][sC++];
                nay.add(n);
                n = maze[sR++][sC];
                nay.add(n);
            }
            if(sC == this.col)
            {
                Square n = maze[sR++][sC];
                nay.add(n);
                n = maze[sR][sC--];
                nay.add(n);
            }
            else
            {
                Square n = maze[sR][sC++];
                nay.add(n);
                n = maze[sR++][sC];
                nay.add(n);
                n = maze[sR][sC--];
                nay.add(n);
            }
        }
        else if(sR == this.row)
        {
            if(sC == 0)
            {
                Square n = maze[sR--][sC];
                nay.add(n);
                n = maze[sR][sC++];
                nay.add(n);
            }
            if(sC == this.col)
            {
                Square n = maze[sR--][sC];
                nay.add(n);
                n = maze[sR][sC--];
                nay.add(n);
            }
            else
            {
                Square n = maze[sR--][sC];
                nay.add(n);
                n = maze[sR][sC++];
                nay.add(n);
                n = maze[sR][sC--];
                nay.add(n);
            }
        }
        else if(sC == 0)
        {
            Square n = maze[sR--][sC];
            nay.add(n);
            n = maze[sR][sC++];
            nay.add(n);
            n = maze[sR++][sC];
            nay.add(n);
        }
        else if(sC == this.col)
        {
            Square n = maze[sR--][sC];
            nay.add(n);
            n = maze[sR++][sC];
            nay.add(n);
            n = maze[sR][sC--];
            nay.add(n);
        }
        else
        {
            Square n = maze[sR--][sC];
            nay.add(n);
            n = maze[sR][sC++];
            nay.add(n);
            n = maze[sR++][sC];
            nay.add(n);
            n = maze[sR][sC--];
        }
        return nay;
    }
    public Square getStart()
    {
        return this.start;
    }
    public Square getEnd()
    {
        return this.end;
    }
    public void reset()
    {
        for (int r = 0; r < this.row; r++) {
            for (int c = 0; c < this.col; c++)
            {
                maze[r][c].reset();
            }
        }
    }
    public String toChar(int num)
    {
        String ch = "";
        if(num == 0)
        {
            ch = "_";
        }
        else if(num == 1)
        {
            ch = "#";
        }
        else if(num == 2)
        {
            ch = "S";
        }
        else if(num == 3)
        {
            ch = "E";
        }
        return ch;
    }
    public String toString()
    {
        String mazeS = "";
        for (int r = 0; r < this.row; r++) {
            for (int c = 0; c < this.col; c++)
            {
                mazeS += toChar(maze[r][c].getType());
            }
            mazeS += "\n";
        }
        return mazeS;
    }
}
