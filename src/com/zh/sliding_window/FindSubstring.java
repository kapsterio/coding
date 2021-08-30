package com.zh.sliding_window;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 */
public class FindSubstring {

    public static void main1(String[] args) {
        List<Integer> result = findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        System.out.println(result);
    }

    public static void main(String[] args) {

        System.out.println(match("wordgoodgoodgoodbestword", 8, new String[]{"word","good","best","good"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int length = words[0].length();
        int num = words.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - length * num; i++ ) {
            if (match(s, i, words)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean match(String s, int begin, String[] words) {
        int length = words[0].length();
        int num = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (int index = 0; index < num; index ++) {
            String word = s.substring(begin + index * length, begin + (index + 1) * length);
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (String word: words) {
            if (!map.containsKey(word)) {
                return false;
            } else {
                map.computeIfPresent(word, (w, old) -> old  - 1 > 0 ?  old - 1 : null);
            }
        }
        return map.isEmpty();
    }
}
