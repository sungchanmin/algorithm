package AlgorithmBase1;

import java.io.*;

public class P11655 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String str = br.readLine();

            for(char c : str.toCharArray()) {
                if(Character.isUpperCase(c)) bw.write((char) (c - 65 + 13) % 26 + 65);
                else if(Character.isLowerCase(c)) bw.write((char) (c - 97 + 13) % 26 + 97);
                else bw.write(c);
            }

            bw.flush();
        }
    }
}