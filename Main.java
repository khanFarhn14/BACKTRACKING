public class Main {
    static int n = 9;

    static boolean isSafe(int[][] board, int row, int column, int sudnmbr) {

        //Finding the Number Both Vertical and Horizontal simultaneously
        for (int i = 0; i < n; i++) {

            //Checking Vertical
            if (board[row][i] == sudnmbr) {
                return false;
            }

            //Checking Horizontal
            if (board[i][column] == sudnmbr) {
                return false;
            }
        }

        // Finding in its own 3x3 Grid

        //This will help to start at the beginning of the grid *
        int newRow = (row / 3) * 3; 
        int newColumn = (column / 3) * 3;
        // *

        //Looping through Grid
        for (int i = newRow; i <= (newRow + 2); i++) {
            for (int j = newColumn; j <= (newColumn + 2); j++) {
                if (board[i][j] == sudnmbr) {
                    return false;
                }
            }
        }
        return true;
    }

    static void sudoku(int[][] board, int row, int column) {

        //When Row is finished it moves to next Column
        if (row == n) {
            sudoku(board, 0, column + 1);
            return;
        }


        //When sudoku is Solved
        if (column == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + "  ");
                }
                System.out.println();
                System.out.println();
            }
            System.out.println();
            return;
        }



        if (board[row][column] == 0) {
            int sudokuNmbr = n;
            for (; sudokuNmbr >= 1; sudokuNmbr--) {
                if (isSafe(board, row, column, sudokuNmbr)) {
                    board[row][column] = sudokuNmbr;
                    sudoku(board, row + 1, column);
                }
            }
            if (sudokuNmbr == 0) {
                board[row][column] = 0;
                return;// why return because our program will enter in this else when
                // board[row][column] is filled default
                // so when backtracking we will also come to this else statement so we will
                // return
            }
        } else {
            sudoku(board, row + 1, column);
            return;
        }
    }

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        int[][] board = new int[n][n];

        // for filling sudoku

        // for(int i = 0; i < n; i++){
        // for(int j = 0; j < n; j++){
        // System.out.printf("board[%d][%d] = ", (i), (j));
        // board[i][j] = input.nextInt();
        // }
        // System.out.println();
        // }
        // System.out.println();

        // //hard
        // board[0][0] = 0;
        // board[0][1] = 0;
        // board[0][2] = 0;
        // board[0][3] = 6;
        // board[0][4] = 5;
        // board[0][5] = 9;
        // board[0][6] = 0;
        // board[0][7] = 0;
        // board[0][8] = 0;

        // board[1][0] = 4;
        // board[1][1] = 0;
        // board[1][2] = 0;
        // board[1][3] = 3;//here
        // board[1][4] = 0;
        // board[1][5] = 0;
        // board[1][6] = 0;
        // board[1][7] = 0;
        // board[1][8] = 0;

        // board[2][0] = 3;
        // board[2][1] = 0;
        // board[2][2] = 7;
        // board[2][3] = 8;
        // board[2][4] = 0;
        // board[2][5] = 0;
        // board[2][6] = 0;
        // board[2][7] = 0;
        // board[2][8] = 0;

        // board[3][0] = 2;
        // board[3][1] = 1;
        // board[3][2] = 0;
        // board[3][3] = 0;
        // board[3][4] = 0;
        // board[3][5] = 0;
        // board[3][6] = 0;
        // board[3][7] = 0;
        // board[3][8] = 7;

        // board[4][0] = 0;
        // board[4][1] = 0;
        // board[4][2] = 0;
        // board[4][3] = 0;
        // board[4][4] = 0;
        // board[4][5] = 1;
        // board[4][6] = 3;
        // board[4][7] = 0;
        // board[4][8] = 0;

        // board[5][0] = 0;
        // board[5][1] = 0;
        // board[5][2] = 0;
        // board[5][3] = 0;
        // board[5][4] = 9;
        // board[5][5] = 0;
        // board[5][6] = 0;
        // board[5][7] = 0;
        // board[5][8] = 8;

        // board[6][0] = 0;
        // board[6][1] = 0;
        // board[6][2] = 5;
        // board[6][3] = 0;
        // board[6][4] = 0;
        // board[6][5] = 0;
        // board[6][6] = 0;
        // board[6][7] = 0;
        // board[6][8] = 0;

        // board[7][0] = 0;
        // board[7][1] = 0;
        // board[7][2] = 6;
        // board[7][3] = 0;
        // board[7][4] = 0;
        // board[7][5] = 8;
        // board[7][6] = 0;
        // board[7][7] = 9;
        // board[7][8] = 0;

        // board[8][0] = 0;
        // board[8][1] = 3;
        // board[8][2] = 0;
        // board[8][3] = 0;
        // board[8][4] = 0;
        // board[8][5] = 0;
        // board[8][6] = 5;
        // board[8][7] = 6;
        // board[8][8] = 0;

        // Expect
        board[0][0] = 0;
        board[0][1] = 0;
        board[0][2] = 0;
        board[0][3] = 0;
        board[0][4] = 0;
        board[0][5] = 0;
        board[0][6] = 0;
        board[0][7] = 0;
        board[0][8] = 0;

        board[1][0] = 2;
        board[1][1] = 0;
        board[1][2] = 0;
        board[1][3] = 7;
        board[1][4] = 0;
        board[1][5] = 0;
        board[1][6] = 0;
        board[1][7] = 9;
        board[1][8] = 0;

        board[2][0] = 0;
        board[2][1] = 0;
        board[2][2] = 3;
        board[2][3] = 1;
        board[2][4] = 0;
        board[2][5] = 0;
        board[2][6] = 0;
        board[2][7] = 8;
        board[2][8] = 4;

        board[3][0] = 0;
        board[3][1] = 6;
        board[3][2] = 0;
        board[3][3] = 0;
        board[3][4] = 0;
        board[3][5] = 8;
        board[3][6] = 0;
        board[3][7] = 0;
        board[3][8] = 0;

        board[4][0] = 1;
        board[4][1] = 8;
        board[4][2] = 0;
        board[4][3] = 0;
        board[4][4] = 2;
        board[4][5] = 0;
        board[4][6] = 7;
        board[4][7] = 6;
        board[4][8] = 0;

        board[5][0] = 0;
        board[5][1] = 0;
        board[5][2] = 4;
        board[5][3] = 0;
        board[5][4] = 0;
        board[5][5] = 0;
        board[5][6] = 0;
        board[5][7] = 0;
        board[5][8] = 0;

        board[6][0] = 0;
        board[6][1] = 3;
        board[6][2] = 0;
        board[6][3] = 0;
        board[6][4] = 0;
        board[6][5] = 4;
        board[6][6] = 0;
        board[6][7] = 0;
        board[6][8] = 0;

        board[7][0] = 6;
        board[7][1] = 0;
        board[7][2] = 0;
        board[7][3] = 2;
        board[7][4] = 0;
        board[7][5] = 0;
        board[7][6] = 8;
        board[7][7] = 0;
        board[7][8] = 0;

        board[8][0] = 0;
        board[8][1] = 0;
        board[8][2] = 0;
        board[8][3] = 0;
        board[8][4] = 0;
        board[8][5] = 3;
        board[8][6] = 5;
        board[8][7] = 0;
        board[8][8] = 9;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();

        sudoku(board, 0, 0);
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration);
    }
}
// when sudoku was easy
// when the grid is first
// 2,59,97,650 when grid is up run 4 times

// when the grid is below horizontal and column
// 2,17,51,150

// Difference is 42,56,500

// when sudoku was hard

// hard one
// when grid is up
// 1st run = 31979800
// 2nd run = 61619300
// 3rd run = 30250800
// 4th run = 73567200
// 5th run = 31748300

// Average = 45833080

// when grid is below
// 1st run = 28980500
// 2nd run = 101406899
// 3rd run = 26452901
// 4th run = 31304200
// 5th run = 29663800

// Average run = 43561660
// when the grid is first
// 4,58,33,080

// when the grid is below
// 4,35,61,660

// Difference is 22,71,420