package Part1;

import java.util.Scanner;
public class Part1{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số lượng phần tử và giá trị d
        System.out.print("Nhập n : ");
        int n = scanner.nextInt();
        System.out.print("Nhập d : ");
        int d = scanner.nextInt();

        // Đọc dãy số b
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // Tính số bước di chuyển cần thiết
        int[] steps = new int[n];
        int totalSteps = 0;
        for (int i = 1; i < n; i++) {
            while (b[i] <= b[i - 1]) {
                b[i] += d;
                steps[i]++;
            }
            totalSteps += steps[i];
        }

        // In ra kết quả
        System.out.println(totalSteps);

        scanner.close();
    }
}

