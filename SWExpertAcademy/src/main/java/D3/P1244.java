package D3;

import java.util.Arrays;
import java.util.Scanner;

public class P1244 {
    // 1244. 최대 상금
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] strArr = sc.nextLine().split(" ");
            System.out.print("#" + test_case + " ");
            solution(strArr[0], Integer.parseInt(strArr[1]));
        }
    }

    private static void solution(String str, int n) {
        String[] strArr = str.split("");
        int[] arr = new int[strArr.length];
        int[] arrAsc;

        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        arrAsc = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrAsc);

        while(n > 0) {
            int index = -1, OriIndex = -1, valueIndex = -1, value = -1, cnt = 0;

            // arr 배열에서 내림차순 정렬되지 않은 요소를 찾는다.
            for(int i=0; i<arr.length; i++) {
                if(arr[i] != arrAsc[arr.length - 1 - i]) {
                    index = i;
                    value = arrAsc[arr.length - 1 - i];
                    break;
                }
            }

            if(index != -1) {
                // 교환해야할 값이 여러개인지 체크한다.
                // 해당 값이 원래 등장하는 인덱스를 찾는다.
                for(int i=0; i<arr.length; i++) {
                    if(arr[i] == value) {
                        cnt++;
                        valueIndex = i;
                    }
                    if(arrAsc[arr.length -1 - i] == value && OriIndex == -1) OriIndex = i;
                }

                for(int i=OriIndex; i<OriIndex + cnt; i++) {
                    if(arr[i] < arr[index]) index = i;
                }

                arr[valueIndex] = arr[index];
                arr[index] = value;

                n--;
            } else if(n % 2 != 0){
                // arr 배열이 내림차순으로 모두 정렬된 경우 , 남은 n이 홀수인 경우
                boolean dup = false;
                for(int i=0; i<arr.length - 1; i++) {
                    if(arr[i] == arr[i+1]) {
                        dup = true;
                        break;
                    }
                }
                // arr 배열에 중복 요소가 없어 서로 교환할 수 없을 경우 마지막 두 요소를 교환
                if(!dup) {
                    int tmp = arr[arr.length - 1];
                    arr[arr.length - 1] = arr[arr.length - 2];
                    arr[arr.length - 2] = tmp;
                }
                n = 0;
            } else n = 0;
        }

        for(int i : arr) System.out.print(i);
        System.out.println();
    }
}
