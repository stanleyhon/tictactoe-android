package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import game.core.*;

/**
 * Created with IntelliJ IDEA.
 * User: stanleyhon
 * Date: 9/07/12
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hotseat extends Activity {

   private Board b = new Board();
   private int currentPlayer = Board.CROSS;
   private boolean gameOver = false;
   private int turns = 0;

   @Override
   public void onCreate (Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.hotseat);


   }

   public void buttonPressed(View view) {
      TTTButton pressedButton = (TTTButton) view;
      int xTarget = pressedButton.getX();
      int yTarget = pressedButton.getY();

      TextView currentPlayer = (TextView) this.findViewById(R.id.currentPlayer);

       if (currentPlayer.getText().toString().equals("X") && gameOver == false && this.turns != 9) {
          this.turns++;
          this.b.makeMove(xTarget, yTarget, Board.CROSS);


          if (WinChecker.check(this.b) == true) {
             TextView tv = (TextView) this.findViewById(R.id.WinIndicator);
             tv.setText("WINNER:");
             gameOver = true;
          }
          pressedButton.setText("O");
          currentPlayer.setText("O");
       } else if (currentPlayer.getText().toString().equals("O")){
          this.b.makeMove(xTarget, yTarget, Board.NOUGHT);
          if (WinChecker.check(this.b) == true) {
             TextView tv = (TextView) this.findViewById(R.id.WinIndicator);
             tv.setText("WINNER:");
             gameOver = true;
          }
          pressedButton.setText("X");
          currentPlayer.setText("X");

       } else if (this.turns == 9) {
          TextView tv = (TextView) this.findViewById(R.id.WinIndicator);
          tv.setText("TIED");
          currentPlayer.setText("");

       }

       pressedButton.setClickable(false);



   }

}
