package AlgorithmBase1;

import java.io.*;

public class P10820 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String str;

            while((str = br.readLine()) != null) {
                int[] arr = new int[4];

                for(char c : str.toCharArray()) {
                    if (Character.isAlphabetic(c)) {
                        if (Character.isLowerCase(c)) arr[0]++;
                        else arr[1]++;
                    } else if(Character.isDigit(c)) arr[2]++;
                    else arr[3]++;
                }

                for(int i : arr) bw.write(i + " ");
                bw.write("\n");
                bw.flush();
            }
        }
    }
}