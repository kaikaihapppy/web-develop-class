package com.example.chapter03.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;


@RedisHash("persons")
public class Person {
    @Id //用于标识主键 import org.springframework.data.annotation.Id;
    private String id;

//用于标识改属性会在redis中生成二级索引(可能根据该属性 进行查询)
    @Indexed
    private String firstname;
    @Indexed
    private String lastname;
    @Indexed
    private Address address;
    @Indexed
    private List<Family> familyList;


    public Person() {
    }

    public Person(String id, String firstname, String lastname, Address address, List<Family> familyList) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.familyList = familyList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address=" + address +
                ", familyList=" + familyList +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }
}