package com.teamfam.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the all possible factors of an Integer based on all integers defined
 * in a set of candidates.
 */
public class GreedyFactors{

    /**
     * Gather all possible factors of an Integer based on a set of provided candidate integers. Repetition of a candidate 
     * can occur to sum to the target.
     * 
     * @param target the integer to sum up to
     * @param candidateSet the set of integers to build the sum off of
     */
    public Set<Set<Integer>> getFactors(Integer target, Set<Integer> candidateSet){
        Set<Set<Integer>> solutionSet = new HashSet<Set<Integer>>();
        for(Integer candidate : candidateSet){
            Set<Integer> factors = new HashSet<Integer>();
            if (candidate == target){
                factors.add(candidate);
            }else if(target % candidate == 0){
                //Candidate is a factor of the target. Get the other factor by dividing candidate into target
                int factor = candidate / target;
                for(int index = 0; index <= factor; index++){
                    factors.add(candidate);
                }
            }else{
                //Candidate is not a factor of the target. Get the remainder, and get the multiple
            }
            solutionSet.add(factors);
        }
        return solutionSet;
    }
}