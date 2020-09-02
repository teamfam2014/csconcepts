package com.teamfam.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Validate that all scenarios of the Greedy Factors class
 * are covered.
 */
public class AllFactorsTest {
    
    /**
     * If the candidate set contains the target, then it is included in the
     * solution set.
     */
    @Test
    public void targetInCandidate(){
        //ARRANGE
        AllFactors gf = new AllFactors();
        Integer target = 5;
        Set<Integer> candidateSet = new HashSet<>();
        candidateSet.add(target);
        //ACT
        Set<List<Integer>> solutionSet = gf.getFactors(target, candidateSet);
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
        AllFactors gf = new AllFactors();
        Integer target = 10;
        Integer targetFactor = 5;
        Set<Integer> candidateSet = new HashSet<>();
        candidateSet.add(targetFactor);
        //ACT
        Set<List<Integer>> solutionSet = gf.getFactors(target, candidateSet);
        //ASSERT
        assertFalse(solutionSet.isEmpty());
        assertTrue(solutionSet.size() == 1);
        solutionSet.forEach(factors ->{
            assertTrue(factors.size() == 2);
            factors.forEach(factor -> {
                assertEquals(targetFactor,factor);
            });
        });
    } 
    
    /**
     * If the candidate set contains numbers that are not factors of the target
     * but still add up to the target together, then return the set of those factors
     * in the solution set.
     */
    @Test
    public void candidateContainsNonFactors(){
        //ARRANGE
        AllFactors gf = new AllFactors();
        Integer target = 5;
        Set<Integer> candidateSet = new HashSet<>();
        candidateSet.add(1);
        candidateSet.add(2);
        candidateSet.add(3);
        candidateSet.add(4);
        candidateSet.add(5);
        Set<List<Integer>> expectedSolutionSet = new HashSet<>();
        expectedSolutionSet.add(List.of(1,1,1,1,1));        
        expectedSolutionSet.add(List.of(1,4));
        expectedSolutionSet.add(List.of(1,2,2));
        expectedSolutionSet.add(List.of(1,1,1,2));
        expectedSolutionSet.add(List.of(2,2,1));
        expectedSolutionSet.add(List.of(2,3));
        expectedSolutionSet.add(List.of(3,2));
        expectedSolutionSet.add(List.of(3,1,1));
        expectedSolutionSet.add(List.of(4,1));
        expectedSolutionSet.add(List.of(5));
        //ACT
        Set<List<Integer>> solutionSet = gf.getFactors(target, candidateSet);
        //ASSERT
    }

}