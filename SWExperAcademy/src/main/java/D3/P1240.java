package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1240 {
    // 1240. 단순 2진 암호코드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();


            boolean find = false;
            String code = "";

            for(int i=0; i<n; i++) {
                String str = sc.nextLine();
                if(!find && isCode(str)) {
                    find = true;
                    code = str;
                }
            }

            System.out.println("#" + test_case + " " + decode(code));
        }
    }

    private static boolean isCode(String str) {
        for(char c : str.toCharArray()) {
            if(c == '1') return true;
        }

        return false;
    }

    private static int decode(String str) {
        int[] code = new int[8];
        List<char[]> list = new ArrayList<>();

        list.add(new char[] {'0', '0', '0', '1', '1', '0', '1'});
        list.add(new char[] {'0', '0', '1', '1', '0', '0', '1'});
        list.add(new char[] {'0', '0', '1', '0', '0', '1', '1'});
        list.add(new char[] {'0', '1', '1', '1', '1', '0', '1'});
        list.add(new char[] {'0', '1', '0', '0', '0', '1', '1'});
        list.add(new char[] {'0', '1', '1', '0', '0', '0', '1'});
        list.add(new char[] {'0', '1', '0', '1', '1', '1', '1'});
        list.add(new char[] {'0', '1', '1', '1', '0', '1', '1'});
        list.add(new char[] {'0', '1', '1', '0', '1', '1', '1'});
        list.add(new char[] {'0', '0', '0', '1', '0', '1', '1'});

        int index = str.length() - 1;

        while(str.charAt(index - 1) == '0') {
            index--;
        }

        for(int i=0; i<8; i++) {
            String codeStr = str.substring(index - (8 - i) * 7, index - (7 - i) * 7);

            for(int j=0; j<list.size(); j++) {
                if(compareCode(codeStr, list.get(j))) {
                    code[i] = j;
                    break;
                }
            }
        }

        return codeCheck(code);
    }

    private static boolean compareCode(String codeStr, char[] code) {
        for(int i=0; i<code.length; i++) if(codeStr.charAt(i) != code[i]) return false;
        return true;
    }

    private static int codeCheck(int[] code) {
        int oddSum = 0;
        int evenSum = 0;

        for(int i=0; i<code.length; i++) {
            if((i + 1) % 2 == 0) evenSum += code[i];
            else oddSum += code[i];
        }

        if((oddSum * 3 + evenSum) % 10 == 0) {
            return oddSum + evenSum;
        }
        return 0;
    }
}
