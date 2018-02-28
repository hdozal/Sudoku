package sudoku;


//Emmanuel Jacquez
//Homework 1 (Sudoku)
//Cheon

//ConsoleUI class calls prompts user to choose board size and ask for X Y V values to solve sudoku

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

public class ConsoleUI {

    private InputStream in;
    private PrintStream out;
    private Scanner scnr = new Scanner(System.in);
    private int sz;

    public ConsoleUI() {
        this(System.in, System.out);
    }

    public ConsoleUI(InputStream in, PrintStream out) {
        in = System.in;
        out = System.out;

    }
    //welcome message and first input prompt for sudoku size
    public void welcome() {
        System.out.println("Welcome to Sudoku " + 2 % 3);
        System.out.println();
        System.out.print("Enter board size(4X4 or 9X9) or -1 to quit? ");

    }

    //ask for board size after invalid input was entered
    public void boardSize() {
        System.out.print("Try again and enter valid board size(4X4 or 9X9) or -1 to quit? ");
    }

    //size prompt, only inputs allowed are 4 and 9
    public int askSize() {
        int size = scnr.nextInt();
        if(size==-1){
            return -1;
        }
        sz = size;
        if (size == 4 || size == 9) {
            return size;
        } else {
            boardSize();
            return askSize();
        }

    }
    //y input prompt
    public int askY() {
        int y = scnr.nextInt();
        if (y <= 0 || y > sz) {
            System.out.println("Please enter a valid value for y from 1 to "
                    + sz);
            y = scnr.nextInt();
        }
        return y;
    }
    //x input prompt
    public int askX() {
        int x = scnr.nextInt();
        if (x == -1) {
            x = -1;
        }
        if (x <= 0 || x > sz && x != -1) {
            System.out.println("Please enter a valid value for x from 1 to "
                    + sz);
            x = scnr.nextInt();
        }
        return x;
    }
    //V input prompt
    public int askV() {
        int v = scnr.nextInt();
        if (v <= 0 || v > sz) {
            System.out.println("Please enter a valid value for v from 1 to "
                    + sz);
            v = scnr.nextInt();
        }
        return v;
    }

    public void showEnterXYV(String msg) {
        System.out.println(msg);
        ;
    }

    public void showError(String msg) {
        System.out.println(msg);
        ;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
        ;
    }

    public void showGoodBye(String msg) {
        System.out.println(msg);
        ;
    }
    //message telling user the elements entered are already in sudoku
    public void inSudoku() {
        System.out.println("Element already in Sudoku, please try again");

    }

}
