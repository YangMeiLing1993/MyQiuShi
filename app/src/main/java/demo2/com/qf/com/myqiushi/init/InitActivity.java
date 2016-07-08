package demo2.com.qf.com.myqiushi.init;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import demo2.com.qf.com.myqiushi.MainActivity;
import demo2.com.qf.com.myqiushi.R;

public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_init);
        super.onCreate(savedInstanceState);
        new Thread(){
            @Override
            //启动软件3秒动画效果
            public void run() {
                SystemClock.sleep(3000);
                InitActivity.this.startActivity(new Intent(InitActivity.this, MainActivity.class));
                finish();
            }
        }.start();

    }
}
