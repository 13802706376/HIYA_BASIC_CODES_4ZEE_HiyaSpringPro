package com.hiya.ee.spring.ioc;

public class PersonStaticFactory
{
    public static PersonNonCons createNonConsPerson()
    {
        return new PersonNonCons();
    }

    public static PersonCons createConsPerson(Integer id, String name)
    {
        return new PersonCons(name, id);
    }
}
