package Part4_1;

public class MyThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // Tạm dừng 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Tạo các đối tượng Runnable
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();

        // Tạo các thread với đối tượng Runnable
        Thread thread1 = new Thread(myThread1, "Thread1");
        Thread thread2 = new Thread(myThread2, "Thread2");

        // Đặt thứ tự ưu tiên
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        // Bắt đầu các thread
        thread1.start();
        thread2.start();
    }
}