import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串相关操作练习
 *
 * @author Lyle
 * @date 2021/4/4
 */
public class StringPractice {
    public static void main(String[] args) {
        // 1.测试计算字符串最后一个单词的长度，单词以空格隔开
//        Scanner sc=new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(getLastWordLength(s));

        // 2.测试输入字符串中含有指定字符的个数，忽略大小写
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        try {
//            // 获取输入的字符串
//            char[] chars1 = br.readLine().toLowerCase().toCharArray();
//            // 获取输入的 指定字符串
//            char[] chars2 = br.readLine().toLowerCase().toCharArray();
//            System.out.println(countCharacter(chars1, chars2));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 3.连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
        // 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            String str = sc.nextLine();
//            fun01(str);
//        }

        // 4.测试求质因数
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        fun02(num);

        // 5.测试取近似数
        Scanner sc=new Scanner(System.in);
        double num = sc.nextDouble();
        System.out.println(getRound(num));
    }


    /**
     * 计算字符串最后一个单词的长度，单词以空格隔开
     *
     * @param s
     * @return
     */
    public static int getLastWordLength(String s) {
        String[] strArr = s.split(" ");
        return strArr[strArr.length - 1].length();
    }

    /**
     * 输入一串字符串
     * 输入一个字符，统计字符串中含有该字符的个数，忽略大小写
     *
     * @param chars1
     * @param chars2
     * @return
     */
    public static int countCharacter(char[] chars1, char[] chars2) {
        int count = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[0]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
     * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     *
     * @param s
     */
    public static void fun01(String s) {
        List<String> list = new ArrayList<>();
        while (s.length() >= 8) {
            String s1 = s.substring(0, 8);
            list.add(s1);
            s = s.substring(8);
        }
        if (s.length() < 8) {
            String s1 = s;
            for (int i = 0; i < 8 - s.length(); i++) {
                s1 = s1 + "0";
            }
            list.add(s1);
        }
        String[] strArr = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(strArr));
    }

    /**
     * 输入一个整数，求该数字的质因数
     * @param num
     */
    public static void fun02(Integer num) {
        List<Integer> list = new ArrayList<>();
        int a = (int) Math.sqrt(num) + 1;
        int i = 2;
        while (num != 1 && i <= a) {
            if (num % i == 0) {
                num = num / i;
                list.add(i);
            }else {
                i++;
            }
            if (i>a){
                System.out.println("该数字无质因数："+num);
            }
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
     * 如果小数点后数值大于等于5,向上取整；小于5，则向下取整
     */
    public static int getRound(double num){
        int round=(int)num;
        if (num-round>=0.5){
            round=round+1;
        }
        return round;
    }
}
