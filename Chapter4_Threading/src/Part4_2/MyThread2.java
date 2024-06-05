package Part4_2;

public class MyThread2 {

    
    static class EvenThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println("Even: " + i);
                }
            }
        }
    }

    
    static class OddThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("Odd: " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        
        Thread thread1 = new EvenThread();
        Thread thread2 = new OddThread();

        
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Bắt đầu thread2
        thread2.start();
    }
}
