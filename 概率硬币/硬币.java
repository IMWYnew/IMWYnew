package 命运硬币;

import java.util.Random;
import java.util.Scanner;

public class 硬币 {
    public static void main(String[] args) {
        System.out.println("投赛博硬币，享赛博人生");
        System.out.println("欢迎体验此项目");
        System.out.println("还在犹豫吗？");
        System.out.println("还在与自己争执吗？");
        System.out.println("不妨投个硬币帮你做决定");
        System.out.println("因果为天意");
        System.out.println();
        System.out.println("输入1投出硬币");
        Scanner sc = new Scanner(System.in);
        int aa1 = sc.nextInt();
        if (aa1 == 1) {
            Random r = new Random();
            System.out.println("请选择投掷次数1.一千万次,2.五千两百万次,3.六千万次,4.九亿次");
            int time = switch (sc.nextInt()) {
                case 1 -> 10000000;
                case 2 -> 52000000;
                case 3 -> 60000000;
                case 4 -> 900000000;
                default -> 1000000;
            };
            long e = 0, l = 0, i;//创建正反两面,和投掷次数

            System.out.println("在心中想好了正反对应的决定");
            System.out.println("你投出了硬币");
            System.out.println("硬币在空中不断复制，落下结果为……");
            //0表示反面，1表示正面
            for (i = 0; i < time; i++) {
                int go = r.nextInt(2);
                if (go != 1) {
                    l++;
                } else {
                    e++;
                }
            }
            System.out.println("一共投掷了" + (i/10000) + "万次");
            System.out.println("正面有" + e + "个");
            System.out.println("反面有" + l + "个");
            if (e > l) {
                System.out.println("硬币为正");
            } else {
                System.out.println("硬币为反");
            }
            System.out.println("当然……无论结果如何，你都理应相信你心中的决定，让他人决定你的命运多少还是有些不合适，命运还是自己掌握比较好");
        } else {
            System.out.println("你取消了投掷，选择了自己掌控自己");
        }
    }
}
