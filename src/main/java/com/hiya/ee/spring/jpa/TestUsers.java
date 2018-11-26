package com.hiya.ee.spring.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public class TestUsers extends TestCase
{

    // 插入数据 persist 相当于hibernate save方法
    public void testInsert()
    {
        // 1.获得Factory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
        // 2.获取Manager
        EntityManager manager = factory.createEntityManager();
        // 3.获得事务，并开启uiwu
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        // 4.执行sql
        Users users = new Users("1", "小明", 18);
        manager.persist(users);
        // 5.提交事务，关闭资源
        transaction.commit();
        manager.close();
        factory.close();
    }

    /**
     * 创建EntityManagerFactory的第二种方式 可以将如下配置放在创建factory是进行配置，使用map
     * <property name="hibernate.show_sql" value="true" />
     * <property name= "hibernate.format_sql" value="true" />
     * 
     * 当配置文件中和创建factory时有同一配置时，会按照创建的factory中的设置执行
     */
    public void testInsert2()
    {
        // 1.获得Factory
        Map properties = new HashMap<String, Object>();
        properties.put("hibernate.format_sql", "false");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA", properties);
        // 2.获取Manager
        EntityManager manager = factory.createEntityManager();
        // 3.获得事务，并开启uiwu
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        // 4.执行sql
        Users users = new Users("2", "小明2", 18);
        manager.persist(users);
        // 5.提交事务，关闭资源
        transaction.commit();
        manager.close();
        factory.close();
    }

    // 根据id查询 find 相当于hibernate get方法
    public void testFind()
    {
        // 1.获得Factory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
        // 2.获取Manager
        EntityManager manager = factory.createEntityManager();
        // 3.获得事务，并开启事务
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        // 4.执行sql
        Users users = manager.find(Users.class, "1");
        System.out.println(users);
        // 5.提交事务，关闭资源
        transaction.commit();
        manager.close();
        factory.close();
    }

    // 根据id查询 getReference 相当于hibernate load方法
    // find和getReference的区别----与hibernate中get和load的区别一样---懒加载--id没有对应值时报异常
    public void testGet()
    {
        // 1.获得Factory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
        // 2.获取Manager
        EntityManager manager = factory.createEntityManager();
        // 3.获得事务，并开启事务
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        // 4.执行sql
        Users users = manager.getReference(Users.class, "1");
        System.out.println(users);
        // 5.提交事务，关闭资源
        transaction.commit();
        manager.close();
        factory.close();
    }

    // 修改数据
    public void testUpdate()
    {
        // 1.获得Factory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
        // 2.获取Manager
        EntityManager manager = factory.createEntityManager();
        // 3.获得事务，并开启事务
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        // 4.执行sql
        Users users = manager.find(Users.class, "1");
        users.setUname("哈哈哈1");
        // 5.提交事务，关闭资源
        transaction.commit();
        manager.close();
        factory.close();

    }

    // 删除数据 remove 相当于hibernate delete方法
    // remove方法只能移除执久化对象，不能删除游离对象
    public void testRemove()
    {
        // 1.获得Factory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
        // 2.获取Manager
        EntityManager manager = factory.createEntityManager();
        // 3.获得事务，并开启事务
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        // 4.执行sql
        Users users = manager.find(Users.class, "2");
        manager.remove(users);
        // 5.提交事务，关闭资源
        transaction.commit();
        manager.close();
        factory.close();
    }

}
