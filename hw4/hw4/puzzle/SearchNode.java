package hw4.puzzle;

import java.util.Comparator;

public class SearchNode {
    public WorldState current;
    public SearchNode previous;
    public int totalMoves;
    public int estimateMoves;

    public SearchNode(WorldState cur, SearchNode pre, int moves){
        current = cur;
        previous = pre;
        totalMoves = moves;
        estimateMoves = cur.estimatedDistanceToGoal();
    }
}

class StateComparator implements Comparator<SearchNode> {
    @Override
    public int compare(SearchNode a, SearchNode b) {
        return (a.estimateMoves + a.previous.totalMoves)
                - (b.estimateMoves + b.previous.totalMoves);
    }
}
