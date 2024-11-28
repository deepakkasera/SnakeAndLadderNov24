package org.example;

import org.example.models.Game;
import org.example.models.Player;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int numberOfDice = 1;
        int dimension = 10;

        Player p1 = new Player("Rani", 0);
        Player p2 = new Player("Ganga", 0);

        Queue<Player> players = new LinkedList<>();

        players.add(p1);
        players.add(p2);

        Game game = new Game(dimension, numberOfDice, players);

        game.start();
    }
}