package com.suanfa;

import java.util.*;

public class XieCheng {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String a = sc.next();
//            String[] node = a.split(",");
//            HashSet<String> list = new HashSet<>();
//            for (int i = 0; i < node.length; i++){
//                if (list.contains(node[i])){
//                    System.out.println("true");
//                    return;
//                }else if (!list.contains(node[i])){
//                    list.add(node[i]);
//                }
//            }
//            System.out.println("false");
//        }
        //反转链表，如：[1,2,3,4,5] 2  [2,1,4,3,5] ； [1,2,3,4,5] 3 [3,2,1,4,5]
        //
        String a = sc.nextLine();
        int n = sc.nextInt();
        if (n == 0){
            System.out.println(a);
        }else if (n > a.length()){
            System.out.println(a);
        }else {
            String shr = a.substring(1, a.length() - 1); //获取字符串第一个int为开始的索引，对应String数字中的开始位置，
            // 第二个是截止的索引位置，对应String中的结束位置
            // "hamburger".substring(4, 8) returns "urge"
            // "smiles".substring(1, 5) returns "mile"
            String [] st = shr.split(",");//split划开
            int[] num = new int[st.length];
            for (int i = 0; i < st.length; i++){
                num[i] = Integer.valueOf(st[i]);//将字符串转换为int数组
            }
            Stack<Integer> stack = new Stack<>();
            int p = 0;
            List<Integer> list = new ArrayList<>();
            while (p + n - 1 <= st.length - 1){
                for (int i = 0; i < n; i++){
                    stack.push(num[p + i]);
                }
                while (!stack.empty()){
                    list.add(stack.pop());
                }
                p += n;
            }
            while (p <= st.length - 1 ){
                list.add(num[p++]);
            }
            System.out.print("[");
            for (int i = 0; i < list.size() - 1; i++){
                System.out.print(list.get(i) + ",");
            }
            System.out.print(list.get(list.size() - 1) + "]");
        }
    }


}
