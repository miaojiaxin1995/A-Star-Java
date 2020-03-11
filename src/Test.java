import java.util.List;

public class Test {
    public static void main(String[] args) {
        A2Test();
        AStarTest();
    }

    public static void A2Test(){
        long startTime = System.currentTimeMillis();
        Node initialNode = new Node(2, 1);
        Node finalNode = new Node(2, 5);
        Map mMap = new Map();
        AStar2 aStar2 = new AStar2(mMap.getRow(), mMap.getCol(), initialNode, finalNode);
        aStar2.setBlocks(mMap.getBlocksArray());
        List<Node> path = aStar2.findPath();
        for (Node node : path) {
            System.out.println(node);
        }
        System.out.println(System.currentTimeMillis()-startTime+"ms.");
    }
    public static void AStarTest() {
        long startTime = System.currentTimeMillis();
        Node initialNode = new Node(2, 1);
        Node finalNode = new Node(2, 5);
        Map mMap = new Map();
        AStar aStar = new AStar(mMap.getRow(), mMap.getCol(), initialNode, finalNode);
        aStar.setBlocks(mMap.getBlocksArray());
        List<Node> path = aStar.findPath();
        for (Node node : path) {
            System.out.println(node);
        }
        System.out.println(System.currentTimeMillis()-startTime+"ms.");

/*        Node initialNode = new Node(9, 0);
        Node finalNode = new Node(0, 9);
        int rows = 10;
        int cols = 10;
        AStar aStar = new AStar(rows, cols, initialNode, finalNode);
        int[][] blocksArray = new int[][]{{1, 2}, {2,7}, {4, 1}, {4, 4}, {6, 8}, {7, 1}, {8, 5}};
        aStar.setBlocks(blocksArray);
        List<Node> path = aStar.findPath();
        for (Node node : path) {
            System.out.println(node);
        }*/

        //Search Area
        //      0   1   2   3   4   5   6
        // 0    -   -   -   -   -   -   -
        // 1    -   -   -   B   -   -   -
        // 2    -   I   -   B   -   F   -
        // 3    -   -   -   B   -   -   -
        // 4    -   -   -   -   -   -   -
        // 5    -   -   -   -   -   -   -

        //Expected output with diagonals
        //Node [row=2, col=1]
        //Node [row=1, col=2]
        //Node [row=0, col=3]
        //Node [row=1, col=4]
        //Node [row=2, col=5]

        //Search Path with diagonals
        //      0   1   2   3   4   5   6
        // 0    -   -   -   *   -   -   -
        // 1    -   -   *   B   *   -   -
        // 2    -   I*  -   B   -  *F   -
        // 3    -   -   -   B   -   -   -
        // 4    -   -   -   -   -   -   -
        // 5    -   -   -   -   -   -   -

        //Expected output without diagonals
        //Node [row=2, col=1]
        //Node [row=2, col=2]
        //Node [row=1, col=2]
        //Node [row=0, col=2]
        //Node [row=0, col=3]
        //Node [row=0, col=4]
        //Node [row=1, col=4]
        //Node [row=2, col=4]
        //Node [row=2, col=5]

        //Search Path without diagonals
        //      0   1   2   3   4   5   6
        // 0    -   -   *   *   *   -   -
        // 1    -   -   *   B   *   -   -
        // 2    -   I*  *   B   *  *F   -
        // 3    -   -   -   B   -   -   -
        // 4    -   -   -   -   -   -   -
        // 5    -   -   -   -   -   -   -
    }
}
