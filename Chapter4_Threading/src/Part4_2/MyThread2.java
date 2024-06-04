package Part4_2;

public class MyThread2 {

    // Thread1 sẽ in ra các số chẵn từ 1 đến 10
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

    // Thread2 sẽ in ra các số lẻ từ 1 đến 10
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
        // Tạo thread1 và thread2
        Thread thread1 = new EvenThread();
        Thread thread2 = new OddThread();

        // Bắt đầu thread1 và chờ cho đến khi hoàn thành
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
