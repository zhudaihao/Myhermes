package cn.wqgallery.myhermes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.wqgallery.myhermes.data.IUserData;
import cn.wqgallery.myhermes.data.User;
import xiaofei.library.hermes.Hermes;
import xiaofei.library.hermes.HermesListener;
import xiaofei.library.hermes.HermesService;

public class TextActivity extends AppCompatActivity {
    private IUserData iUserData;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        init();
    }

    private void init() {
        //在连接前 设置监听
        Hermes.setHermesListener(new HermesListener() {
            //回调这个方法表示连接成功
            @Override
            public void onHermesConnected(Class<? extends HermesService> service) {
                //获取单利对象
                //连接成功，首先获取单例
                /**
                 * 注意子进程获取 单利参数是接口类
                 */
                iUserData = Hermes.getInstance(IUserData.class);

                //通过单例获取UserInfo
                user = iUserData.getUser();
                Log.e("zdh", "----连接成功:" + user.toString());

            }
        });

        //连接
        Hermes.connect(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //断开连接
        Hermes.disconnect(this);
    }

    public void click(View view) {
        //设置新的数据到user对象
        user.setAdd("广东省深圳市");

        //下面这个操作咋一看以为是操作本地单例，其实操作的是主进程的单例。
        iUserData.setUser(user);


        finish();


    }
}
