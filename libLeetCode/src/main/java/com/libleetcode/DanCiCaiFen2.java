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
            System.out.println("tmp = " + tmp);
            if (set.contains(tmp)) {
                List<String> list = word_Break(i);
                for (String word : list) {//最终不匹配，list为空，不进入循环
//                    System.out.println("tmp = " + tmp);
//                    System.out.println("word = " + word);
                    StringBuilder words = new StringBuilder();
                    words.append(tmp + " ").append(word);
                    res.add(words.toString().trim());
                }
            }
        }
        map.put(start, res);
        return res;
    }

}
