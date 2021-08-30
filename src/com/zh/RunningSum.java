package com.zh;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        int[] result = new int[nums.length];
        for (int index = 0; index < nums.length; index ++) {
            if (index == 0) {
                result[index] = nums[index];
            } else {
                result[index] = result[index - 1] + nums[index];
            }
        }
        return result;
    }
}
