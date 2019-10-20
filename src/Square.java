import java.util.Objects;

public class Square
{
    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int END = 3;
    private int row;
    private int col;
    private int type;
    private int typeInitial;
    private Square prev;


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
        this.typeInitial = intType;
        this.prev = null;
    }

    public void reset()
    {
        this.type = this.typeInitial;
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

    public Square getPrev()
    {
        return this.prev;
    }

    public void setPrev(Square n)
    {
        this.prev = n;
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
@Override
    public boolean equals(Object o)
{
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        /*if (this.getType() != o.getType())
            return false;
        if (this.getCol() != o.getCol())
            return false;
        if (this.getRow() != o.getRow())
            return false;
        return  true;*/
        Square sq = (Square) o;
        // field comparison
        return Objects.equals(sq.getCol(), sq.getCol())
                && Objects.equals(sq.getRow(), sq.getRow())
                && Objects.equals(sq.getType(), sq.getType());
    }
}
