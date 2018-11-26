package com.hiya.ee.spring.transcation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * propagation:传播特性
 * isolation：隔离级别
 * @author zjq
 *
 */
@Service
public class PropagatiCurrentService
{
     @Autowired
     PropagatiOtherService bookService;
    
     /**
      * 从测试结果可以看到，我们在数据库中成功插入了doBook1()方法中要插入的数据，而doUser1()中插入的数据被回滚了，
      * 这是因为我们在doBook1()方法中加入ROPAGATION_REQUIRES_NEW传播行为，
      * doBook1()创建了属于自己的事务，挂起了doUser1()中的事务，所以事务B提交了，而事务A因为执行[java.lang.ArithmeticException: / by zero]异常插入的数据被回滚了。
      * @return
      * @throws Exception
      */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public String doUser1() throws Exception
    {
         bookService.doRequiresNew();
         int i = 1 / 0;
         System.out.println(i);
         return "200";
    }
    

    /**
     *从结果可以看到，我们没有成功插入数据，这是为什么呢？
     *因为我们使用的是第一种传播行为PROPAGATION_REQUIRED ，doB()方法被加入到doA()的事务中，doA()执行时抛出了异常，
     *因为doB()和doA()同属于一个事务，则执行操作被一起回滚了。其实在doB()中我们不加入注解，也等同PROPAGATION_REQUIRED的效果。
     *
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public String doUser2() throws Exception
    {
         bookService.doRequired();
         int i = 1 / 0;
         System.out.println(i);
         return "200";
    }
    
    
    
    /**
     *可以看到doB()方法成功插入了数据。doA()方法中插入的数据被回滚了。
     *这是因为传播行为PROPAGATION_NOT_SUPPORTED是doB()以非事务执行的，并且提交了。
     *所以当doA()的事务被回滚时，doB()的操作没有被回滚。
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public String doUser3() throws Exception
    {
         bookService.doNotSupported();
         int i = 1 / 0;
         System.out.println(i);
         return "200";
    }
    
}
