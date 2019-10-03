public class Square
{
    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int END = 3;
    private int row;
    private int col;
    private int type;


    /**
     * Constructor for objects of class Square
     * @param intRow the row for this square
     * @param intCol the col for this square
     * @param intType the type fof this square
     */
    public Square (int intRow, int intCol, int intType)
    {
        this.row = intRow;
        this.col = intCol;
        this.type = intType;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the col of this square
     */
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toString()
    {
        String str = "";
        switch(this.type)
        {
            case Square.SPACE:
            {
                str = "_";
                break;
            }
            case Square.WALL:
            {
                str = "#";
                break;
            }
            case Square.START:
            {
                str = "S";
                break;
            }
            case Square.END:
            {
                str = "E";
                break;
            }
        }
        return str;
    }
}
