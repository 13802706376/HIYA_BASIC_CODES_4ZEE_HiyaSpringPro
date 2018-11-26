package com.hiya.ee.spring.transcation;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public class IsolationService
{

    /**
     * 使用后端数据库默认的隔离级别
     * @return
     * @throws Exception
     */
    @Transactional( isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public String doIsolation1() throws Exception
    {
         int i = 1 / 0;
         System.out.println(i);
         return "200";
    }
    
    
    /**
     * 最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读
     * @return
     * @throws Exception
     */
    @Transactional( isolation = Isolation.READ_UNCOMMITTED, rollbackFor = Exception.class)
    public String doIsolation2() throws Exception
    {
         int i = 1 / 0;
         System.out.println(i);
         return "200";
    }
    
    
    /**
     * 允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
     * @return
     * @throws Exception
     */
    @Transactional( isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public String doIsolation3() throws Exception
    {
         int i = 1 / 0;
         System.out.println(i);
         return "200";
    }
    
    
    /**
     * 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生
     * @return
     * @throws Exception
     */
    @Transactional( isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public String doIsolation4() throws Exception
    {
         int i = 1 / 0;
         System.out.println(i);
         return "200";
    }
    
    
    /**
     * 最高的隔离级别，完全服从ACID的隔离级别，确保阻止脏读、不可重复读以及幻读，也是最慢的事务隔离级别，因为它通常是通过完全锁定事务相关的数据库表来实现的
     * @return
     * @throws Exception
     */
    @Transactional( isolation = Isolation.SERIALIZABLE, rollbackFor={RuntimeException.class, Exception.class},rollbackForClassName="Exception",noRollbackForClassName={"RuntimeException","Exception"},noRollbackFor=RuntimeException.class,readOnly=false)
    public String doIsolation5() throws Exception
    {
         int i = 1 / 0;
         System.out.println(i);
         return "200";
    }
}
