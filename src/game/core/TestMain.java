package game.core;

public class TestMain {
   public static void main(String[] args) {
      // Run WinChecker tests
      System.out.println("**Running WinCheck tests...");
      TestWinChecker.runTests();
      System.out.println("Passed all WinCheck tests\n");

      // Run Board tests
      System.out.println("**Running Board tests...");
      TestBoard.runTests();
      System.out.println("Passed all Board tests\n");

      // Run AI tests
      System.out.println("**Running AI tests...");
      TestBoardAI.runTests();
      System.out.println("Passed all Board tests\n");
   }
}
