/**
 * @program: A-Star-Algorithm-master
 * @description: map info
 * @author: Miao Jiaxin
 * @create: 2020-01-13 09:46
 **/

public class Map {
    protected int row;
    protected int col;
    protected int[][] blocksArray;

    protected static final int DEFAULT_ROW = 6;
    protected static final int DEFAULT_COL = 7;
    protected static final int[][] DEFAULT_BLOCKS_ARRAY = new int[][]{{1, 3}, {2, 3}, {3, 3}};

    public Map() {
        this.row = DEFAULT_ROW;
        this.col = DEFAULT_COL;
        this.blocksArray = DEFAULT_BLOCKS_ARRAY;
    }

    public Map(int row, int col, int[][] blocksArray) {
        this.row = row;
        this.col = col;
        this.blocksArray = blocksArray;
    }

    public Map(int row, int col, double obstacle) {
        int n = (int) (row * col * obstacle);
        int[][] blocksArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            int r = (int) (row * Math.random());
            int c = (int) (col * Math.random());
            blocksArray[i][0] = r;
            blocksArray[i][1] = c;
        }
        this.row = row;
        this.col = col;
        this.blocksArray = blocksArray;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int[][] getBlocksArray() {
        return blocksArray;
    }
}
