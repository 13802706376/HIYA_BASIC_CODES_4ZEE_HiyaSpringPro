package com.hiya.ee.spring.bean;

public class BeanCustomScope
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
