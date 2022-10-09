package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class SpringormApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringormApplication.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDAO = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student(222, "Avinash", "Dhanbad");
//
//        int r = studentDAO.insert(student);
//        System.out.println(r);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("PRESS 1 for add new student");
        System.out.println("PRESS 2 for display all students");
        System.out.println("PRESS 3 for get details of single student");
        System.out.println("PRESS 4 for delete student");
        System.out.println("PRESS 5 for update student");
        System.out.println("PRESS 6 for exit");

    }

}
