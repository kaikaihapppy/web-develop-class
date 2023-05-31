package com.example.random;

public class Tom {
    private int age ;

    @Override
    public String toString() {
        return "tom{" +
                "age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
