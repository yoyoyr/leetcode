package com.libleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//单词拆分
class DanCiCaiFen2 {

    static String s = "pineapplepenapple";
    static List<String> wordDict = new ArrayList();
    static HashSet<String> set;
    static HashMap<Integer, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");

        set = new HashSet<>(wordDict);

        System.out.println("word = " + s);
        List<String> words = word_Break(0);
        if (words != null) {
            System.out.println("words = " + words);
        }
    }

    public static List<String> word_Break(int start) {

        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }

        for (int i = start; i <= s.length(); ++i) {
            String tmp = s.substring(start, i);
            if (set.contains(tmp)) {
                List<String> words = word_Break(i);
                for (String word : words) {
                    res.add((tmp + " " + word).trim());
                }
            }
        }

        map.put(start, res);
        return res;
    }
}
