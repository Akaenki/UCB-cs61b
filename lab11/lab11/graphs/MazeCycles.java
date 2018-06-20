package lab11.graphs;
import edu.princeton.cs.algs4.Stack;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private Maze maze;
    private int[] parent;
    private boolean cycleFound = false;
    private int cycleStart,cycleEnd;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
    }

    private void dfs() {
        Stack<Integer> stack = new Stack<>();
        parent = new int[maze.V()];

        stack.push(0);

        distTo[0] = 0;

        while(!stack.isEmpty() && !cycleFound){
            int v = stack.pop();
            marked[v] = true;
            announce();

            for(int w : maze.adj(v)){
                if(!marked[w]){
                    stack.push(w);
                    parent[w] = v;
                    distTo[w] = distTo[v] + 1;
                } else if(marked[w] && w != parent[v]){
                    cycleFound = true;
                    cycleStart = v;
                    cycleEnd = w;
                    edgeTo[v] = w;
                    announce();
                    break;
                }
            }
        }

        int v = cycleStart;
        while(v!=cycleEnd){
            edgeTo[parent[v]] = v;
            announce();
            v = parent[v];
        }

    }

    @Override
    public void solve() {
        dfs();
    }

}

