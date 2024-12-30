package hackerrank.others;

import java.util.*;

public class CastleOnGrid {

    static String[][] castle = {
            {".",".","."},
            {".","X","."},
            {".",".","."}
    };

    static boolean[][] visited = new boolean[3][3];

    static List<int[]> possibleAdjacents = new ArrayList<>(
            Arrays.asList(
                    new int[]{1,0},
                    new int[]{-1,0},
                    new int[]{0,1},
                    new int[]{0,-1}
            )
    );

    public static void main(String[] args) {
        System.out.println(minimumMoves(0,0,1,2));
    }

    static int minimumMoves(int currentX, int currentY, int goalX, int goalY){

        int minimumMoves = 0;

        //map holds current x and y and the counter for them

        if(goalReached(goalX, goalY, currentX, currentY)) {
            return 0;
        }

        Queue<int[]> path = new LinkedList<>();
        populateAdjacents(path, currentX, currentY);
        markVisited(currentX, currentY);
        do {
            //if queue not empty?
            int[] cell = path.poll();
            currentX = cell[0];
            currentY = cell[1];
            populateAdjacents(path, currentX, currentY);

            markVisited(currentX, currentY);
        } while(!goalReached(goalX, goalY, currentX, currentY));

        return minimumMoves;
    }

    static void populateAdjacents(Queue<int[]> path, int currentX, int currentY){
        for (int i = 0; i < possibleAdjacents.size(); i++) {
            int[] coordinatesXY = possibleAdjacents.get(i);
            int xCandidate = currentX + coordinatesXY[0];
            int yCandidate = currentY + coordinatesXY[1];
            if(inBounds(xCandidate,  yCandidate)
                    && !currentCellBlocked(xCandidate, yCandidate)
                    && !currentCellVisited(xCandidate, yCandidate)){

                path.offer(new int[]{xCandidate, yCandidate});
            }
        }
    }

    static int moveX(int currentX, int stepX) {
        return currentX + stepX;
    }

    static int moveY(int currentY, int stepY){
        return currentY + stepY;
    }

    static boolean goalReached(int goalX, int goalY, int currentX, int currentY){
        return currentX == goalX && currentY == goalY;
    }

    static void markVisited(int currentX, int currentY) {
        visited[currentX][currentY] = true;
    }
    static boolean currentCellVisited(int currentX, int currentY){
        return visited[currentX][currentY];
    }

    static boolean currentCellBlocked(int currentX, int currentY){
        return castle[currentX][currentY].equals("X");
    }

    static boolean inBounds(int currentX, int currentY){
        return (currentX >= 0 && currentX <= 2) && (currentY >= 0 && currentY <= 2);
    }

    private static class XYAndMoves {
        private int x;
        private int y;
        private int moves;

        public XYAndMoves(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getMoves() {
            return moves;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setCounter(int moves) {
            this.moves = moves;
        }
    }
}