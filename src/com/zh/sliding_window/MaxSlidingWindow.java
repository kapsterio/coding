package com.zh.sliding_window;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {
    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public Integer getValue() {
            return value;
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::getValue).reversed());

        for (int index = 0; index < k; index ++) {
            queue.add(new Node(nums[index], index));
        }

        int[] result = new int[nums.length - k + 1];
        for (int left = 0; left < result.length; left ++) {
            int right = left + k - 1;
            queue.add(new Node(nums[right], right));
            while (queue.peek().index < left) {
                queue.poll();
            }
            result[left] = queue.peek().value;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
