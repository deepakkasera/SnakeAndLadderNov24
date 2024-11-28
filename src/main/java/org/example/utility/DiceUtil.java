package org.example.utility;

public class DiceUtil {
    public static int roll(int numberOfDices) {
        int sum = 0;
        for (int i = 0; i < numberOfDices; i++) {
            sum += (int) (Math.random() * 6) + 1;
        }
        return sum;
    }
}

// Math.random() -> [0, 1)

// 0.8 * 6 + 1 = 5.8 = 6
