package lab11.graphs;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 *  @author Josh Hug
 */
public class MazeAStarPath extends MazeExplorer {
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Estimate of the distance from v to the target. */
    private int h(int v) {
        int dx = maze.toX(v) - maze.toX(t);
        int dy = maze.toY(v) - maze.toY(t);
        return Math.abs(dx) + Math.abs(dy);
    }

    /** Finds vertex estimated to be closest to target. */
    private int findMinimumUnmarked(Queue<Integer> fringe) {
        int minDist = Integer.MAX_VALUE;
        int min = -1;

        for(int i : fringe){
            if(h(i) < minDist) min = i;
        }
        return min;
    }

    /** Performs an A star search from vertex s. */
    private void astar(int s) {
        Queue<Integer> fringe = new ArrayDeque<>();

        fringe.add(0);
        marked[0] = true;
        announce();

        while(!fringe.isEmpty()){
            int v = findMinimumUnmarked(fringe);
            fringe.remove(v);
            marked[v] = true;
            announce();

            if(v == t){
                targetFound = true;
                return;
            }

            for(int w : maze.adj(v)){
                if(!marked[w]){
                    fringe.add(w);

                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }

    @Override
    public void solve() {
        astar(s);
    }

}

