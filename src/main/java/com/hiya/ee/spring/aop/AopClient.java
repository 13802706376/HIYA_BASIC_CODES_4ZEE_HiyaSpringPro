package com.hiya.ee.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopClient
{
    public static void testSpringAOP()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app*.xml");
        ILoginService loginService = (ILoginService) ctx.getBean("loginService");
        loginService.login("zhangsan", "12344");
    }

    public static void main(String[] args)
    {
        testSpringAOP();
    }
}
