package com.libleetcode.string;

//回文字符串
 class Huiwen {

    static final String datas = "A man, a plan, a canal: Panama";

    public static void main(String[] args) {
        String tmp = datas.toLowerCase().replaceAll("[^0-9a-z]", "");
//        System.out.println("tmp = "+tmp);
        int point1 = 0;
        int point2 = tmp.length() - 1;
        while (point1 < point2) {
            if (tmp.charAt(point1++) != tmp.charAt(point2--)) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }
}