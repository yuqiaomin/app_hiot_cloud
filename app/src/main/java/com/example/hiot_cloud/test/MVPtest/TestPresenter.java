package com.example.hiot_cloud.test.MVPtest;

import com.example.hiot_cloud.base.BasePresenter;
import com.example.hiot_cloud.test.MVPtest.dagger2test.ThirdObj;
import com.example.hiot_cloud.test.MVPtest.model.User;


import javax.inject.Inject;

public class TestPresenter extends BasePresenter<TestView> {

    public static Boolean mark;
    //private TestView view;
    @Inject
    ThirdObj thirdObj;

    @Inject
    public TestPresenter() {

    }


    public void login(User user){

           thirdObj.thirdAction();

            if ("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())) {
                getView().showMessage("登录成功");
                mark = true;

            } else {
                getView().showMessage("用户名或密码错误！");
                mark = false;
            }
    }

}
