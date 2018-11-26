package com.hiya.ee.spring.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * 自定义scope 
 * @author czj
 *
 */
public class CustomThreadScope implements Scope
{
    private final ThreadLocal<Map<String, Object>> THREAD_SCOPE = new ThreadLocal<Map<String, Object>>()
    {
        protected Map<String, Object> initialValue()
        {
            return new HashMap<String, Object>();
        }
    };

    /**
     * 这里以自定义作用域为例，探究下 scope 的基本原理。在 Spring 中对于 Bean 的 scope（作用域）的检查发生在【获取 Bean】的过程中。获取方法如下：
Animals animals1 = (Animals) factory.getBean("animals");
由此可见，获取 Bean 的入口在 BeanFacotry 中定义。而 BeanFacotry 的基本功能实现都在它的基本实现类 AbstractBeanFactory 中，具体的调用过程这里不再探究，简单的调用流程如下： getBean -> doGetBean。因此这里重点来看下 doGetBean 这个方法：

protected <T> T doGetBean(final String name, final Class<T> requiredType, final Object [ ] args, boolean typeCheckOnly) 
throws BeansException {
    final String beanName = transformedBeanName(name);

    // 省略部分源码...

        try {
            // 省略部分源码...

            // 判断 scope 作用域
            // 若既不是 singleton 也不是 prototype，表明该 Bean 的作用域是自定义作用域或 web 作用域
            if (mbd.isSingleton()) {

                // 省略部分源码...

            }else if (mbd.isPrototype()) {

                // 省略部分源码...

            }else {

                // 取得 Bean 的 scope 名称，这里指 thread
                String scopeName = mbd.getScope();

                // 取得在 CustomScopeConfigurer 中定义的 scope 对象，这里指 ThreadScope 对象
                final Scope scope = this.scopes.get(scopeName);


                if (scope == null) {
                    // 抛出异常...
                }

                try {

                    // 调用 scope 的 get 方法
                    Object scopedInstance = scope.get(beanName, new ObjectFactory<Object>() {

                        // 若不存在该标识的 bean，则触发 map.put(name, objectFactory.getObject()) 的 getObject 方法
                        @Override
                        public Object getObject() throws BeansException {


                            beforePrototypeCreation(beanName);

                            try {
                                // 创建 Bean 实例 
                                return createBean(beanName, mbd, args);
                            } finally {
                                afterPrototypeCreation(beanName);
                            }
                        }

                    });
                    bean = getObjectForBeanInstance(scopedInstance, name, beanName, mbd);

                } catch (IllegalStateException ex) {
                    // 抛出异常...
                }
            }

        } catch (BeansException ex) {
            cleanupAfterBeanCreationFailure(beanName);
            throw ex;
        }
    }

    // 省略部分源码...
}
     */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory)
    {
        Map<String, Object> map = THREAD_SCOPE.get();
        if (!map.containsKey(name))
        {
            map.put(name, objectFactory.getObject());
        }
        return map.get(name);
    }

    @Override
    public Object remove(String name)
    {
        Map<String, Object> map = THREAD_SCOPE.get();
        return map.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback)
    {
    }

    @Override
    public Object resolveContextualObject(String key)
    {
        return null;
    }

    @Override
    public String getConversationId()
    {
        return null;
    }
}