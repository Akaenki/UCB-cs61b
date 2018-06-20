package hw4.puzzle;

import edu.princeton.cs.algs4.BlackFilter;
import edu.princeton.cs.algs4.BoruvkaMST;
import edu.princeton.cs.algs4.Queue;


public class Board implements WorldState{
    public int[][] tile;

    public Board(int[][] tiles){
        int N = tiles.length;
        tile = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N;j++){
                tile[i][j] = tiles[i][j];
            }
        }
    }

    public int tileAt(int i, int j){
        if(i>=size() || j>=size()) throw new IndexOutOfBoundsException("Cannot access tile");
        else return tile[i][j];
    }

    public int size(){
        return tile.length;
    }

    @Override
    public Iterable<WorldState> neighbors(){
        Queue<WorldState> nbs = new Queue<>();
        int N = size();
        int openx = -1; int openy = -1;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(tileAt(i,j) == 0){
                    openx = i; openy = j;
                    break;
                }
            }
        }
        int[][] newTile = new int[N][N];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                newTile[i][j] = tileAt(i,j);
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(Math.abs(i - openx) + Math.abs(j - openy) == 1){
                    newTile[openx][openy] = newTile[i][j];
                    newTile[i][j] = 0;
                    Board nb = new Board(newTile);
                    nbs.enqueue(nb);
                    newTile[i][j] = newTile[openx][openy];
                    newTile[openx][openy] = 0;
                }
            }
        }
        return nbs;
    }

    public int hamming(){
        int sum = 0;
        int N = size();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                int pos = i*N + j + 1;
                if(pos == N*N) continue;
                if(tileAt(i,j) != pos) sum++;
            }
        }
        return sum;
    }

    public int manhattan(){
        int sum = 0;
        int N = size();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(tileAt(i,j) == 0) continue;

                int cur = tileAt(i,j) - 1;
                int x = cur / N; int y = cur % N;
                sum += Math.abs(i-x) + Math.abs(j-y);
            }
        }
        return sum;
    }

    @Override
    public int estimatedDistanceToGoal(){
        return manhattan();
    }

    @Override
    public boolean equals(Object y){
        if (this == y) {
            return true;
        }
        if (y == null || getClass() != y.getClass()) {
            return false;
        }

        Board t = (Board) y;
        int N = size();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(tileAt(i,j)!= t.tileAt(i,j)) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

    public static void main(String[] args){
        int[][] tiles = new int[][]{{8,1,3},{4,0,2},{7,6,5}};
        Board test = new Board(tiles);


       for(WorldState next : test.neighbors()){
           System.out.println(next.toString());
       }
    }

}
