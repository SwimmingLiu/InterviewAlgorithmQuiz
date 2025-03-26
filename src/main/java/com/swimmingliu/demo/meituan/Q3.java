package com.swimmingliu.demo.meituan;

import java.util.HashSet;
import java.util.Scanner;

public class Q3 {
    // AHHAMTT
//    private static int findAnswer(String str){
//        String temp = "AHIMOTUVWX";
//        for (char c : temp.toCharArray()) {
//            set.add(c);
//        }
//        int len = str.length();
//        char[] s = str.toCharArray();
//        int[] f = new int[len + 1];
//        for (int i = 0; i < len; i ++){
//            if (!set.contains(s[i])) continue;
//            f[i + 1] = f[i];
//            if (f[i] != 0 && i - 1 >= 0 && f[i] != f[i - 1]) {
//                int index = i - 2 * f[i] - 1;
//                if (index >= 0 && s[index] == s[i])
//                    f[i + 1] = f[i] + 1;
//            }
//            if (i != 0 && s[i] == s[i - 1]) f[i + 1] += 1;
//        }
//        return f[len];
//    }
    private static HashSet<Character> set = new HashSet<>();
    private static int findAnswer(String str){
        String temp = "AHIMOTUVWX";
        for (char c : temp.toCharArray()) {
            set.add(c);
        }
        int len = str.length();
        int res = 0;
        for (int i = 0; i < len; i ++){
            for (int j = i + 1; j < len; j ++)
                res += isValid(str.substring(i, j + 1)) ? 1 : 0;
        }
        return res;
    }
    private static boolean isValid(String str){
        int l = 0, r = str.length() - 1;
        while (l < r){
            char left = str.charAt(l);
            char right = str.charAt(r);
            if (left != right || !set.contains(left) || !set.contains(right))
                return false;
            l ++;
            r --;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "AHHAMTT";
        System.out.println(findAnswer(str));
    }
}
