package com.study.ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Challenge {

    public static void main(String[] args) {
        //String[] strArr = {"X","O", "X", "<>" ,"-" ,"O" ,"O" ,"<>" ,"X" ,"X" ,"O" }; //
        //String[] strArr = {"X","O", "-", "<>" ,"-" ,"O" ,"-" ,"<>" ,"O" ,"X" ,"-" }; //
        //String[] strArr = {"-","O", "-", "<>" ,"-" ,"O" ,"-" ,"<>" ,"O" ,"X" ,"O" }; // return 0
        //String[] strArr = {"X","O", "X", "<>" ,"O" ,"X" ,"O" ,"<>" ,"O" ,"O" ,"-" }; // return 10
        //String[] strArr = {"X", "O", "X", "<>", "O", "X", "O", "<>", "O", "O", "-"}; // return 10
        // String[] strArr = {"-","O", "-", "<>" ,"-" ,"X" ,"-" ,"<>" ,"O" ,"-" ,"O" }; // return -1
        String[] strArr = {"X","-", "O", "<>" ,"-" ,"-" ,"O" ,"<>" ,"-" ,"-" ,"X" }; // return -1
        System.out.println(gameChallenge(strArr));

    }

    private static String fetchMaxFreeTime(String[] strArr) {
        return String.join("", "");
    }

    static String[][] board = new String[3][3];
    static int maxSize = 3;

    private static int gameChallenge(String[] strArr) {
        int rows = 3;
        int cols = 3;

        Map<String, Integer> positionTracker = new HashMap<>();

        board[0] = Arrays.copyOfRange(strArr, 0, 3);
        positionTracker.put("0_0", 0);
        positionTracker.put("0_1", 1);
        positionTracker.put("0_2", 2);

        board[1] = Arrays.copyOfRange(strArr, 4, 7);
        positionTracker.put("1_0", 4);
        positionTracker.put("1_1", 5);
        positionTracker.put("1_2", 6);

        board[2] = Arrays.copyOfRange(strArr, 8, 11);
        positionTracker.put("2_0", 8);
        positionTracker.put("2_1", 9);
        positionTracker.put("2_2", 10);

        System.out.println(Arrays.toString(new int[]{1,2,3}));
        System.out.println(Arrays.deepToString(board));
        System.out.println(positionTracker);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col].equals("-")) {
                    String nextOrPrev = "";
                    String nextOrPrevDiagonal = "";

                    if (row > 0 && col > 0 && row < rows - 1 && col < cols - 1) {
                        nextOrPrev = board[row + 1][col + 1];
                        // nextOrPrevDiagonal = board[row + 1][row + 1];
                    } else if (row == 0 && col == 0) {
                        nextOrPrev = board[row][col];
                        nextOrPrevDiagonal = board[row + 1][row + 1];
                    } else if (col == 0 && row < rows) {
                        nextOrPrev = board[row - 1][col];
                        nextOrPrevDiagonal = board[row + 1][row + 1];
                    } else if (row == 0 && col < cols) {
                        nextOrPrev = board[row][col - 1];
                        nextOrPrevDiagonal = board[col - 1][col - 1];
                    } else {
                        nextOrPrev = board[row - 1][col - 1];
                        nextOrPrevDiagonal = board[row - 1][col - 1];
                    }

                    //if(nextOrPrev != nextOrPrevDiagonal) return -1;

                    if (checkRow(row, col, nextOrPrev)
                            || checkCol(row, col, nextOrPrev)
                            || (row == col && checkDiagonal(row, col, nextOrPrevDiagonal))
                            || (row + col == maxSize - 1 && checkAntiDiagonal(row, col, nextOrPrevDiagonal))) {

                        return positionTracker.get(row + "_" + col);
                    }
                }
            }
        }

        return -1;
    }

    private static boolean checkRow(int row, int currentCol, String nextOrPrev) {
        if (nextOrPrev.equals("-")) return false;

        for (int col = 0; col < maxSize; ++col) {
            if (currentCol != col && !board[row][col].equals(nextOrPrev)) return false;
        }
        return true;
    }

    private static boolean checkCol(int currentRow, int col, String nextOrPrev) {
        if (nextOrPrev.equals("-")) return false;

        for (int row = 0; row < maxSize; ++row) {
            if (row != currentRow && !board[row][col].equals(nextOrPrev)) return false;
        }
        return true;
    }

    private static boolean checkDiagonal(int currentRow, int currentCol, String nextOrPrevDiagonal) {
        if (nextOrPrevDiagonal.equals("-")) return false;

        for (int row = 0; row < maxSize; ++row) {
            if (row != currentRow && currentCol != row) {
                if (board[row][row].equals("-")) return false;
                if (!board[row][row].equals(nextOrPrevDiagonal)) return false;
            }
        }
        return true;
    }

    private static boolean checkAntiDiagonal(int currentRow, int currentCol, String nextOrPrevDiagonal) {
        if (nextOrPrevDiagonal.equals("-")) return false;

        for (int row = 0; row < maxSize; ++ row) {
            if (!board[currentRow][currentCol].equals("-")) {
                if (!board[row][maxSize - 1 - row].equals(nextOrPrevDiagonal)) return false;
            }
        }
        return true;
    }
}
