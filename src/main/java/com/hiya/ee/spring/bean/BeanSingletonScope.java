package com.hiya.ee.spring.bean;

/**
 * singleton，也称单例作用域。在每个 Spring IoC 容器中有且只有一个实例，而且其完整生命周期完全由 Spring 容器管理。
 * 对于所有获取该 Bean 的操作 Spring 容器将只返回同一个 Bean。
     需要注意的是，若一个 Bean 未指定 scope 属性，默认也为 singleton 。
 * @author zjq
 *
 */
public class BeanSingletonScope
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
