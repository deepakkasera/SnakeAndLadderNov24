package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int dimension;
    private Map<Integer, BoardEntity> boardEntityMap;
    private int cellCount;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cellCount = dimension * dimension;
        boardEntityMap = new HashMap<>();

        //Add n snakes and n ladders to the board.
        addSnakesAndLadders();
    }

    private void addSnakesAndLadders() {
        // Snake -> start > end
        // Ladder -> end > start

        for (int i = 0; i < dimension; i++) {
            //Ladders
            int min = 2;
            int max = cellCount - 1;

            int start = (int) (Math.random() * (max - min + 1) + min);
            min = start + 1;
            int end = (int) (Math.random() * (max - min + 1) + min);

            if (!hasSnakeOrLadder(start)) {
                boardEntityMap.put(start, new Ladder(start, end));
            }

            //Snakes
            min = 2;
            max = cellCount - 1;
            end = (int) (Math.random() * (max - min + 1) + min); // 20
            min = end + 1;
            start = (int) (Math.random() * (max - min + 1) + min);

            if (!hasSnakeOrLadder(start)) {
                boardEntityMap.put(start, new Snake(start, end));
            }

            //startIndexS endIndexS startIndexL endIndexL
            //TODO: Try to cover few more edge cases.
        }

    }

    public void print() {

    }

    public boolean hasSnakeOrLadder(int index) {
        return boardEntityMap.containsKey(index);
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Map<Integer, BoardEntity> getBoardEntityMap() {
        return boardEntityMap;
    }

    public void setBoardEntityMap(Map<Integer, BoardEntity> boardEntityMap) {
        this.boardEntityMap = boardEntityMap;
    }

    public int getCellCount() {
        return cellCount;
    }

    public void setCellCount(int cellCount) {
        this.cellCount = cellCount;
    }
}
