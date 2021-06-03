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
            int numQuarters = (int)(amount / Coin.QUARTER.getValue());
            changeMap.put(Coin.QUARTER, numQuarters);
            changeMap.putAll(makeChange(amount % Coin.QUARTER.getValue()));
        }else if(amount / Coin.DIME.getValue() > 0){
            int numDimes = (int)(amount / Coin.DIME.getValue());
            changeMap.put(Coin.DIME, numDimes);
            changeMap.putAll(makeChange(amount % Coin.DIME.getValue()));
        }else if(amount / Coin.NICKEL.getValue() > 0){
            int numNickels = (int)(amount / Coin.NICKEL.getValue());
            changeMap.put(Coin.NICKEL, numNickels);
            changeMap.putAll(makeChange(amount % Coin.NICKEL.getValue()));
        }else{
            int numPennies = (int)(amount / Coin.PENNY.getValue());
            changeMap.put(Coin.PENNY, numPennies);
        }

        return changeMap;
    }
}
