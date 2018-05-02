package asange.javastudy.java.lang;

/**
 * @author youxuan  E-mail:xuanyouwu@163.com
 * @version 2.3.1
 * @Description
 * @Company Beijing icourt
 * @date createTime：2018/1/20
 */
public class ObjectTest {

    public static class User {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize");
            super.finalize();
        }
    }

    public static Object obj = new Object();

    public static void main(String[] args) throws Exception {
        User o = new User();
        o = null;
        System.gc();
        o = null;
        System.gc();

        Object o2 = new Object();
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("线程" + Thread.currentThread().getName() + "开始");
            synchronized (obj) {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "调用了object.wait()");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("线程" + Thread.currentThread().getName() + "开始");
            synchronized (obj) {
                obj.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用了object.notify()");
            }
            System.out.println("线程" + Thread.currentThread().getName() + "释放了锁");
        }
    }

}
