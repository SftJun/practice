package com.outlook.sftjun.domain;

import javax.persistence.Entity;
import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.DynamicUpdate;
import com.querydsl.sql.Column;
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Person is a Querydsl bean type
 */
@Generated("com.zetafin.gradle.querydsl.EntityBeanSerializer")
@Entity
@DynamicInsert
@DynamicUpdate
public class Person implements Serializable {

    @Column("age")
    private Integer age;

    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

