package com.zh.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char needChar = s1.charAt(i);
            target.put(needChar,target.getOrDefault(needChar,0)+1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {
            Character c = s2.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right ++;
            if(target.containsKey(c) && window.get(c).equals(target.get(c))){
                valid++;
            }
            //check if exist
            if (valid == window.size()) {
                return true;
            }
            //check if reduce
            if (right - left > s1.length()) {
                Character removeChar = s2.charAt(left);
                if(target.containsKey(removeChar) && window.get(removeChar).equals(target.get(removeChar))){
                    valid--;
                }
                window.put(removeChar,window.get(removeChar) - 1);
                left ++;
            }
        }
        return false;
    }
}
