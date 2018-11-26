package com.hiya.ee.spring.bean;

/**
 * globalSession，类似于session 作用域，只是其用于 portlet 环境的 web 应用。如果在非portlet 环境将视为 session 作用域。
 * @author zjq
 *
 */
public class BeanGlobalSessionScope
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
