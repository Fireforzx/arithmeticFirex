package com.suanfa;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class HuaWei {

    /**
     * 输入两个字符串以空格分，长度拆分为8个字符串一组，输出至新字符串，按升序，如 2 abc 123456789  输出12345678 90000000 abc00000
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Vector<String> vec = new Vector<>();
//        String []str = new String[num];
//        for (int i = 0;i <str.length;i++){
//            str[i] = sc.next();
//        }
//        for (int i = 0;i < num; i++){
//            if (str[i].length() <= 8){
//                for (int j = str[i].length(); j < 8; j++){
//                    str[i] +="0";
//                }
//                vec.add(str[i]);
//            }else if (str[i].length() > 8){
//                vec.add(str[i].substring(0, 8));
//                str[i] = str[i].substring(8,str[i].length());
//                for (int j = str[i].length(); j < 8; j++){
//                    str[i] +="0";
//                }
//                vec.add(str[i]);
//            }
//        }
//        Collections.sort(vec);
//        for (int i = 0;i < vec.size()-1;i++) {
//            System.out.print(vec.get(i) + " ");
//        }
//        System.out.print(vec.get(vec.size() - 1));

//        String[] str = sc.nextLine().split(" ");
//        String temp;
//        int m = 0;
//        if (str.length == 1) {
//            for (int i = 0; i < Integer.parseInt(str[0]); ++i) {
//                vec.add("00000000");
//            }
//        } else {
//            for (int i = 1; i <= Integer.parseInt(str[0]); ++i) {
//                m = str[i].length() / 8 + 1;
//                temp = str[i];
//                for (int j = 0; j < m; ++j) {
//                    if (temp.length() < 8) {
//                        for (int k = temp.length() + 1; k <= 8; ++k) {
//                            temp += "0";
//                        }
//                        vec.add(temp);
//                        break;
//                    } else {
//                        vec.add(temp.substring(0, 8));
//                        temp = temp.substring(8, temp.length());
//                    }
//                }
//            }
//        }
//        Collections.sort(vec);
//        int i;
//        for (i = 0; i < vec.size() - 1; ++i) {
//            System.out.print(vec.get(i) + " ");
//        }
//        System.out.print(vec.get(i));
//    }
        /**
         *
         */
        String[] str = new String[num];
        int m = 0;
        for (int i =0; i <num; ++i){
            str[i] = sc.next();
            m =str[i].length()/8 + 1;
            String temp = str[i];
            for (int j = 0; j< m; ++j){
                if (temp.length() < 8){
                    for (int k = temp.length()+1; k <=8;++k){
                        temp +="0";
                    }
                    vec.add(temp);
                    break;
                } else
                 {
                    vec.add(temp.substring(0,8));
                    temp = temp.substring(8,temp.length());
                }
            }
        }
        Collections.sort(vec);
        int i;
        for (i = 0;i <vec.size() -1;i++){
            System.out.print(vec.get(i) +" ");
        }
        System.out.print(vec.get(vec.size() - 1));
    }
}
