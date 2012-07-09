package com.example;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: stanleyhon
 * Date: 9/07/12
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class TTTButton extends Button {
   private int x;
   private int y;

   public TTTButton(Context context, AttributeSet attrs, int defStyle) {
      super(context, attrs, defStyle);
   }

   public int getX () {
      return this.x;
   }

   public void setX (int x) {
      this.x = x;
   }

   public int getY () {
      return this.y;
   }

   public void setY (int y) {
      this.y = y;
   }
}
