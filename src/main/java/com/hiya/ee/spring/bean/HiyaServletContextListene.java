package com.hiya.ee.spring.bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebListener
public class HiyaServletContextListene implements ServletContextListener
{
    /**
     * 在应用中一般普通的JavaPojo都是由Spring来管理的，所以使用autowire注解来进行注入不会产生问题，
     * 但是有两个东西是例外的，一个是 Filter，一个是Servlet，这两样东西都是由Servlet容器来维护管理的，
     * 所以如果想和其他的Bean一样使用Autowire来注入的 话，是需要做一些额外的功夫的。
     * 
     *  AutowireCapableBeanFactory的作用
            让不受spring管理的类具有spring自动注入的特性
     */
    @Autowired
    private BeanSingletonScope beanSingletonScope;

    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
        beanSingletonScope.play();
    }

    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        System.out.println("MyServletContextListener.contextInitialized()");
        AutowireCapableBeanFactory autowireCapableBeanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext()).getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
    }
}