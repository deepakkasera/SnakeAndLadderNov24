package org.example.models;

public class Snake extends BoardEntity {

    public Snake(int start, int end) {
        super(start, end);
        this.setBoardEntityType(BoardEntityType.SNAKE);
    }

    @Override
    public void printMessage() {
        System.out.println("Encountered Snake");
    }

    @Override
    public void printEntity() {
        System.out.print("S(" + getEnd() + ") ");
    }
}
