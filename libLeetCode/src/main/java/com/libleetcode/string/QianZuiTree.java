package com.libleetcode.string;

public class QianZuiTree {

    public static void main(String[] args) {
        QianZuiTree.Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }


    public static class Trie {

        TreeNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TreeNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TreeNode node = root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                if (node.getTreeNode(chars[i]) != null) {
                    node = node.getTreeNode(chars[i]);
                } else {
                    node = node.setC(chars[i]);
                }
//            System.out.println("node = "+node.c);
            }
            node.setWord(true);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TreeNode node = root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                if ((node = node.getTreeNode(chars[i]) )== null) {
                    return false;
                }

            }
            return node.isWord();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TreeNode node = root;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                if ((node = node.getTreeNode(chars[i])) == null) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class TreeNode {
        TreeNode[] treeNodes = new TreeNode[26];
        boolean isWord = false;
        char c;

        public TreeNode getTreeNode(char c) {
            return treeNodes[c - 'a'];
        }

        public TreeNode setC(char c) {
            TreeNode treeNode = new TreeNode();
            treeNode.c = c;
            treeNodes[c - 'a'] = treeNode;
            return treeNodes[c - 'a'];
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }

}

//Trie trie = new Trie();
//trie.insert("apple");
//        trie.search("apple");   // 返回 true
//        trie.search("app");     // 返回 false
//        trie.startsWith("app"); // 返回 true
//        trie.insert("app");
//        trie.search("app");     // 返回 true
