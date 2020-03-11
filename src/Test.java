import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[] {100,200,300,400,500,600,700,800,900};
        double[] obstacles = new double[] {0.1,0.2,0.3,0.4,0.5};

        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                AStar2Test(nums[j],obstacles[i]);
            }
        }

    }

    public static void AStar2Test(int num,double obstacle) {
        long startTime = System.currentTimeMillis();
        Node initialNode = new Node(0, 0);
        Node finalNode = new Node(num, num);
        Map mMap = new Map(num, num, obstacle);
        long endTime = System.currentTimeMillis();
        long start2Time = System.currentTimeMillis();
        AStar2 aStar2 = new AStar2(mMap.getRow(), mMap.getCol(), initialNode, finalNode);
        aStar2.setBlocks(mMap.getBlocksArray());
        List<Node> path2 = aStar2.findPath();
        long end2Time = System.currentTimeMillis();

        long start1Time = System.currentTimeMillis();
        AStar aStar = new AStar(mMap.getRow(), mMap.getCol(), initialNode, finalNode);
        aStar.setBlocks(mMap.getBlocksArray());
        List<Node> path1 = aStar2.findPath();
        long end1Time = System.currentTimeMillis();
        long time1 = end1Time - start1Time + endTime - startTime;
        long time2 = end2Time - start2Time + endTime - startTime;
        long generateTime = endTime - startTime;
        System.out.println(num+" "+obstacle+" " + time1 + " "+time2);


//        for (Node node : path) {
//            System.out.println(node);
//        }

    }

    public static void AStarTest() {
        long startTime = System.currentTimeMillis();
        Node initialNode = new Node(2, 1);
        Node finalNode = new Node(2, 5);
        Map mMap = new Map();
        AStar aStar = new AStar(mMap.getRow(), mMap.getCol(), initialNode, finalNode);
        aStar.setBlocks(mMap.getBlocksArray());
        List<Node> path = aStar.findPath();
//        for (Node node : path) {
//            System.out.println(node);
//        }
        System.out.println(System.currentTimeMillis() - startTime + "ms.M1");

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
