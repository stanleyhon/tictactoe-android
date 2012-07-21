package game.core;

public abstract class TestBoardAI {
   public static void runTests() {
      System.out.println("Test 1: Test if a random move is being done on a board with nothing");
      Board b = new Board();
      b.printBoard();
      BoardAI.generateMove(b, Board.NOUGHT);
      System.out.println();
      b.printBoard();
      int numberOfMovesFound = 0;
      int x = 0;
      int y = 0;
      while (x < Board.BOARD_SIZE) {
         y = 0;
         while (y < Board.BOARD_SIZE) {
            if (b.getBoardData(x, y) != Board.EMPTY_SPOT) {
               numberOfMovesFound++;
            }
            y++;
         }
         x++;
      }
      assert (numberOfMovesFound == 1) : "Test 1 Failed: More than 1 move was made by the AI";
      System.out.println("Test 1 Passed\n");

      System.out.println("Test 2: Test if the AI will win if possible.");
      b = new Board();
      b.makeMove(0, 2, Board.CROSS);
      b.makeMove(2, 2, Board.CROSS);
      b.makeMove(1, 1, Board.NOUGHT);
      b.makeMove(1, 2, Board.NOUGHT);
      /*
      X | O | X
        | O |
        |   |
      Block should occur at bottom mid
      */

      b.printBoard();
      BoardAI.generateMove(b, Board.NOUGHT);
      System.out.println();
      b.printBoard();
      System.out.println();
      assert (b.getBoardData(1,0) == Board.NOUGHT) : "Test 2 Failed: AI did not win when it could";


      b = new Board();
      /*
      0 | X | X
        | 0 | X
        |   |
       */
      b.makeMove(0, 2, Board.NOUGHT);
      b.makeMove(1, 1, Board.NOUGHT);
      b.makeMove(1, 2, Board.CROSS);
      b.makeMove(2, 2, Board.CROSS);
      b.makeMove(2, 1, Board.CROSS);
      b.printBoard();
      BoardAI.generateMove(b, Board.NOUGHT);
      System.out.println();
      b.printBoard();
      assert (b.getBoardData(2,0) == Board.NOUGHT) : "Test 2 Failed: AI did not win when it could";
      System.out.println("Test 2 Passed\n");

      System.out.println("Test 3: Test if the AI will stop people winning.");
      b = new Board();
      b.makeMove(0, 2, Board.CROSS);
      b.makeMove(0, 1, Board.CROSS);
      b.makeMove(2, 2, Board.CROSS);
      b.makeMove(1, 2, Board.NOUGHT);
      b.makeMove(2, 1, Board.NOUGHT);
      /*
      X | O | X
      X |   | O
        |   |
      Block should occur at bottom mid
      */

      b.printBoard();
      BoardAI.generateMove(b, Board.NOUGHT);
      System.out.println();
      b.printBoard();
      System.out.println();
      assert (b.getBoardData(0, 0) == Board.NOUGHT) : "Test 2 Failed: AI did not block when it could";

      b = new Board();
      /*
      0 | X | X
        |   | X
        | 0 |
       */
      b.makeMove(0, 2, Board.NOUGHT);
      b.makeMove(1, 0, Board.NOUGHT);
      b.makeMove(1, 2, Board.CROSS);
      b.makeMove(2, 2, Board.CROSS);
      b.makeMove(2, 1, Board.CROSS);
      b.printBoard();
      BoardAI.generateMove(b, Board.NOUGHT);
      System.out.println();
      b.printBoard();
      assert (b.getBoardData(2,0) == Board.NOUGHT) : "Test 2 Failed: AI did not block when it could";
      System.out.println("Test 2 Passed\n");

   }
}
