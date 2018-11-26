package com.hiya.ee.spring.bean;


/**
 * 在 Spring IoC 容器，即XmlWebApplicationContext 会为每个 HTTP 请求创建一个全新的 RequestPrecessor 对象。当请求结束后，该对象的生命周期即告结束。
 * 当同时有 10 个 HTTP 请求进来的时候，容器会分别针对这 10 个请求创建 10 个全新的 RequestPrecessor 实例，且他们相互之间互不干扰，从不是很严格的意义上说，
 * request 可以看做 prototype 的一种特例，除了场景更加具体之外，语意上差不多
 * @author zjq
 *
 */
public class BeanRequestScope
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
