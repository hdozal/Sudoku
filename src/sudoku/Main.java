package sudoku;


//Emmanuel Jacquez
//Homework 2 (Sudoku)
//Cheon

//Main class calls to ConsoleUI and Board methods until sudoku board is solved by user
public class Main {

    private ConsoleUI ui = new ConsoleUI();
    private Board board;

    public static void main(String[] args) {
        new Main().play();

    }

    //method initiates user play in the sudoku game by asking for various inputs using consoleUI
    private void play() {

        ui.welcome();
        int size = ui.askSize();       //prompts size
        if (size == -1) {
            ui.showGoodBye("GoodBye");    //if input -1 one, program ends
        }
        else {
            System.out.println(size);
            board = new Board(size);
            int[][] sudoku = new int[size][size];
            board.board(sudoku);
            System.out.println();

            while (board.isSolved() == false) {
                ui.showEnterXYV("Enter a number (x y v) or -1 to quit?");
                int x = ui.askX();
                if (x == -1) {
                    ui.showGoodBye("GoodBye");
                    break;
                }
                int y = ui.askY();
                int v = ui.askV();
                board.updateBoard(y, x, v);
            }
            ui.showMessage("Congratulations the Sudoku is solved!"); //program is solved
        }

    }
}
