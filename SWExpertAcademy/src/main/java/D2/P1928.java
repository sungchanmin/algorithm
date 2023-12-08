package D2;

import java.util.Scanner;

public class P1928 {
    /**
     * 1928. Base64 Decoder
     * 1. 유니코드 문자열 -> UTF-8 인코딩 -> Base64 인코딩
     * 2. 4개의 6bit 그룹을 합쳐 24bit 데이터로 복원
     * 3. 24bit 데이터를 8bit씩 나누어 원래의 byte 데이터로 분리
     */
    private static final int SIX_BIT = (int)Math.pow(2, 6);
    private static final int BYTE = (int)Math.pow(2, 8);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            System.out.print("#" + test_case + " ");
            String str = sc.nextLine();
            // 4개의 문자를 가져온다.
            for(int i=0; i<str.length(); i+=4) {
                int bit = 0;
                int ToBinary = SIX_BIT * SIX_BIT * SIX_BIT;
                // 하나의 24bit 데이터로 복원
                for(int j=0; j<4; j++) {
                    bit += toBase64(str.charAt(i + j)) * ToBinary;
                    ToBinary = ToBinary / SIX_BIT;
                }
                // 24bit 데이터를 3byte씩 분리
                int ToUni = BYTE * BYTE;
                for(int j=0; j<3; j++) {
                    System.out.print((char)(bit / ToUni));
                    bit = bit % ToUni;
                    ToUni = ToUni / BYTE;
                }
            }
            System.out.println();
        }
    }

    /**
     * Java에서 문자는 유니코드 코드 포인트로 표현된다.
     * 문자를 int로 캐스킹하여 UTF-8 인코딩한 후
     * Base64 이진 코드로 변환한다.
     *
     * @param unicode 변환할 문자
     * @return Base64 인코딩된 이진 코드
     */
    static int toBase64(char unicode) {
        if (unicode >= 65 && unicode <= 90) return unicode - 65;        // A ~ Z
        else if (unicode >= 97 && unicode <= 122) return unicode - 71;  // a ~ z
        else if (unicode >= 48 && unicode <= 57) return unicode + 4;    // 0 ~ 9
        else if (unicode == '+') return 62;                             // +
        else return 63;                                                 // -
    }
}