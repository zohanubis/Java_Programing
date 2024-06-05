package Part2;

import java.util.Scanner;
public class Part2 {
    // Hàm tính tích các ước của N
    static long factorProduct(long n) {
        long product = 1;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                product *= i;
                if (n / i != i) {
                    product *= n / i;
                }
            }
        }
        return product;
    }

    // Hàm tìm N nhỏ nhất để f(N) = X
    static long findN(long x) {
        for (long i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                long a = i;
                long b = x / i;
                if (factorProduct(a) == x) {
                    return a;
                }
                if (factorProduct(b) == x) {
                    return b;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập test case : ");
        int t = scanner.nextInt(); 
        for (int i = 0; i < t; i++) {
            long x = scanner.nextLong();
            long result = findN(x);
            System.out.print("Kết quả : ");
            System.out.println(result);
        }
    }
}

