package com.libleetcode.string;

class FindWords {
    //    输入:
//    words = ["oath","pea","eat","rain"] and board =
//        [
//        ['o','a','a','n'],
//        ['e','t','a','e'],
//        ['i','h','k','r'],
//        ['i','f','l','v']
//        ]
//
//    输出: ["eat","oath"]
    public static void main(String[] args) {
        char[][] board = new char[4][4];
        board[0][0] = 'o';
        board[0][1] = 'a';
        board[0][2] = 'a';
        board[0][3] = 'n';
        board[1][0] = 'e';
        board[1][1] = 't';
        board[1][2] = 'a';
        board[1][3] = 'e';
        board[2][0] = 'i';
        board[2][1] = 'h';
        board[2][2] = 'k';
        board[2][3] = 'r';
        board[3][0] = 'i';
        board[3][1] = 'f';
        board[3][2] = 'l';
        board[3][3] = 'v';
        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        QianZuiTree.Trie trie = new QianZuiTree.Trie();
        for (int i = 0; i < 4; ++i) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < 4; ++j) {
                word.append(board[i][j]);
            }
            System.out.println("insert = "+word.toString());
            trie.insert(word.toString());
        }

        for (int i = 0; i < 4; ++i) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < 4; ++j) {
                word.append(board[j][i]);
            }
            System.out.println("insert = "+word.toString());
            trie.insert(word.toString());
        }

        for (int i = 0; i < words.length; ++i) {
            if(trie.startsWith(words[i])){
                System.out.println(words[i]);
            }
        }
    }
}

