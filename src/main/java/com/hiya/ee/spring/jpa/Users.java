package com.hiya.ee.spring.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @Table 标注类对应的表 若表名和类型相同时，省略@Table,比如类Users 和表 users;
 *        若不相同时，必须有@Table，并设置name,为该类对应的表名。@Table(name="users")
 * 
 * @Entity 标注实体
 * 
 * @Id 标注id
 * 
 * @Transient 标注该属性不做与表的映射(原因：可能表中没有该属性对应的字段)
 *            有该注解，在执行sql语句时，就不会出现该属性，否则会有，若表中没有该字段则会报错
 * 
 * @Basic 默认所有属性都有该注解(主键需要单独使用@Id)，所以可以省略 该注解可以放在属性上，也可以放在对应的getter方法上。
 *        注意：要么统一将@Basic放在属性上，要么统一放在对应的getter方法上。（一般都放在属性上，可读性比较好）
 * 
 * @Column 类中属性名和表中对应字段名不相同时，会使用该注解，指明在类中对应的字段 @Column(name="对应的表中字段名")
 *
 */
@Table(name = "users")
@Entity
public class Users
{
    // 标注id
    @Id
    private String uid;
    @Basic
    @Column(name = "uname")
    private String uname;
    @Basic
    private int age;

    @Transient
    private String remark;// 备注

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getUname()
    {
        return uname;
    }

    public void setUname(String uname)
    {
        this.uname = uname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Users [uid=" + uid + ", uname=" + uname + ", age=" + age + "]";
    }

    public Users(String uid, String uname, int age)
    {
        super();
        this.uid = uid;
        this.uname = uname;
        this.age = age;
    }

    public Users()
    {
        super();
    }
}