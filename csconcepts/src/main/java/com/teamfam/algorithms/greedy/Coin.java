package com.teamfam.algorithms.greedy;

/**
 * Represent the coin and its value.
 */
public enum Coin {
    QUARTER,
    DIME,
    NICKEL,
    PENNY;

    /**
     * Return the value of the enum.
     * @return the value represented by the enum.
     */
    public double getValue(){
        switch(this){
            case QUARTER: 
                return 0.25;
            case DIME:
                return 0.10;
            case NICKEL:
                return 0.05;
            case PENNY:
                return 0.01;
            default:
                throw new RuntimeException("Invalid coin used.");
        }
    }
}
