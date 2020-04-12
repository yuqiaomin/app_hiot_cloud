package com.example.hiot_cloud.test.MVPtest;

import com.example.hiot_cloud.test.MVPtest.model.User;

public class TestPresenter {

    public static Boolean mark;
    private TestView view;
    public TestPresenter(TestView view) {
        this.view = view;
    }

    public void login(User user){



            if ("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())) {
                view.showMessage("登录成功");
                mark = true;

            } else {
                view.showMessage("用户名或密码错误！");
                mark = false;
            }
    }

}
