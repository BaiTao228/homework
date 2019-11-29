package com.example.zhiHuRiBao;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toast mytoast;
    public void displayToast(String str){
        if(mytoast==null){
            mytoast=Toast.makeText(this,str,Toast.LENGTH_SHORT);
        }
        else
            mytoast.setText(str);
        mytoast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        Window window =getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // 5.0 以上全透明状态栏
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏 加下面几句可以去除透明状态栏的灰色阴影,实现纯透明
           window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            //6.0 以上可以设置状态栏的字体为黑色.使用下面注释的这行打开亮色状态栏模式,实现黑色字体,白底的需求用这句setStatusBarColor(Color.WHITE);
//            window.getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(Color.TRANSPARENT);

        }else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){//4.4 全透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Button button1=(Button) findViewById(R.id.button_1);//实例对象
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("你点击了用户名登录");
                Intent intent = new Intent(MainActivity.this,usersignup.class);
                startActivity(intent);
            }
        });
        Button button2=(Button) findViewById(R.id.button_2);//实例对象
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("你点击了新浪微博！");
                Intent intent = new Intent(MainActivity.this,webosignup.class);
                startActivity(intent);
            }
        });
        Button button3=(Button) findViewById(R.id.button_3);//实例对象
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("你点击了腾讯微博！");
                Intent intent = new Intent(MainActivity.this,webosignup.class);
                startActivity(intent);
            }
        });/*
        Button button4=(Button) findViewById(R.id.button_4);//实例对象
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,usersignup.class);
                startActivity(intent);
            }
        });*/
    }
}