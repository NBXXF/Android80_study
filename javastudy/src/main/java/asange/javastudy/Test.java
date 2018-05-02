package asange.javastudy;

import java.util.Random;

/**
 * @author youxuan  E-mail:xuanyouwu@163.com
 * @version 2.3.1
 * @Description
 * @Company Beijing icourt
 * @date createTime：2018/1/20
 */
public class Test {

    public static void test(final String s) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.nanoTime();
                for (int i = 0; i < 100000; i++) {
                    s.substring(1);
                }
                long end = System.nanoTime();
                System.out.println("1:" + (end - start) / 1000);
            }
        }).start();
    }


    public static void test2(final String s) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.nanoTime();
                for (int i = 0; i < 100000; i++) {
                    s.substring(0, s.length() - 1);
                }
                long end = System.nanoTime();
                System.out.println("2:" + (end - start) / 1000);
            }
        }).start();
    }

    public static void test3(StringBuilder s) {
        long start = System.nanoTime();
        s.delete(0, 1);
        long end = System.nanoTime();
        System.out.println("3:" + (end - start));
    }

    public static void test4(StringBuilder s) {
        long start = System.nanoTime();
        s.deleteCharAt(0);
        long end = System.nanoTime();
        System.out.println("4:" + (end - start));
    }


    public static void main(String[] args) throws Exception {
        int i1 = Byte.toUnsignedInt((byte) -16);
        System.out.println("byte:" + i1);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append(new Random().nextInt(100));
        }
        String str = sb.toString();
        test2(str);
        test(str);

        /*StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb1.append(new Random().nextInt(100));
        }
        test3(sb1);

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb2.append(new Random().nextInt(100));
        }
        test4(sb2);*/
    }
}
