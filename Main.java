public class Main {
    public static void main(String[] args) throws InterruptedException {
        // This program essentially explains multi-threading by implementing
        // a timer in two different threads, both of which are initiated by two
        // different methods. One being the 1) Extends Threads method and the other
        // uses 2) implements Runnable

        class MyThread extends Thread {
            @Override
            public void run() {
                for (int i = 10; i > 0; i--) {
                    System.out.println("#Thread1:" + i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread 1 has finished");
            }
        }

        class MyRunnable implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("#Thread2:" + i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread 2 has finished");
            }
        }

        MyThread t1 = new MyThread();
        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);

        t1.start();
        t1.join(); // We want thread 2 to start after thread 1 finishes
        t2.start();
    }
}
