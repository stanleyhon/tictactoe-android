package game.core;

public abstract class WinChecker {

   
   public static boolean check (Board b) {
      if (checkHorizontal(b) || checkVertical(b) || checkDiagonal(b)) {
         return true;
      } else {
         return false;
      }
   }
   
   private static boolean checkHorizontal (Board b) {
      int maxLength = Board.BOARD_SIZE;
      int previousPlayerFound = b.getBoardData(0, 0);
      int playerFound = b.getBoardData(0, 0);
      
      boolean winner = true;
      
      int y = 0;
      while (y < maxLength) {
         int x = 0;
         // Initialise 
         previousPlayerFound = b.getBoardData(x, y);
         winner = true;
         
         while (x < maxLength && winner == true) {
            playerFound = b.getBoardData(x, y);
            if (previousPlayerFound != playerFound) {
               winner = false;
            } else if (playerFound == Board.EMPTY_SPOT) {
               winner = false;
            }
            previousPlayerFound = playerFound;
            x++;
         }
         if (winner == true) {
            break;
         }
         y++;
      }
      
      return winner;
   }
   
   private static boolean checkVertical (Board b) {
      int maxLength = Board.BOARD_SIZE;
      int previousPlayerFound = b.getBoardData(0, 0);
      int playerFound = b.getBoardData(0, 0);
      
      boolean winner = true;
      
      int x = 0;
      while (x < maxLength) {
         int y = 0;
         
         // Initialise 
         previousPlayerFound = b.getBoardData(x, y);
         winner = true;
         
         while (y < maxLength && winner == true) {
            playerFound = b.getBoardData(x, y);
            if (previousPlayerFound != playerFound) {
               winner = false;
            } else if (playerFound == Board.EMPTY_SPOT) {
               winner = false;
            }
            previousPlayerFound = playerFound;
            y++;
         }
         if (winner == true) {
            break;
         }
         x++;
      }
      
      return winner;
   }
   
   private static boolean checkDiagonal (Board b) {
      int maxLength = Board.BOARD_SIZE;

      // Bottom left to top right
      int targetX = 0;
      int targetY = 0;
      int previousTarget = b.getBoardData(0, 0);
      int target;
      
      // Init
      boolean winner = true;
      while (targetX < maxLength && winner == true) {
         target = b.getBoardData(targetX, targetY);
         if (target != previousTarget) {
            winner = false;
         } else if (target == Board.EMPTY_SPOT) {
            winner = false;
         }
         targetX = targetX + 1;
         targetY = targetY + 1;
      }
      
      // Top left to bottom right
      if (winner == false) {
         winner = true;
         
         // Init
         targetX = 0;
         targetY = Board.BOARD_SIZE - 1;
         previousTarget = b.getBoardData(targetX, targetY);
         
         while (targetX < maxLength && winner == true) {
            target = b.getBoardData(targetX, targetY);
            if (target != previousTarget) {
               winner = false;
            } else if (target == Board.EMPTY_SPOT) {
               winner = false;
            }
            targetX++;
            targetY--;
         }
      }
      
      return winner;
   }
}
