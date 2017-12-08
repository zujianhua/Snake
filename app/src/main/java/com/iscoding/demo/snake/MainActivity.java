package com.iscoding.demo.snake;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iscoding.demo.snake.view.GameView;

public class MainActivity extends AppCompatActivity {
    private static final int WHAT_REFRESH = 200;
    private int time = 200;// 每次刷新时间间隔

    private int count = 0 ;
    private GameView gameView;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(WHAT_REFRESH == msg.what){
                boolean isAdd = false;
                count ++ ;
                if(count % 20 == 0){
                    isAdd = true;
                    if(time - 10 >0){
                        time = time -10;
                    }
                }
                boolean isFailed = gameView.refreshView(isAdd);
                if(!isFailed){//没有结束继续发线程
                    sendControlMessage();
                }else{
                    // 结束告诉程序你输了
                }

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        gameView.setClickable(true);
        setContentView(gameView);
        sendControlMessage();
    }
    private void sendControlMessage(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(WHAT_REFRESH);
            }
        },time);
    }
}
