import java.util.List;

/**
 * @program: A-Star-Algorithm-master
 * @description:
 * @author: Miao Jiaxin
 * @create: 2020-01-13 10:59
 **/

public class Task {
    public int agvID;
    public int startTime;

    private int[] speed = new int[] {2,1};
    private List<Node> path;

    public Task(int agvID, int startTime, List<Node> path) {
        this.agvID = agvID;
        this.startTime = startTime;
        this.path = path;
    }

    public int getAgvType(int agvID) {
        int lightAGVNum = 10;
        int heavyAGVNum = 5;
        if(agvID<=0) {
            //err input
            return -1;
        } else if(agvID<= lightAGVNum) {
            //light agv
            return 1;
        } else if (agvID<= lightAGVNum + heavyAGVNum) {
            //heavy agv
            return 2;
        } else {
            //err input
            return -1;
        }
    }

}
