package com.zh.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 滑动窗口
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {
    //o(n^2)
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i ++) {
            int length = maxLength(s, i);
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    private int maxLength(String s, int index) {
        Set<Character> characters = new HashSet<>();
        while (index < s.length()) {
            if (characters.contains(s.charAt(index))) {
                return characters.size();
            }
            characters.add(s.charAt(index));
            index ++;
        }
        return characters.size();
    }


    //o(n)
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> characters = new HashMap<>();
        //characters.put(s.charAt(right), right);
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!characters.containsKey(c)) {
                right ++;
                characters.put(c, right);
                max = Math.max(right - left + 1, max);
            } else {
                int newLeft = characters.get(c) + 1;
                for (int index = left; index < newLeft; index ++) {
                    characters.remove(s.charAt(index));
                }
                left = newLeft;
            }
        }
        return max;
    }
}
