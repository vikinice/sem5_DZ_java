/* На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.*/

import java.util.Random;


public class zadacha3 {
       public static void main(String[] args) {
        Board board = new Board(8);
        nextTurn(board);
    }

    public static class queen
    {
        int x, y;
        static int count = 0;

        public queen(Board board) {
            while (true) {
                Random rnd = new Random();
                int x = rnd.nextInt(8);
                int y = rnd.nextInt(8);
                if (board.cell[x][y] == 0) {
                    this.x = x;
                    this.y = y;
                    count++;
                    break;
                }
            }
        }
    }

    public static class Board 
    {
        int size;
        int[][] cell;

        public Board(int size) {
            this.size = size;
            this.cell = new int[this.size][this.size];
        }

        public void addQueen(queen queen, int index)
        {
            this.cell[queen.x][queen.y] = index + 2;
            for (int i = 1; i < 8; i++) {
                int x = queen.x;
                int y = queen.y;

                if ((x + i) < 8 && (y + i) < 8 && (x + i) >= 0 && (y + i) >= 0 && this.cell[x + i][y + i] == 0) {
                    this.cell[x + i][y + i] = 1;
                }
                if ((x + i) < 8 && (y - i) < 8 && (x + i) >= 0 && (y - i) >= 0 && this.cell[x + i][y - i] == 0) {
                    this.cell[x + i][y - i] = 1;
                }
                if ((y + i) < 8 && (y + i) >= 0 && this.cell[x][y + i] == 0) {
                    this.cell[x][y + i] = 1;
                }
                if ((y - i) < 8 && (y - i) >= 0 && this.cell[x][y - i] == 0) {
                    this.cell[x][y - i] = 1;
                }
                if ((x - i) < 8 && (y + i) < 8 && (x - i) >= 0 && (y + i) >= 0 && this.cell[x - i][y + i] == 0) {
                    this.cell[x - i][y + i] = 1;
                }
                if ((x - i) < 8 && (y - i) < 8 && (x - i) >= 0 && (y - i) >= 0 && this.cell[x - i][y - i] == 0) {
                    this.cell[x - i][y - i] = 1;
                }
                if ((x + i) < 8 && (x + i) >= 0 && this.cell[x + i][y] == 0) {
                    this.cell[x + i][y] = 1;
                }
                if ((x - i) < 8 && (x - i) >= 0 && this.cell[x - i][y] == 0) {
                    this.cell[x - i][y] = 1;
                }
            }
        }

        public boolean checkBoard() 
                {
            for (int[] row : this.cell) {
                for (int elem : row) {
                    if (elem == 0) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void print()
        {
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    if (this.cell[j][i] == 0 || this.cell[j][i] == 1) {
                        System.out.print(" 0 ");
                    } else {
                        System.out.print(" X ");
                  }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void nextTurn(Board board)
    {
        queen[] queens = new queen[8];
        for (int i = 0; i < 8; i++) {
            if (board.checkBoard()) {
                board = new Board(8);
                nextTurn(board);
                return;
            }
            queens[i] = new queen(board);
            board.addQueen(queens[i], i);
        }
        board.print();
    }

}