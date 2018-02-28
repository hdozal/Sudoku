package sudoku;


//Emmanuel Jacquez
//Homework 1 (Sudoku)
//Cheon

import java.util.*;

//board class creates and updates a sudoku board using the consoleUI inputs from user with regards to
// size and X,Y,V;
public class Board {

    private static ConsoleUI ui = new ConsoleUI();
    static int size;
    private static int[][] sudoku;
    private static int y;
    private static int x;
    private static int v;

    public Board(int size) {
        this.size = size;
        sudoku = new int[size][size];
    }
    //creates board using prompts from consoleUI user inputs for size. Initiated with values at 0
    public static void board(int[][] sudoku) {
        System.out.print("y/x ");
        for (int x = 0; x < size; x++) {
            System.out.print((x + 1) + "   "); // prints out grid
        }
        System.out.println();
        for (int i = 0; i < sudoku.length; i++) { // prints out entire sudoku
            if (i != 0) {
                System.out.println();
            }
            System.out.print((i + 1) + "| "); //
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print("[" + sudoku[i][j] + "] ");

            }

        }
        System.out.println();

    }
    //method updates board if elements while following sudoku game rules
    public void updateBoard(int y, int x, int v) {
        // System.out.println("size update " + size);
        this.y = y;
        // System.out.println("y " + y);
        this.x = x;
        // System.out.println("x " + x);
        this.v = v;
        // System.out.println("v " + v);
        int[][] temp = sudoku;
        if (checkBoard(temp, y - 1, x - 1, v) == true) {   //checks for elements existence in board
            sudoku[y - 1][x - 1] = v;
        }

        board(sudoku);  //updates board

    }
    //checks columns and rows of method along with boxes to make sure element is not already found
    public static boolean checkBoard(int temp[][], int y, int x, int v) {
        int[] sqrtE = new int[(int) Math.sqrt(size) + 1];
        sqrtE[0] = 0;
        sqrtE[1] = (int) Math.sqrt(size);
        for (int i = 0; i < sqrtE.length; i++) {
            if (i > 0) {
                sqrtE[i] = sqrtE[i - 1] + (int) Math.sqrt(size);
            }
        }

        for (int i = 0; i < temp.length; i++) {
            if (v == temp[y][i] || v == temp[i][x]) { // checks column and rows
                ui.inSudoku();
                return false;
            }
        }
        int xx = 0, xlen = 0;
        int yy = 0, ylen = 0;
        int n = 0;
        int m = 0;
        for (int i = 1; i < sqrtE.length; i++) {
            if (sqrtE[i] > x && n < 1) {               //finds limits of x and its place in sudoku box
                xx = sqrtE[i - 1];
                xlen = sqrtE[i] - 1;
                n = 1;
            }

            if (sqrtE[i] > y && m < 1) {
                yy = sqrtE[i - 1];						////finds limits of y and its place in sudoku box
                ylen = sqrtE[i] - 1;
                m = 1;
            }

        }

        for (int r = xx; r <= xlen; r++) {
            for (int c = yy; c <= ylen; c++) {     //checks box for elements existence in sudoku
                System.out.print("**"+temp[c][r]+"**["+r+"]["+c+"]");
                if (temp[c][r] == v) {
                    ui.inSudoku();
                    return false;
                }
            }
            System.out.println();
        }

        return true;
    }

    //if all squares in sudoku are filled with elements greater than 0, sudoku is solved
    public boolean isSolved() {

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {   //iterates through entire sudoku 2-D array
                if (sudoku[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public int size() {
        this.size=size;
        // TODO Auto-generated method stub
        return size;
    }
}
