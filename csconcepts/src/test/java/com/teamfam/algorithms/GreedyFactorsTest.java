package com.teamfam.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Validate that all scenarios of the Greedy Factors class
 * are covered.
 */
public class GreedyFactorsTest {
    
    /**
     * If the candidate set contains the target, then it is included in the
     * solution set.
     */
    @Test
    public void targetInCandidate(){
        //ARRANGE
        GreedyFactors gf = new GreedyFactors();
        Integer target = 5;
        Set<Integer> candidateSet = new HashSet<>();
        candidateSet.add(target);
        Set<Set<Integer>> expectedSolutionSet = new HashSet<>();
        Set<Integer> targetSet = new HashSet<>();
        targetSet.add(target);
        expectedSolutionSet.add(targetSet);
        //ACT
        Set<Set<Integer>> solutionSet = gf.getFactors(target, candidateSet);
        //ASSERT
        assertFalse(solutionSet.isEmpty());
        assertTrue(solutionSet.size() == 1);
        solutionSet.forEach(factors ->{
            assertTrue(factors.size() == 1);
            factors.forEach(factor -> {
                assertEquals(target,factor);
            });
        });
    }

    /**
     * If the candidate set contains a number that is a factor of the target
     * then return the set of factors in the solution set. 
     */
    @Test
    public void candidateContainsFactor(){
        //ARRANGE
        GreedyFactors gf = new GreedyFactors();
        Integer target = 10;
        Integer targetFactor = 5;
        Set<Integer> candidateSet = new HashSet<>();
        candidateSet.add(targetFactor);
        Set<Set<Integer>> expectedSolutionSet = new HashSet<>();
        Set<Integer> targetSet = new HashSet<>();
        targetSet.add(targetFactor);
        targetSet.add(targetFactor);
        expectedSolutionSet.add(targetSet);
        //ACT
        Set<Set<Integer>> solutionSet = gf.getFactors(target, candidateSet);
        //ASSERT
        assertFalse(solutionSet.isEmpty());
        assertTrue(solutionSet.size() == 1);
        solutionSet.forEach(factors ->{
            assertTrue(factors.size() == 1);
            factors.forEach(factor -> {
                assertEquals(targetFactor,factor);
            });
        });
    }    
}