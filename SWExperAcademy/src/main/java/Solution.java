import java.util.*;

public class Solution{

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        for(int b=1; b<=a; b++) {
            float sum = 0;
            for(int c=1; c<=10; c++) {
                int d = input.nextInt();
                sum += d;
            }
            System.out.println("#" +a+ " " + String.format("%.1f", sum / 10));
        }


    }

}