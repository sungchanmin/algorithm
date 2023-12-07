package AlgorithmBase1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class P1406A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        List<Character> list = new LinkedList<>();

        for(char c : str.toCharArray()) list.add(c);

        ListIterator<Character> cursor = list.listIterator();

        while(cursor.hasNext()) cursor.next();

        for(int i=0; i<n; i++) {
            String cmd = br.readLine();

            switch (cmd.charAt(0)) {
                case 'L' :
                    if(cursor.hasPrevious()) cursor.previous();
                    break;
                case 'D' :
                    if(cursor.hasNext()) cursor.next();
                    break;
                case 'B' :
                    if(cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P' :
                    cursor.add(cmd.charAt(2));
                    break;
            }
        }

        for(char c : list) bw.write(c);

        bw.flush();
        br.close();
        bw.close();
    }
}