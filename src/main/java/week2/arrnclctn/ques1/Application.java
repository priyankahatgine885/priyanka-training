package week2.arrnclctn.ques1;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Enter elements : ");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int[] otherArr = new int[5];
        for (int i = 0; i< arr.length; ++i){
            arr[i] = sc.nextInt();
        }

    }
}
