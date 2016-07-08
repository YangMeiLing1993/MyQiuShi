package demo2.com.qf.com.myqiushi;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import demo2.com.qf.com.myqiushi.friends.FriendsFragment;
import demo2.com.qf.com.myqiushi.qiushi.QiushiFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager supportFragmentManager;
    private RadioGroup rg_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到fragmentManager
        supportFragmentManager = getSupportFragmentManager();
        // 思路：
        // 0、使用MyMainFragment来替换占位的容器控件
        replaceContainerWidget(new QiushiFragment());

        // 1、找到界面上的控件
        rg_id = (RadioGroup) findViewById(R.id.rg_id);

        // 2、添加监听器
        addListenerToRadioGroup();
    }

    private void addListenerToRadioGroup() {
        rg_id.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_qiushi_id:
                        replaceContainerWidget(new QiushiFragment() );
                        break;
                    case R.id.rb_qiuyou_id:
                        replaceContainerWidget(new FriendsFragment() );
                        break;
                    case R.id.rb_zhibo_id:
                        replaceContainerWidget(new FriendsFragment() );
                        break;

                    case R.id.rb_xiaozhitiao_id:
                        replaceContainerWidget(new FriendsFragment() );
                        break;

                    case R.id.rb_mine_id:
                        replaceContainerWidget(new FriendsFragment() );
                        break;
                }
            }
        });

    }
    /**
     * 初始化主界面
     */
    private void replaceContainerWidget(Fragment fragment) {

        FragmentTransaction transaction = supportFragmentManager
                .beginTransaction();
        transaction.replace(R.id.ff_content_id, fragment);
        transaction.commit();
    }
}