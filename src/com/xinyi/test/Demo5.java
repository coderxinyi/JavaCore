package com.xinyi.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2023/09/05 13:39:00
 */
public class Demo5 {
    public static void main(String[] args) {

        // 创建一个包含多个对象的 List
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("john@example.com", "John"));
        personList.add(new Person("mary@example.com", "Mary"));
        personList.add(new Person("john@example.com", "John")); // 重复的 email
        personList.add(new Person("david@example.com", "David"));

        // 使用 Stream 进行去重
        List<Person> uniquePersons = personList.stream()
                                               .sorted(Comparator.comparing(Person::getEmail))
                                               .distinct()
                                               .collect(Collectors.toList());

        // 打印去重后的结果
        for (Person person : uniquePersons) {
            System.out.println(person.getEmail() + " - " + person.getName());
        }
    }

    // 人员对象类
    static class Person {
        private String email;
        private String name;

        public Person(String email, String name) {
            this.email = email;
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }
    }



}
