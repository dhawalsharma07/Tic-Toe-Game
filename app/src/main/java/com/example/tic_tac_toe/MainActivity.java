package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0-X;
    //1-o
  boolean gameactive=true;
     int activePlayer=1;
  int [] gamestate={2,2,2,2,2,2,2,2,2};
  int [][] winPosition={{0,1,2},{3,4,5},{6,7,8},
                         {0,3,6},{1,4,7},{2,5,8},
                          {0,4,8},{2,4,6}};

    public void PlayerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            reset(view);
            return;
        }

        if (gamestate[tappedimage] == 2 && gameactive) {
            gamestate[tappedimage] = activePlayer;
            img.setTranslationY(-1000f);

            if (activePlayer == 0) {
                img.setImageResource(R.drawable.cross);
                activePlayer = 1;
                TextView status= findViewById(R.id.status);
                status.setText("O's turn to Play");
            }
            else{
                img.setImageResource(R.drawable.zero);
                activePlayer=0;
                TextView status= findViewById(R.id.status);
                status.setText("X's turn to Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        String winstr;
      for(int [] win:winPosition){
          if(gamestate[win[0]]==gamestate[win[1]] && gamestate[win[1]]==gamestate[win[2]] && gamestate[win[0]]!=2){


              if(gamestate[win[0]]==0){
                  winstr="X has Won";
              }
              else{
                  winstr="O has Won";
              }
              TextView status= findViewById(R.id.status);
              status.setText(winstr);
              gameactive=false;
          }
      }
          int cnt=0;
      for(int i=0;i<gamestate.length;i++){
          if(gamestate[i]==2){
              cnt++;
          }
      }
      if(cnt==0){
          winstr="No One has Won";
          TextView status= findViewById(R.id.status);
          status.setText(winstr);
          gameactive=false;
      }
    }
    public void reset(View view){
        gameactive=true;
        activePlayer=0;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}