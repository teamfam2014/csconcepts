package com.teamfam.algorithms.greedy;

import java.util.Map;

/**
 * Make sure that we are able to get the minimum amount of coins as change to the 
 * inputs provided. The coins that we are using are pennies (0.01), nickels (0.05), dimes (0.10), and
 * quarters (0.25). Make use of the Coin.java class provided when creating your solution.
 */
public class GreedyChangeMakerDriver {
    
    public static void main(String[] args){
        GreedyChangeMaker changeMaker = new GreedyChangeMaker();
        double amount = 1.23d;
        Map<Coin,Integer> change = changeMaker.makeChange(amount);
        StringBuilder message = new StringBuilder("I have ");
        for (Coin coin : change.keySet()){
            message.append(change.get(coin));
            message.append(" ");
            message.append(coin);
            message.append(", ");
        }
        message.append(" all from ");
        message.append(amount);

        System.out.println(message);
    }
}
