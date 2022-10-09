package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDAO = context.getBean("studentDao", StudentDao.class);
//
//        Student student = new Student(111, "Avinash", "Dhanbad");
//
//        int r = studentDAO.insert(student);
//        System.out.println(r);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while (flag) {
            System.out.println("\n" + "PRESS 1 for add new student");
            System.out.println("PRESS 2 for display all students");
            System.out.println("PRESS 3 for get details of single student");
            System.out.println("PRESS 4 for delete student");
            System.out.println("PRESS 5 for update student");
            System.out.println("PRESS 6 for exit");

            try {

                int input = Integer.parseInt(br.readLine());

                switch (input) {
                    case 1:
                        //add a new student

                        // taking input from user
                        System.out.println("Enter user id : ");
                        int uId = Integer.parseInt(br.readLine());

                        System.out.println("Enter user name : ");
                        String uName = br.readLine();

                        System.out.println("Enter user city : ");
                        String uCity = br.readLine();

                        // creating object of student class and setting values
                        Student s = new Student();
                        s.setStudentId(uId);
                        s.setStudentName(uName);
                        s.setStudentCity(uCity);

                        //saving student object data to database
                        int r = studentDAO.insert(s);
                        System.out.println();
                        System.out.println(r + " student added\n");
                        System.out.println("*********************************\n");
                        break;
                    case 2:
                        // display all students
                        System.out.println("*********************************\n");
                        List<Student> allStudents = studentDAO.getAllStudents();
                        for (Student student : allStudents) {
                            System.out.println("Name : " + student.getStudentName());
                            System.out.println("Id : " + student.getStudentId());
                            System.out.println("City : " + student.getStudentCity());
                            System.out.println("_________________________________\n");
                        }
                        break;

                    case 3:
                        //display single student
                        System.out.println("Enter user id : ");
                        int userId = Integer.parseInt(br.readLine());
                        Student student = studentDAO.getStudent(userId);
                        System.out.println();
                        System.out.println("Name : " + student.getStudentName());
                        System.out.println("Id : " + student.getStudentId());
                        System.out.println("City : " + student.getStudentCity());
                        System.out.println("_________________________________\n");
                        break;
                    case 4:
                        //delete a student
                        System.out.println("Enter user id : ");
                        int userId1 = Integer.parseInt(br.readLine());
                        studentDAO.deleteStudent(userId1);
                        System.out.println("Student deleted....");
                        break;
                    case 5:
                        //update student
                        System.out.println("Enter user id : ");
                        int id = Integer.parseInt(br.readLine());

                        System.out.println("Updated name : ");
                        String name = br.readLine();

                        System.out.println("Updated city : ");
                        String city = br.readLine();

                        studentDAO.updateStudent(id, name, city);
                        System.out.println(id + " id Student is updated...!");
                        System.out.println("_________________________________\n");
                        break;
                    case 6:
                        //exit
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input try with another one!!");
                e.printStackTrace();
            }
        }
        System.out.println("Thank You for Using My Application");

    }
}
