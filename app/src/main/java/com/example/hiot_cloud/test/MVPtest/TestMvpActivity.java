package com.example.hiot_cloud.test.MVPtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiot_cloud.MainActivity;
import com.example.hiot_cloud.R;
import com.example.hiot_cloud.test.MVPtest.model.User;

public class TestMvpActivity extends AppCompatActivity implements TestView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp);
        final EditText etName = findViewById(R.id.et_username);
        final EditText etPassword = findViewById(R.id.et_password);
        final TestPresenter presenter = new TestPresenter(this);
        Button btLogin = findViewById(R.id.bt_login);

        final User user = new User();
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUserName(etName.getText().toString());
                user.setPassword(etPassword.getText().toString());
                presenter.login(user);

                if(TestPresenter.mark){
                    Intent  intent = new Intent(TestMvpActivity.this,MainActivity.class);
                    startActivity(intent);
                }
//              login(user);
            }
        });
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

//    private void login(User user) {
//        if ("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())){
//            Toast.makeText(this,"登入成功",Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this,"用户名或密码错误！",Toast.LENGTH_SHORT).show();
//        }
//    }
}
