package com.hiya.ee.spring.aop;

public class LoginServiceImpl implements ILoginService
{
    public boolean login(String userName, String password)
    {
        System.out.println("login:" + userName + "," + password);
        return true;
    }
}
