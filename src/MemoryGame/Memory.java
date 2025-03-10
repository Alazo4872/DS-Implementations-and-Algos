package MemoryGame;

import java.util.Random;
import java.util.Scanner;

public class Memory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] listsamp = createlist();
        int[][] list = createlist();
        String[][] liststrsamp = stringCon(listsamp);
        displayList(liststrsamp);
        int status = 0;
        int game = 0;
        int x1, y1, x2, y2;
        System.out.println("\nWelcome to Memory game.\n Enter 1 to begin: ");
        status = scanner.nextInt();
        while (status == 1) {
            String[][] tracklist = {
                    {"0", "0", "0", "0"},
                    {"0", "0", "0", "0"},
                    {"0", "0", "0", "0"},
                    {"0", "0", "0", "0"}
            };
            list = ranList(list);
            String[][] liststr = stringCon(list);
            String[][] listb = HiddenList();
            game = 0;
            while (game == 0) {
                int ref = 0;
                displayList(listb);
                System.out.println("Enter first value row: ");
                x1 = scanner.nextInt() - 1;
                System.out.println("Enter first value column: ");
                y1 = scanner.nextInt() - 1;
                firstNum(liststr, listb, x1, y1);
                displayList(listb);
                System.out.println("Enter second value row: ");
                x2 = scanner.nextInt() - 1;
                System.out.println("Enter second value column: ");
                y2 = scanner.nextInt() - 1;
                listb = updateList(liststr, listb, x1, y1, x2, y2, tracklist);

                game = checkCond(listb, liststr);
            }
            System.out.println("You won!");
            System.out.println("Enter 1 to continue or any other number to quit:  ");
            status = scanner.nextInt();
        }


    }

    public static int[][] createlist() {
        int[][] list1 = {
                {1, 1, 2, 2},
                {3, 3, 4, 4},
                {5, 5, 6, 6},
                {7, 7, 8, 8}
        };
        return list1;
    }

    public static int[][] ranList(int[][] x) {
        Random random = new Random();
        int a, b, c, d, i, temp;
        for (i = 0; i < x.length * 100; i++) {
            a = random.nextInt(0, 4);
            b = random.nextInt(0, 4);
            temp = x[b][a];
            x[b][a] = x[a][b];
            x[a][b] = temp;

            temp = x[b][b];
            x[b][b] = x[a][a];
            x[a][a] = temp;

        }
        return x;
    }

    public static void displayList(String[][] x) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t1 2 3 4");
        System.out.println("\t_______");
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (j == 0) {
                    System.out.print(i + 1 + " | " + x[i][j] + " ");
                } else {
                    System.out.print(x[i][j] + " ");
                }
                if (j == 3) {
                    System.out.println();
                }
            }
        }
    }

    public static String[][] updateList(String[][] x, String[][]y, int x1, int y1, int x2, int y2, String[][]t) {
        int [][]z = intCon(x);
        int z1 = z[x1][y1];
        int z2 = z[x2][y2];
        if(x[x2][y2]==x[x1][y1]){
            displayList(y);
            if(t[x1][x2] == y[x1][x2]){
            }else if(t[x1][x2] != y[x1][x2]) {
                y[x1][x2] = "*";
            }
            System.out.println("Can't do that!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
        }
        else if(z1 == z2){
            y[x1][y1] = x[x1][y1];
            y[x2][y2] = x[x2][y2];
            displayList(y);
            System.out.println("Correct!");
                t[x1][y1] = y[x1][y2];
                t[x2][y2] = y[x2][y2];
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
        }else{
            y[x2][y2] = x[x2][y2];
            y[x1][y1] = x[x1][y1];
            displayList(y);
            System.out.println("Wrong!");
            trackList(t, y, x1, y1, x2, y2);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }

        }
        return y;
    }

    public static String[][] HiddenList() {
        String[][] list1 = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"}
        };
        return list1;
    }

    public static String[][] stringCon(int[][] x) {
        String[][] b = new String[4][4];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                b[i][j] = String.valueOf(x[i][j]);
            }

        }
        return b;
    }

    public static int[][] intCon(String[][] x) {
        int[][] m = new int[4][4];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                m[i][j] = Integer.valueOf(x[i][j]);
            }

        }
        return m;
    }

    public static int checkCond(String[][] x, String[][] y) {
        int game = 0;
        int counter = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if(x[i][j]== y[i][j]){
                    counter++;
                    if(counter >= 15){
                        game = 1;
                    }else{
                        game = 0;
                    }
                }
            }
        }
        return game;
    }
    public static String[][] firstNum(String[][] x,String[][] y, int x1, int y1) {
            y[x1][y1] = x[x1][y1];
        return y;
    }
    // list to track up or down if value coor == after every update
    public static String[][] trackList(String[][]x, String[][] y, int x1, int y1, int x2, int y2){
        if(Integer.valueOf(x[x1][y1])==Integer.valueOf(y[x1][y1])&&Integer.valueOf(x[x2][y2])!=Integer.valueOf(y[x2][y2])){
            y[x2][y2] = "*";
            return y;
        }else if(Integer.valueOf(x[x1][y1])!=Integer.valueOf(y[x1][y1])&&Integer.valueOf(x[x2][y2])==Integer.valueOf(y[x2][y2])){
            y[x1][y1] = "*";
            return y;
        }else if(Integer.valueOf(x[x1][y1])==Integer.valueOf(y[x1][y1])&&Integer.valueOf(x[x2][y2])==Integer.valueOf(y[x2][y2])){
            return y;
        }else if (Integer.valueOf(x[x1][y1])!=Integer.valueOf(y[x1][y1])&&Integer.valueOf(x[x2][y2])!=Integer.valueOf(y[x2][y2])){
            y[x1][y1] = "*";
            y[x2][y2] = "*";
        }
        return y;
    }
}