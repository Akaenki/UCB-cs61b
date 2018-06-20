package hw4.puzzle;
import edu.princeton.cs.algs4.MinPQ;

import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

public class Solver {
    public MinPQ<SearchNode> fringe = new MinPQ<>(new StateComparator());
    public SearchNode goal;
    public int move;


    public Solver(WorldState initial){
        fringe.insert(new SearchNode(initial,null,0));

        SearchNode cur = fringe.delMin();

        while(!cur.current.isGoal()){
            for(WorldState next : cur.current.neighbors()){
                if(cur.previous==null || !next.equals(cur.previous.current) ) {
                    fringe.insert(new SearchNode(next, cur, cur.totalMoves+1));
                }
            }
            cur = fringe.delMin();
        }
        goal = cur;
    }

    public int moves(){
        return goal.totalMoves;
    }

    public Iterable<WorldState> solution(){
        Deque<WorldState> list = new LinkedList<>();
        SearchNode cur = goal;
        while(cur != null){
            list.addFirst(cur.current);
            cur = cur.previous;
        }
        return list;
    }
}
