package D3;

import java.util.Scanner;

public class P1873 {
    // 1873. 상호의 배틀필드
    private static char[][] arr;
    private static char[] cmd;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();

            arr = new char[x][y];

            for(int i=0; i<x; i++) arr[i] = sc.nextLine().toCharArray();

            int n = Integer.parseInt(sc.nextLine());
            cmd = sc.nextLine().toCharArray();

            System.out.print("#" + test_case + " ");
            solution();
        }
    }

    private static class Tank {
        int x, y;
        char way;
        public Tank(int x, int y, char way) {
            this.x = x;
            this.y = y;
            this.way = way;
        }

        public static Tank tankPosition() {
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[0].length; j++) {
                    if(arr[i][j] == '^' || arr[i][j] == '<' || arr[i][j] == 'v' || arr[i][j] == '>') {
                        return new Tank(i, j, arr[i][j]);
                    }
                }
            }
            return null;
        }

        public void U() {
            way = '^';
            int nx = x-1;

            if(nx >=0 && arr[nx][y] == '.') {
                arr[x][y] = '.';
                x = nx;
            }
            arr[x][y] = way;
        }

        public void D() {
            way = 'v';
            int nx = x+1;

            if(nx < arr.length && arr[nx][y] == '.') {
                arr[x][y] = '.';
                x = nx;
            }
            arr[x][y] = way;
        }

        public void L() {
            way = '<';
            int ny = y-1;

            if(ny >=0 && arr[x][ny] == '.') {
                arr[x][y] = '.';
                y = ny;
            }
            arr[x][y] = way;
        }

        public void R() {
            way = '>';
            int ny = y+1;

            if(ny < arr[0].length && arr[x][ny] == '.') {
                arr[x][y] = '.';
                y = ny;
            }
            arr[x][y] = way;
        }

        public void S() {
            if(way == '^') {
                int s = x - 1;
                while(s >= 0) {
                    if(arr[s][y] == '#') break;
                    if(arr[s][y] == '*') {
                        arr[s][y] = '.';
                        break;
                    }
                    s--;
                }
            }else if(way == 'v') {
                int s = x + 1;
                while(s < arr.length) {
                    if(arr[s][y] == '#') break;
                    if(arr[s][y] == '*') {
                        arr[s][y] = '.';
                        break;
                    }
                    s++;
                }
            } else if(way == '<') {
                int s = y - 1;
                while(s >= 0) {
                    if(arr[x][s] == '#') break;
                    if(arr[x][s] == '*') {
                        arr[x][s] = '.';
                        break;
                    }
                    s--;
                }
            } else if(way == '>') {
                int s = y + 1;
                while(s < arr[0].length) {
                    if(arr[x][s] == '#') break;
                    if(arr[x][s] == '*') {
                        arr[x][s] = '.';
                        break;
                    }
                    s++;
                }
            }
        }
    }

    private static void solution() {
        Tank tank = Tank.tankPosition();

        for(char c : cmd) {
            if(c == 'U') tank.U();
            else if(c == 'D') tank.D();
            else if(c == 'L') tank.L();
            else if(c == 'R') tank.R();
            else tank.S();
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
