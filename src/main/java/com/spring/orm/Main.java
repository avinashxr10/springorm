package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDAO = context.getBean("studentDao", StudentDao.class);

        Student student = new Student(111, "Avinash", "Dhanbad");

        int r = studentDAO.insert(student);
        System.out.println(r);

    }
}
