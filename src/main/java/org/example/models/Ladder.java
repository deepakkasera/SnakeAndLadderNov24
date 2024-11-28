package org.example.models;

public class Ladder extends BoardEntity {

    public Ladder(int start, int end) {
        super(start, end);
        this.setBoardEntityType(BoardEntityType.LADDER);
    }

    @Override
    public void printMessage() {
        System.out.println("Encountered Ladder");
    }
}
