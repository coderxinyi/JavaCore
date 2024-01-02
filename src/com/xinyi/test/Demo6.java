package com.xinyi.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2023/10/09 11:24:00
 */
public class Demo6 {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person(11,"张三");
        Person person2 = new Person(21,"张三");
        Person person3 = new Person(31,"张三");
        Person person4 = new Person(11,"李三");
        Person person5= new Person(11,"王三");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        System.out.println(personList);

    }
}


class Person{
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
