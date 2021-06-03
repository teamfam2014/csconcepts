package com.teamfam.algorithms.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a greedy change make that will provide the minimum amount of change
 * for a given amount.
 * 
 * f(x) = Max(a) + Max(b) + Max(c) + Max(d)
 * where a = 0.01 (penny)
 * and b = 0.05 (nickel)
 * and c = 0.10 (dime)
 * and d = 0.25 (quarter)
 * 
 * @author teamfam
 */
public class GreedyChangeMaker {
    
    /**
     * Return a map containing the minimum number of coins required for an amount. If the amount is 
     * 0 or below then return null.
     * 
     * @param amount The amount to provide change for
     */
    public Map<Coin,Integer> makeChange(double amount){
        if (amount <= 0){
            return null;
        }

        Map<Coin,Integer> changeMap = new HashMap<Coin,Integer>();

        if (Coin.QUARTER.getValue() / amount > 0){
            int numQuarters = (int)(Coin.QUARTER.getValue() / amount);
            changeMap.put(Coin.QUARTER, numQuarters);
            changeMap.putAll(makeChange(Coin.QUARTER.getValue() % amount));
        }else if(Coin.DIME.getValue() / amount > 0){
            int numDimes = (int)(Coin.DIME.getValue() / amount);
            changeMap.put(Coin.DIME, numDimes);
            changeMap.putAll(makeChange(Coin.DIME.getValue() % amount));
        }else if(Coin.NICKEL.getValue() / amount > 0){
            int numNickels = (int)(Coin.NICKEL.getValue() / amount);
            changeMap.put(Coin.NICKEL, numNickels);
            changeMap.putAll(makeChange(Coin.NICKEL.getValue() % amount));
        }else{
            int numPennies = (int)(Coin.PENNY.getValue() / amount);
            changeMap.put(Coin.PENNY, numPennies);
        }

        return changeMap;
    }
}
