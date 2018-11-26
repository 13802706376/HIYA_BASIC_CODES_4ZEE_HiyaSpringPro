package com.hiya.ee.spring.bean;

/**
 * 观察输出结果，会发现不同浏览器（不同会话）返回的 Bean 实例不同，而同一个浏览器（同一会话）多次发起请求返回的是同一个 Bean 实例。
 * @author zjq
 *
 */
public class BeanSessionScope
{
    private String name  ="3333";

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void play()
    {
       System.out.println(333);
    }
}
