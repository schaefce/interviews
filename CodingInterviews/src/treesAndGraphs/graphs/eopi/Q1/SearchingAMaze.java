package treesAndGraphs.graphs.eopi.Q1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * Given a 2D array of black and white entries representing a maze with
 * designated entrance and exit points, find a path from the entrance to the
 * exit, if one exists
 */

public class SearchingAMaze {
    public static LinkedList<Coordinate> searchDFS(int[][] maze,
            Coordinate start, Coordinate end) {
        LinkedList<Coordinate> path = new LinkedList<Coordinate>();
        maze[start.x][start.y] = 1; // Mark start as visited
        path.add(start);
        if (searchDFSHelper(maze, start, end, path)) {
            return path;
        }
        path.pop();
        return path;
    }

    private static boolean searchDFSHelper(int[][] maze, Coordinate curr,
            Coordinate end, LinkedList<Coordinate> path) {
        if (curr.equals(end)) {
            return true;
        }
        int[][] shifts = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < 4; i++) {
            Coordinate next = new Coordinate(curr.x + shifts[i][0], curr.y
                    + shifts[i][1]);
            if (isFeasible(maze, next)) {
                path.add(next);
                maze[curr.x][curr.y] = 1;
                if (searchDFSHelper(maze, next, end, path)) {
                    return true;
                }
                path.pop();
            }
        }
        return false;
    }

    private static boolean isFeasible(int[][] maze, Coordinate move) {
        return (move.x >= 0 && move.y >= 0 && move.x < maze.length
                && move.y < maze[0].length && maze[move.x][move.y] == 0);
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[][] maze = { { 1, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 },
                { 1, 0, 1, 0, 1, 0 }, { 1, 0, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 0, 0 } };
        int n = 5;
        int m = 6;
        List<Coordinate> white = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (maze[i][j] == 0) {
                    white.add(new Coordinate(i, j));
                }
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        LinkedList<Coordinate> path = searchDFS(maze, new Coordinate(4, 0),
                new Coordinate(0, 5));
        Coordinate prev = null;
        for (Coordinate curr : path) {
            if (prev != null) {
                assert (Math.abs(prev.x - curr.x) + Math.abs(prev.y - curr.y) == 1);
            }
            prev = curr;
            System.out.println("(" + curr.x + "," + curr.y + ")");
        }
    }

}
