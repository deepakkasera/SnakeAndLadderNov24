package org.example.models;

import org.example.utility.DiceUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Queue<Player> winners;
    private int numberOfDices;
    private int dimension;

    public Game(int dimension, int numberOfDices, Queue<Player> players) {
        this.dimension = dimension;
        this.numberOfDices = numberOfDices;
        this.players = players;
        this.board = new Board(dimension);
        this.winners = new LinkedList<>();
    }

    public void start() {
        this.board.print();

        while (players.size() > 1) {
            Player currentPlayer = players.poll();

            System.out.println("This is " + currentPlayer.getName() + "'s turn");

            int dice = DiceUtil.roll(numberOfDices);

            System.out.println(currentPlayer.getName() + " got " + dice + " on the dice.");

            int finalPosition = currentPlayer.getPosition() + dice;

            if (finalPosition <= this.board.getCellCount()) {
                //Check if there's a snake or a ladder present at finalPosition.
                if (this.board.hasSnakeOrLadder(finalPosition)) {
                    BoardEntity boardEntity = this.board.getBoardEntityMap().get(finalPosition);

//                if (boardEntity.getBoardEntityType().equals(BoardEntityType.SNAKE)) {
//                    System.out.println("You encountered a snake at " + finalPosition);
//                } else {
//                    System.out.println("You encountered a Ladder at " + finalPosition);
//                }

                    boardEntity.printMessage();
                    finalPosition = boardEntity.getEnd();
                }

                //Change the position of the player to the final position.
                currentPlayer.setPosition(finalPosition);
            } else {
                //SKIP THE MOVE
                System.out.println("Try again, You can't go outside the board.");
                finalPosition = currentPlayer.getPosition();
            }

            if (finalPosition == this.board.getCellCount()) {
                //Player has WON the game.
                System.out.println(currentPlayer.getName() + " has WON the game!!");
                winners.add(currentPlayer);
            } else {
                players.add(currentPlayer);
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public Queue<Player> getWinners() {
        return winners;
    }

    public void setWinners(Queue<Player> winners) {
        this.winners = winners;
    }

    public int getNumberOfDices() {
        return numberOfDices;
    }

    public void setNumberOfDices(int numberOfDices) {
        this.numberOfDices = numberOfDices;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
