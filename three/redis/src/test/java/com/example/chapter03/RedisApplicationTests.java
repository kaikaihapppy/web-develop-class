package com.example.chapter03;

import com.example.chapter03.domain.Address;
import com.example.chapter03.domain.Family;
import com.example.chapter03.domain.Person;
import com.example.chapter03.respository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private PersonRepository repository;
    @Test
    private Person createPerson(String id, String firstname, String lastname, String city, String country, String type1, String username1, String type2, String username2) {
        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setId(id);
        Address address = new Address();
        address.setCity(city);
        address.setCountry(country);
        person.setAddress(address);
        Family family1 = new Family();
        family1.setType(type1);
        family1.setUsername(username1);
        Family family2 = new Family();
        family1.setType(type2);
        family1.setUsername(username2);
        ArrayList<Family> families = new ArrayList<>();
        families.add(family1);
        families.add(family2);
        person.setFamilyList(families);
        return person;
    }
    @Test
    public void test() {
        Person person1 = createPerson("1", "张", "三", "温州", "中国", "父亲", "张四", "母亲", "小花");
        Person person2 = createPerson("2", "王", "五", "杭州", "中国", "父亲", "老王", "母亲", "小菲");
        repository.save(person1);
        repository.save(person2);
    }

    @Test
    public void testFind() {
        List<Person> personList = repository.findByLastname("三");
        for (Person person : personList) {
            System.out.println(person);
        }
    }

}
