package com.hiya.ee.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanClient
{

    public static void main(String[] args)
    {
         ApplicationContext factory = new FileSystemXmlApplicationContext("/applicationContext.xml");
         BeanSingletonScope s1 = (BeanSingletonScope) factory.getBean("beanSingleton");
         BeanSingletonScope s2 = (BeanSingletonScope) factory.getBean("beanSingleton");
         System.out.println(s1);
         System.out.println(s2);
         
         
         // 新建线程获取 Bean
         for(int p=0;p<3;p++)
         {
             Thread thread = new Thread() 
             {
                 public void run() 
                 {
                     BeanThreadScope beanThreadScope =  (BeanThreadScope) factory.getBean("animals");
                     System.out.println(beanThreadScope);
                 }
             };
             thread.setName("Thread"+p);
             thread.start();
         }
        
         
         

    }

}
