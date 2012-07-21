package game.core;

import java.util.Random;

public abstract class BoardAI {

   public static void generateMove(Board b, int currentPlayer) {
      // 1. Try and win the game
      if (!canWin(b, currentPlayer)) {
         // 2. Try an stop them winning next turn
         if (!canStopWin(b, currentPlayer)) {
            // 3. Try and create a fork
            if (!canCreateFork(b, currentPlayer)) {
               // 4. Try and stop them creating a fork
               if (!canStopFork(b, currentPlayer)) {
                  // 5. Just go randomly if none of the above work
                  randomMove(b, currentPlayer);
               }
            }
         }
      }
   }

   private static boolean canWin(Board b, int currentPlayer) {
      int x = 0;
      int y = 0;
      boolean foundWin = false;
      while (x < Board.BOARD_SIZE && foundWin == false) {
         y = 0;
         while (y < Board.BOARD_SIZE) {
            if (b.getBoardData(x, y) == Board.EMPTY_SPOT && foundWin == false) {
               b.makeMove(x, y, currentPlayer);
               if (WinChecker.check(b) == true) {
                  // found a way to win
                  // leave it alone and break out
                  foundWin = true;
               } else {
                  // Undo the move
                  b.clearSpot(x, y);
               }
            }
            y++;
         }
         x++;
      }
      return foundWin;
   }

   // Check if the other player can win using canWin on the other player.
   // Check for that case if you can break the win.

   private static boolean canStopWin(Board b, int currentPlayer) {
      // Step 1. Clone the Board
      Board bClone = new Board(b);
      // See if the other player can win.
      int otherPlayer;
      if (currentPlayer == Board.NOUGHT) {
         otherPlayer = Board.CROSS;
      } else {
         otherPlayer = Board.NOUGHT;
      }

      boolean crisisAverted = false;
      if (canWin(bClone, otherPlayer) == true) { // They can win, so we need to stop them
         int x = 0;
         int y = 0;
         while (x < Board.BOARD_SIZE && crisisAverted == false) {
            y = 0;
            while (y < Board.BOARD_SIZE && crisisAverted == false) {
               bClone = new Board(b);
               bClone.makeMove(x, y, currentPlayer);
               if (canWin(bClone, otherPlayer) == false) { // The move we just made DID stop them winning
                  crisisAverted = true;
                  b.makeMove(x, y, currentPlayer); // Make the move on the real board
               }
               y++;
            }
            x++;
         }

         if (crisisAverted == false) { // We just got GG'd, we couldn't stop them winning no matter what... gg
            randomMove(b, currentPlayer); // Just make a move, it doesn't matter....
         }
         return true;
      } else {
         return false;
      }
   }

   private static boolean canCreateFork(Board b, int currentPlayer) {

      return false;
   }

   private static boolean canStopFork(Board b, int currentPlayer) {

      return false;
   }

   private static void randomMove(Board b, int currentPlayer) {
      Random randomGenerator = new Random();
      boolean madeMove = false;
      while (madeMove == false) {
         int randomX = randomGenerator.nextInt(Board.BOARD_SIZE);
         int randomY = randomGenerator.nextInt(Board.BOARD_SIZE);

         int spotData = b.getBoardData(randomX, randomY);
         if (spotData == Board.EMPTY_SPOT) {
            b.makeMove(randomX, randomY, currentPlayer);
            madeMove = true;
         }
      }
   }

/*    unneccesary but might be useful later  */
/*
   private static int deriveWhoseTurn(Board b) {
      int x = 0;
      int y = 0;
      int crosses = 0;
      int noughts = 0;
      while (x < Board.BOARD_SIZE) {
         y = 0;
         while (y < Board.BOARD_SIZE) {
            if (b.getBoardData(x, y) == Board.CROSS) {
               crosses++;
            } else if (b.getBoardData(x, y) == Board.NOUGHT) {
               noughts++;
            }
            y++;
         }
         x++;
      }

      if (crosses == noughts) {
         return Board.NOUGHT;
      } else {
         return Board.CROSS;
      }
   }
*/
}
