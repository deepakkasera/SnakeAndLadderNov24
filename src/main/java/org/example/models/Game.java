package org.example.models;

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
