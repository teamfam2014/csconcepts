package com.teamfam.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find the all possible factors of an Integer based on all integers defined
 * in a set of candidates.
 */
public class AllFactors{

    /**
     * Gather all possible factors of an Integer based on a set of provided candidate integers. Repetition of a candidate 
     * can occur to sum to the target.
     * 
     * @param target the integer to sum up to
     * @param candidateSet the set of integers to build the sum off of
     */
    public Set<List<Integer>> getFactors(Integer target, Set<Integer> candidateSet){
        Set<List<Integer>> solutionSet = new HashSet<List<Integer>>();
        for(Integer candidate : candidateSet){
            List<Integer> factors = new ArrayList<Integer>();
            if (candidate == target){
                factors.add(candidate);
            }else if(target % candidate == 0){
                //Candidate is a factor of the target. Get the other factor by dividing target into candidate
                int factor = target / candidate;
                for(int index = 0; index < factor; index++){
                    factors.add(candidate);
                }
            }else{
                //Candidate is not a factor of the target. Get the remainder, and get the multiple
                int factor = target / candidate;
                int remainder = target % candidate;
                if (candidateSet.contains(remainder)){
                    //ensure that the factor is added and the remainder are added 
                    for(int index = 0; index < factor; index++){
                        factors.add(candidate);
                    }
                    factors.add(remainder);
                }//else{
                /*    //we need to break down the remainder to see if there are elements in the candidate set that add to the remainder                    
                    Set<Set<Integer>> remainderFactorsSolutionSet = getFactors(remainder,candidateSet);
                    for(Set<Integer> remainderFactorSet : remainderFactorsSolutionSet){
                        //ensure that the factors are added each time
                        for(int index = 0; index < factor; index++){
                            factors.add(candidate);
                        }                        
                        factors.addAll(remainderFactorSet);
                    }
                }*///
            }
            solutionSet.add(factors);
        }
        return solutionSet;
    }
}