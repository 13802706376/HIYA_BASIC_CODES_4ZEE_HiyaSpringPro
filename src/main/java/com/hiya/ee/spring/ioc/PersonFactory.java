package com.hiya.ee.spring.ioc;

public class PersonFactory
{
    public PersonNonCons createPersonNonConsInstance()
    {
        return new PersonNonCons();
    }
    
    public PersonCons createPersonConsInstance()
    {
        return new PersonCons("33",1);
    }
}
