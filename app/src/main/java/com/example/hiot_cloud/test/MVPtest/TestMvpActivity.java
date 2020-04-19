package com.example.hiot_cloud.test.MVPtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiot_cloud.main.MainActivity;
import com.example.hiot_cloud.R;
import com.example.hiot_cloud.base.BaseActivity;
import com.example.hiot_cloud.test.MVPtest.dagger2test.DaggerPresenterComponent;
import com.example.hiot_cloud.test.MVPtest.dagger2test.PresenterComponent;
import com.example.hiot_cloud.test.MVPtest.model.User;

import javax.inject.Inject;


public class TestMvpActivity extends BaseActivity<TestView,TestPresenter> implements TestView{

    @Inject
    TestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getActivityComponent().inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_mvp);
        final EditText etName = findViewById(R.id.et_username);
        final EditText etPassword = findViewById(R.id.et_password);
//      final TestPresenter presenter = new TestPresenter();
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
    public TestPresenter createPresenter() {
        return presenter;
    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
