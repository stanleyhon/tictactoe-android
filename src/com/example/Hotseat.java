package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: stanleyhon
 * Date: 9/07/12
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hotseat extends Activity {

   @Override
   public void onCreate (Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.hotseat);
   }

   public void buttonPressed(View view) {
       TTTButton b = (TTTButton) view;
       AlertDialog dialog = new AlertDialog.Builder(view.getContext())
               .setMessage("("+b.getX()+","+b.getY()+")")
               .setTitle("Pressed!")
               .setCancelable(true)
               .create();
       dialog.show();
   }

}
