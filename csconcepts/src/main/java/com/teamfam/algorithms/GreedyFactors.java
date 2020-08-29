package com.teamfam.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the all possible factors of a number N based on all numbers defined
 * in a set S.
 */
public class GreedyFactors{

    /**
     * Gather all possible factors of a number N based on a set of provided candidate numbers. Repetition of a candidate 
     * can occur to sum to the target.
     * 
     * @param target the number to sum
     * @param candidateSet the set of numbers to build the sum off of
     */
    public <N extends Number,S extends Set<N>> Set<Set<N>> getFactors(N target, S candidateSet){
        Set<Set<N>> solutionSet = new HashSet<Set<N>>();
        for(N number : candidateSet){
            
        }
        return solutionSet;
    }
}