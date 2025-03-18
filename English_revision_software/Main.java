package English_revision_software;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shuju pupil = new Shuju();
        Random r = new Random();
        System.out.println("欢迎来到英语学习系统！");
        while (true) {
            System.out.println("请选择您要使用的功能：1、随机复习；2、顺序复习；3、输出单词库及其翻译");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                //随机复习
                randomReview(pupil, sc, r);
            } else if (choice == 2) {
                //顺序复习
                sequenceReview(pupil, sc, r);
            } else {
                //单词表
                Word_comparison_table(pupil);
            }
        }
    }

    //随机复习方法体
    public static void randomReview(Shuju pupil, Scanner sc, Random r) {
        int counter = pupil.getRepertory_word().length;
        System.out.println("启动随机复习");
        System.out.println("是否指定随机复习次数？1.指定;输入其他则使用默认次数");
        String input = sc.nextLine();
        if (input.equals("1") || input.equals("指定")) {
            System.out.println("请选择指定次数");
            //应用用户输入更改计数器
            counter = sc.nextInt();
        }
        System.out.println("选择完毕，开始复习吧！");
        Start_and_introduction(pupil, counter, sc, r, 1);
    }

    //顺序复习方法体
    public static void sequenceReview(Shuju pupil, Scanner sc, Random r) {
        // 顺序复习
        // 获取单词库数量
        int counter = pupil.getRepertory_word().length;
        // 开始顺序复习
        System.out.println("开始顺序复习！");
        Start_and_introduction(pupil, counter, sc, r, 0);
    }

    //输出单词表，单词表为单词库（含短句）和翻译库的组合
    public static void Word_comparison_table(Shuju pupil) {
        int counter = pupil.getRepertory_word().length;
        System.out.println("单词表(目前存储的所有单词和短语)");
        System.out.println("——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——");
        for (int i = 0; i < counter - 1; i++) {
            System.out.println(pupil.getChinese_reference_library()[i] + "|" + pupil.getRepertory_word()[i]);
        }
        System.out.println("——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——");
        System.out.println("输出完毕，该单词表全包含顺序和随机复习中会出现的单词");
        System.out.println("努力学习吧！\\('v')/！");
    }

    //主体·出题与判题
    public static void answer(Shuju pupil, int counter, Scanner sc, Random r, int number) {
        //将单词库和翻译库进行存储
        String[] storage = pupil.getRepertory_word();
        String[] Chinese = pupil.getChinese_reference_library();
        System.out.println("——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——");
        //外层循环用于输出单词库单词
        //i用于控制循环次数，t用于控制单词库单词的索引
        for (int i = 0, t = 0; i < counter - 1; i++, t++) {
            //内层循环用于输入用户答案，并判断是否回答正确，输入错误时循环，正确时跳出循环，或输错4时跳出循环
            //检测代号/编号，1为随机，0||其它为顺序
            if (number == 1) {
                //替换索引-替换单词及翻译
                //每次循环都会替换为随机的单词及翻译
                t = r.nextInt(counter);
            }
            for (int j = 0; true; j++) {
                System.out.println("第" + (i + 1) + "个单词：");
                System.out.println(Chinese[t]);
                String input = sc.nextLine();
                //判断是否回答正确
                if (input.equals(storage[t])) {
                    //回答正确，直接开始下一个单词
                    //连击数+1
                    pupil.setCombo_count(pupil.getCombo_count() + 1);
                    //连击检测
                    switch (pupil.getCombo_count()) {
                        case 1 ->
                                System.out.println("\u001B[33m✨ 初露锋芒！继续加油！ | First Strike! Keep going!\u001B[0m");
                        case 2 ->
                                System.out.println("\u001B[32m🔥 二连击破！词汇觉醒！ | Double Kill! Vocabulary Awakening!\u001B[0m");
                        case 3 ->
                                System.out.println("\u001B[34m⚡  三连超凡！语法精通！ | Triple Combo! Grammar Mastered!\u001B[0m");
                        case 4 ->
                                System.out.println("\u001B[35m🌟 四连制霸！句型掌控！ | Quadra Kill! Sentence Dominance!\u001B[0m");
                        default -> {
                            System.out.println("\u001B[36m🎯\u001B[5m 五连登顶！英语达人！ | PENTAKILL! English Master!\u001B[0m X" + pupil.getCombo_count_max());
                            pupil.setCombo_count_max(pupil.getCombo_count_max() + 1);
                        }
                    }
                    break;
                } else {
                    // 错误次数达4次，输出正确答案，并开始下一个单词
                    // 错误次数小于4次，使学生重新输入
                    System.out.println("很遗憾！回答错误！");
                    //修改连击数
                    pupil.setCombo_count(0);
                    pupil.setCombo_count_max(1);
                    if (j == 3) {
                        System.out.println("正确答案为：" + storage[t]);
                        break;
                    } else {
                        System.out.println("你还可以再重复回答" + (3 - j) + "次");
                    }
                }
            }
        }
        System.out.println("——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——·——");
    }

    //开始及介绍
    public static void Start_and_introduction(Shuju pupil, int counter, Scanner sc, Random r, int number) {
        System.out.println("本次复习将包括单词及相关联的短语");
        System.out.println("请将显示的中文翻译为英文，注意语法和单词间的空格");
        System.out.println("注意单词小写，句子第一个单词首字母大写");
        //将用户，遍历次数，输入，随机数，和编号（用于判断）
        answer(pupil, counter, sc, r, number);
        System.out.println("恭喜你！复习完毕！\\(awa)/");
        System.out.println("好好学习，天天向上，向着云端努力吧！");
        System.out.println("欢迎再次复习哦！");
    }
}
