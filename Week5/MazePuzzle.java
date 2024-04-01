package Week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MazePuzzle {

    private char[][] maze = {
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
            { '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#' },
            { 'S', '.', '#', '.', '#', '.', '#', '#', '#', '#', '#', '#', '#', '.', '#' },
            { '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#' },
            { '#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '#', '.', '.', '.', 'E' },
            { '#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '#' },
            { '#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#', '#', '.', '#' },
            { '#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '.', '#' },
            { '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '.', '#' },
            { '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#', '#', '.', '#' },
            { '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#' },
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
    };

    private final Cell startingPosition;
    private final Cell endPosition;

    private final int[][] directions = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public MazePuzzle() {
        this.startingPosition = new Cell(2, 0);
        this.endPosition = new Cell(4, 14);
    }

    // public boolean solveAStart() {

    // }

    public boolean solveDFS() {

        Stack<Cell> stack = new Stack<>();
        List<Cell> visitedCells = new ArrayList<>();

        stack.add(startingPosition);

        while(!stack.isEmpty()) {
            Cell cell = stack.pop();
            if (visitedCells.contains(cell)) {
                continue;
            }
            if (cell.equals(endPosition)){ 
                return true;
            }
            visitedCells.add(cell);
            for (int[] direction : directions) {
                int x = cell.x + direction[0];
                int y = cell.y + direction[1];
                Cell neighbourCell = new Cell(x, y);
                if (!checIfMoveInBounds(neighbourCell) && !(checkIfMoveInWall(neighbourCell))) {
                    if (!visitedCells.contains(neighbourCell)) {
                        stack.add(neighbourCell);
                    }
                }
            }
        }
        return false;
    }

    private boolean checIfMoveInBounds(Cell cell) {
        return cell.x < 0 || cell.x >= maze.length || cell.y < 0 || cell.y >= maze[0].length;
    }

    private boolean checkIfMoveInWall(Cell cell) {
        return maze[cell.x][cell.y] == '#';
    }

    public static void main(String[] args) {
        MazePuzzle puzzle = new MazePuzzle();
        System.out.println(puzzle.solveDFS());
    }

    static class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        


        @Override
        public String toString() {
            return "Cell [x=" + x + ", y=" + y + "]";
        }




        @Override
        public boolean equals(Object object) {
            if (object instanceof Cell) {
                Cell cell = (Cell) object;
                if (x == cell.x && y == cell.y) {
                    return true;
                }
            }
            return false;
        }
    }
}
