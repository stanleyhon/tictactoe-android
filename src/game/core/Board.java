package game.core;

import java.util.Arrays;

public class Board {
   // NOUGHTS GOES FIRST.
   public static final int BOARD_SIZE = 3; // 3x3 tictactoe board
   public static final int EMPTY_SPOT = 0;
   public static final int NOUGHT = 1;
   public static final int CROSS = 2;
   private int[][] boardArray; // index 0,0 represents the bottom left of the board

   public Board() {
      boardArray = new int[BOARD_SIZE][BOARD_SIZE];
   }

   public Board(Board b) {
      boardArray = new int[BOARD_SIZE][BOARD_SIZE];
      int x = 0;
      int y = 0;
      while (x < Board.BOARD_SIZE) {
         y = 0;
         while (y < Board.BOARD_SIZE) {
            this.boardArray[x][y] = b.boardArray[x][y];
            y++;
         }
         x++;
      }
   }

   public void clearSpot (int xPos, int yPos) {
      boardArray[xPos][yPos] = EMPTY_SPOT;
   }

   public void makeMove(int xPos, int yPos, int player) {
      if (player == NOUGHT || player == CROSS) {
         if (boardArray[xPos][yPos] == EMPTY_SPOT) {
            boardArray[xPos][yPos] = player;
         }
      }
   }

   public int getBoardData(int xPos, int yPos) {
      assert (xPos < Board.BOARD_SIZE && yPos < Board.BOARD_SIZE) : "Trying to access off the board";
      return boardArray[xPos][yPos];
   }

   public char getBoardProcessedData(int xPos, int yPos) {
      assert (xPos < Board.BOARD_SIZE && yPos < Board.BOARD_SIZE) : "Trying to access off the board";
      int read = boardArray[xPos][yPos];
      if (read == Board.EMPTY_SPOT) {
         return '-';
      } else if (read == Board.CROSS) {
         return 'X';
      } else if (read == Board.NOUGHT) {
         return 'O';
      } else {
         return '?';
      }
   }

   public void printBoard() {
      int y = 2;
      while (y >= 0) {
         int x = 0;
         while (x < BOARD_SIZE) {
            printBoardData(boardArray[x][y]);
            x++;
         }
         System.out.println();
         y--;
      }
   }

   public void printBoardRow(int row) {
      int y = row;
      int x = 0;
      while (x < BOARD_SIZE) {
         printBoardData(boardArray[x][y]);
         x++;
      }
      System.out.println();
   }

   public void printBoardColumn(int column) {
      int x = column;
      int y = 0;
      while (y < BOARD_SIZE) {
         printBoardData(boardArray[x][y]);
         y++;
      }
      System.out.println();
   }

   private void printBoardData(int data) {
      if (data == EMPTY_SPOT) {
         System.out.print(" - ");
      } else if (data == NOUGHT) {
         System.out.print(" O ");
      } else if (data == CROSS) {
         System.out.print(" X ");
      } else {
         System.out.print(" ? ");
      }
   }
}
