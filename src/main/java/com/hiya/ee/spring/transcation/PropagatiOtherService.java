package com.hiya.ee.spring.transcation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropagatiOtherService
{
    /**
     * PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.DEFAULT,rollbackFor=Exception.class,timeout=30)  
    public String doRequiresNew() throws Exception 
    {
        return "success";
    }
    
    /**
     * PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。
     * 这个是默认的机制。
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)  
    public String doRequired() throws Exception 
    {
        return "success";
    }
    
    /**
     * PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)  
    public String doNotSupported() throws Exception 
    {
        return "success";
    }
    
    /**
     * PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)  
    public String doSupports() throws Exception 
    {
        return "success";
    }
    
    /**
     * PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.NEVER,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)  
    public String doNever() throws Exception 
    {
        return "success";
    }
    
    /**
     * PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.NESTED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)  
    public String doNested() throws Exception 
    {
        return "success";
    }
}
