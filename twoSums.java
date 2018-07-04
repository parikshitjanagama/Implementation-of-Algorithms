package LeetCode;

import java.util.Arrays;

public class twoSums {
	int[] nums = { 2, 3, 4 };
	int target = 5;

public int[] twoSum(int[] nums, int target) {
        
        Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
				if (nums[i] + nums[i+1] == target) {
					int[] A = { i, i+1 };
					return A;
				}
        
                else if(nums[i] + nums[i+1] > target){
                                        
		                  throw new IllegalArgumentException("No two sum solution");
                }
                else if(nums[i] + nums[i+1] < target){
                    i++;
                }

        }
                 throw new IllegalArgumentException("No two sum solution");

			}


}
