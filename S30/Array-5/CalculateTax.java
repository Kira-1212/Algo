// Time Complexity : O(n)    
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make simple math and lists to solve this


import java.io.*;

import java.util.*;



class GFG {

	public static void main (String[] args) {

		List<List<Double>> levels = new ArrayList<>();

        levels.add( Arrays.asList(10000.0, 0.3) );

        levels.add( Arrays.asList(20000.0, 0.2) );

        levels.add( Arrays.asList(30000.0, 0.1) );

        levels.add( Arrays.asList(null, 0.1) );

        double tax = calculateTax(levels,45000);

        System.out.println(tax);

	}

	public static double calculateTax(List<List<Double>> levels, double salary ){

        double left = salary;

        double tax = 0;

        double limit=0;

        int i = 0;

        while(left > 0){

            List<Double> level = levels.get(i);

            double percent = level.get(1);

            if(level.get(0)==null){

                tax += left*percent;

                return tax;

            }

            double currRange = level.get(0) - limit;

            double currSalary = Math.min(left, currRange);

            tax += currSalary*percent;

            left -= currSalary;

            limit = level.get(0);

            i++;

        }

        return tax;        

    }

}

