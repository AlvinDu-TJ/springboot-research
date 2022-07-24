package sl.springboot.test.algorithm;

import java.util.Arrays;

public class Kmp {
    public static void main(String[] args) {
        String str2="wxiz";
        String str1="aaawxiz";
        System.out.println(math01(str1,str2));


        System.out.println("KMP算法的使用");
        String string1 = "BBC ABCDAB ABCDABDABDE";
        String string2 = "ABCDABD";
        System.out.println(Arrays.toString(kmpNext(string2)));
        int[] kmpNext = kmpNext(string2);
        System.out.println(kmpSearch(string1, string2, kmpNext));
    }

    // 暴力匹配， 有字符串回溯
    public static int math01(String str1,String str2){
        int i=0;
        int j=0;
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int len1=char1.length;
        int len2=char2.length;
        while(i<len1&&j<len2){
            if (char1[i]==char2[j]){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
        if (j==len2){
            return i-j;
        }else {
            return -1;
        }

    }


    //    KMP搜索算法
    public static int kmpSearch(String str1, String str2, int[] next) {
        int j = 0;
        int len2 = str2.length();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
//          KMP算法的核心，调整j的位置
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (j == len2) {
                return i - j + 1;
            }
        }
        return -1;
    }


    //    kmp算法得到一个字符串的部分匹配表
    public static int[] kmpNext(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;//如果字符串的长度是1返回的部分匹配之就是0
        for (int i = 1, j = 0; i < str.length(); i++) {
//            当匹配到str.charAt(i)!=str.charAt(j)满足时,我们需要从 next[j-1]获取新的j的值，
//            知道我们发现str.charAt(i)==str.charAt(j)成立才退出
//            这时KMP的核心语法
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }
//            当匹配到str.charAt(i)==str.charAt(j)满足时，部分匹配表就+1
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
