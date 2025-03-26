package com.swimmingliu.demo.meituan;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Q1 {
    // AHHAMTT
    private static HashSet<Character> set = new HashSet<>();
    private static int findAnswer(String str){
        String temp = "AHIMOTUVWX";
        for (char c : temp.toCharArray()) {
            set.add(c);
        }
        int len = str.length();
        char[] s = str.toCharArray();
        int[] f = new int[len + 1];
        for (int i = 0; i < len; i ++){
            if (!set.contains(s[i])) continue;
            f[i + 1] = f[i];
            if (f[i] != 0 && i - 1 >= 0 && f[i] != f[i - 1]) {
                int index = i - 2 * f[i] - 1;
                if (index >= 0 && s[index] == s[i])
                    f[i + 1] = f[i] + 1;
            }
            if (i != 0 && s[i] == s[i - 1]) f[i + 1] += 1;
        }
        return f[len];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(findAnswer(str));
    }
}
