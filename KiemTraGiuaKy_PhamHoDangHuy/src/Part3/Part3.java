package Part3;

import java.util.Scanner;
import java.util.Arrays;

public class Part3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lọ mật ong : ");
        int n = scanner.nextInt(); 
        System.out.print("Nhập số lọ mật ong Winnie ăn mỗi lần : ");
        int k = scanner.nextInt(); 

        int[] honeypots = new int[n];
        for (int i = 0; i < n; i++) {
            honeypots[i] = scanner.nextInt();
        }

        Arrays.sort(honeypots);
        reverseArray(honeypots);

        int honeyReceivedByPiglet = 0; 

        int eatenHoneyCount = 0;

        for (int i = 0; i < n; i++) {
            if (honeypots[i] < k || eatenHoneyCount == 3) {
                honeyReceivedByPiglet += honeypots[i];
            } else {
                honeyReceivedByPiglet += k;
                eatenHoneyCount++;
            }
        }
        System.out.print("Số mật ong mà Piget ăn: ");
        System.out.println(honeyReceivedByPiglet);
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

