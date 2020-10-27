package com.libleetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//单词拆分
class DanCiCaiFen {

        static String s = "catsandog";
//    static String s = "leetcode";
    static List<String> wordDict = new ArrayList();
    static HashSet<String> set;

    public static void main(String[] args) {
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("cat");
//        wordDict.add("leet");
//        wordDict.add("code");

        set = new HashSet<>(wordDict);
//        System.out.println("rlt = " + divWords(s));
        System.out.println("rlt = " + dpDivWords());
    }

    static boolean divWords(String datas) {

        if (datas.equalsIgnoreCase(""))
            return true;
        boolean rlt = false;
        for (int i = 1; i <= datas.length(); ++i) {
            String sub = datas.substring(0, i);
            if (set.contains(sub)) {
                rlt = rlt || divWords(datas.substring(i));
            }
        }

        return rlt;
    }

    //dp[n] n位置字符串可否被划分为在wordDict数组里面
    //dp[i] = dp[j] && wordDic.contain(s.substring(j,i-1))
    static boolean dpDivWords() {
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (set.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (dp[j] && set.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

        }

        return dp[n - 1];
    }
}
