package com.company;

import java.util.Arrays;

public class LodyMonteCarlo {

    final static int N = 6;
    public static int minTime = Integer.MAX_VALUE;
    public static int currentTime = 0;
    public static int[][] matrix = new int[6][6];
    private static final int[] permutacja = new int[N];

    public static void main(String[] args) {

        matrix[0][0] = 0;
        matrix[0][1] = 7;
        matrix[0][2] = 20;
        matrix[0][3] = 21;
        matrix[0][4] = 12;
        matrix[0][5] = 23;

        matrix[1][0] = 27;
        matrix[1][1] = 0;
        matrix[1][2] = 13;
        matrix[1][3] = 16;
        matrix[1][4] = 46;
        matrix[1][5] = 5;

        matrix[2][0] = 53;
        matrix[2][1] = 15;
        matrix[2][2] = 0;
        matrix[2][3] = 25;
        matrix[2][4] = 27;
        matrix[2][5] = 6;

        matrix[3][0] = 16;
        matrix[3][1] = 2;
        matrix[3][2] = 35;
        matrix[3][3] = 0;
        matrix[3][4] = 47;
        matrix[3][5] = 10;

        matrix[4][0] = 31;
        matrix[4][1] = 29;
        matrix[4][2] = 5;
        matrix[4][3] = 18;
        matrix[4][4] = 0;
        matrix[4][5] = 4;

        matrix[5][0] = 28;
        matrix[5][1] = 24;
        matrix[5][2] = 1;
        matrix[5][3] = 17;
        matrix[5][4] = 5;
        matrix[5][5] = 0;

        permutacje(0);

    }

    static void permutacje(int i) {

        if (i == N) {
            for (int k = 0; k < N; k++) {
                currentTime += matrix[permutacja[(k % N)] - 1][permutacja[(k + 1) % N] - 1];
            }
            if (currentTime <= minTime) {
                minTime = currentTime;
                System.out.println("Czas:\t\tKolejność:");
                System.out.print(minTime + "\t\t");
                for (int j = 0; j < N + 1; j++) {
                    System.out.print(permutacja[j % N] + " ");
                }
                System.out.println("\n");
            }

            currentTime = 0;
        }
        else {
            for (int j = 1; j <= N; j++) {
                int k;
                for (k = 0; k < i; k++) {
                    if (permutacja[k] == j) {
                        break;
                    }
                }
                if (k == i) {
                    permutacja[k] = j;
                    permutacje(i + 1);
                }
            }
        }
    }
}