package com.suanfa;

import java.util.Scanner;

public class IsDeformation {

    //判断是否为变形词
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] s = str.split(" ");
        String a = s[0];
        String b = s[1];
        isDeformation(a, b);
    }
    public static void isDeformation(String a, String b){
        if (a ==null || b == null ||a.length() != b.length()){
            System.out.println(false);
        }
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < a1.length; i++){
            map[a1[i]]++;
        }
        for (int i = 0; i < b1.length; i++){
            if (map[b1[i]] == 0){
                System.out.println(false);
                return;
            }else if (map[b1[i]] != 0){
                map[b1[i]]--;
                System.out.println(true);
                return;
            }
        }
        /*for (int i =0; i < map.length; i++){
            if (map[i] == 0){
                System.out.println(true);
                break;
            }else {
                System.out.println(false);
                break;
            }
        }*/
    }
}
