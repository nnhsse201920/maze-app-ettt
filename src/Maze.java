import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class Maze {
    private Square[][] maze;
    private int row;
    private int col;
    private Square start = new Square(0, 0, 2);
    private Square end;

    public boolean loadMaze(String fname) {
        try {
            Scanner in = new Scanner(new File(fname));
            this.row = in.nextInt();
            this.col = in.nextInt();
            this.maze = new Square[this.row][this.col];

            for (int r = 0; r < this.row; r++) {
                for (int c = 0; c < this.col; c++) {
                    Square n = new Square(r, c, in.nextInt());
                    if (n.getType() == 2) {
                        this.start = n;
                    } else if (n.getType() == 3) {
                        this.end = n;
                    }
                    maze[r][c] = n;
                }
            }

        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    public ArrayList<Square> getNeighbors(Square sq) {
        ArrayList<Square> n = new ArrayList<>();
        int row = sq.getRow();
        int col = sq.getCol();

        if (row == 0 && col == 0) {
            n.add(maze[row + 1][col]);
            n.add(maze[row][col + 1]);
            return n;
        } else if (row == 0 && col == maze[0].length - 1) {
            n.add(maze[row + 1][col]);
            n.add(maze[row][col - 1]);
            return n;
        } else if (row == maze.length - 1 && col == maze[0].length - 1) {
            n.add(maze[row - 1][col]);
            n.add(maze[row][col - 1]);
            return n;
        } else if (row == maze.length - 1 && col == 0) {
            n.add(maze[row - 1][col]);
            n.add(maze[row][col + 1]);
            return n;
        } else if (row == 0 && (col != 0 && col != maze[0].length - 1)) {
            n.add(maze[row + 1][col]);
            n.add(maze[row][col - 1]);
            n.add(maze[row][col + 1]);
            return n;
        } else if (col == 0 && (row != 0 && row != maze.length - 1)) {
            n.add(maze[row - 1][col]);
            n.add(maze[row + 1][col]);
            n.add(maze[row][col + 1]);

            return n;
        } else if (row == maze.length - 1 && (col != 0 && col != maze[0].length - 1)) {
            n.add(maze[row - 1][col]);
            n.add(maze[row][col - 1]);
            n.add(maze[row][col + 1]);

            return n;
        } else if (col == maze[0].length - 1 && (row != 0 && row != maze.length - 1)) {
            n.add(maze[row - 1][col]);
            n.add(maze[row + 1][col]);
            n.add(maze[row][col - 1]);
            return n;
        } else {
            n.add(maze[row - 1][col]);
            n.add(maze[row + 1][col]);
            n.add(maze[row][col - 1]);
            n.add(maze[row][col + 1]);
            return n;
        }


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
  for (int r = 0; r < this.row; r++)
  {
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
    public Square getFinish()
    {   Square s = null;
        for (int r=0; r < maze.length; r++) {
            for (int c=0; c < maze[0].length; c++) {
                if (maze[r][c].getType() == 3)
                {s =  maze[r][c];}
            }
        }
        return s;
    }
}
