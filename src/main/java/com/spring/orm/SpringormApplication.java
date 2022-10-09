package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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



    }

}
