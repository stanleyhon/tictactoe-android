package game.core;

public abstract class TestWinChecker {
   
   public static void runTests () {
      System.out.println ("Test 1: Test if empty boards are being correctly detected!");
      Board b = new Board();
      assert (WinChecker.check(b) == false) : "Failed";
      System.out.println ("Test 1 Passed\n");
      
      System.out.println ("Test 2: Test if vertical win is being detected!");
      b.makeMove(0, 0, Board.CROSS);
      b.makeMove(0, 1, Board.CROSS);
      b.makeMove(0, 2, Board.CROSS);
      assert (WinChecker.check(b) == true) : "Failed";
      System.out.println ("Test 2 Passed\n");
      
      b = new Board();
      System.out.println ("Test 3: Test if diagonal win is being detected!");
      b.makeMove(0, 0, Board.CROSS);
      b.makeMove(1, 1, Board.CROSS);
      b.makeMove(2, 2, Board.CROSS);
      assert (WinChecker.check(b) == true) : "Failed";
      System.out.println ("Test 3 Passed\n");
      
      b = new Board();
      System.out.println ("Test 4: Test if horizontal win is being detected!");
      b.makeMove(0, 0, Board.CROSS);
      b.makeMove(1, 0, Board.CROSS);
      b.makeMove(2, 0, Board.CROSS);
      assert (WinChecker.check(b) == true) : "Failed";
      System.out.println ("Test 4 Passed\n");
      
      b = new Board();
      System.out.println ("Test 5: Test if non-win is being detected!");
      b.makeMove(0, 0, Board.CROSS);
      b.makeMove(1, 2, Board.CROSS);
      b.makeMove(2, 1, Board.CROSS);
      assert (WinChecker.check(b) == false) : "Failed";
      System.out.println ("Test 5 Passed");
   }
   
}
