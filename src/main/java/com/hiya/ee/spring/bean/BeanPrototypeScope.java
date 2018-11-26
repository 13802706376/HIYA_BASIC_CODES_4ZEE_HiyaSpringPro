package com.hiya.ee.spring.bean;

/**
 * prototype，也称原型作用域。每次向 Spring IoC 容器请求获取 Bean 都返回一个全新的Bean。
 * 相对于 singleton 来说就是不缓存 Bean，每次都是一个根据 Bean 定义创建的全新 Bean。
 * @author zjq
 *
 */
public class BeanPrototypeScope
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
