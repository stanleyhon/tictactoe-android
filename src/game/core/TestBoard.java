package game.core;

public abstract class TestBoard {

   public static void runTests() {
      System.out.println("Test 1: Test if making moves is working correctly");
      Board b = new Board();
      b.makeMove(0, 2, Board.CROSS);
      b.makeMove(1, 1, Board.NOUGHT);
      assert (b.getBoardData(0, 2) == Board.CROSS) : "ERROR: Failed to place a cross";
      assert (b.getBoardData(1, 1) == Board.NOUGHT) : "ERROR: Failed to place a nought";
      b.makeMove(1, 1, Board.EMPTY_SPOT);
      assert (b.getBoardData(1, 1) == Board.NOUGHT) : "ERROR: Succeeded in placing a empty spot";
      System.out.println("Test 1 Passed\n");

      System.out.println("Test 2: Test if boards are being displayed properly");
      b = new Board();
      b.makeMove(0, 0, Board.CROSS);
      b.makeMove(1, 1, Board.CROSS);
      b.makeMove(2, 2, Board.CROSS);
      b.makeMove(0, 2, Board.CROSS);
      b.makeMove(2, 0, Board.CROSS);
      b.printBoard();
      System.out.println("Should have displayed a cross made of crosses.");
      System.out.println("Test 2 Passed\n");
   }
}
