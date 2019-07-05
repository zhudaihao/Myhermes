package cn.wqgallery.myhermes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.wqgallery.myhermes.data.User;
import cn.wqgallery.myhermes.data.UserData;
import xiaofei.library.hermes.Hermes;

public class MainActivity extends AppCompatActivity {
    private UserData userData;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //注册 ，给其他进程共享单利类
        Hermes.register(UserData.class);

        //获取单例
        userData = UserData.getInstance();


    }

    public void click(View view) {
        //保存数据
        user.setName("张三");
        user.setAge(18);
        userData.setUser(user);

        startActivity(new Intent(this, TextActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        user = userData.getUser();
        if (user == null) {
            user = new User();
            userData.setUser(user);
        }

        //更新界面
        Log.e("zdh", "--------------" + user.toString());

    }


}
