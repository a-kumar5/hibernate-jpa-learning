package com.techchaggi.learning.spring.CruddemoApplication;

import com.techchaggi.learning.spring.CruddemoApplication.dao.StudentDAO;
import com.techchaggi.learning.spring.CruddemoApplication.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            // createStudent(studentDAO);

            // creating multiple students
            // createMultipleStudent(studentDAO);

            // read student
            // readStudent(studentDAO);

            // run query and display result
            //queryForStudents(studentDAO);

            // query for students by last name
            // queryForStudentsByLastName(studentDAO);

            // updating the student details

            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on the id: primary key
        int studnetId = 1;
        System.out.println("Retrieve the student details of id 1");
        Student myStudent = studentDAO.findByID(1);
        System.out.println(myStudent);

        // change first and last name to "Honey" & "Bee" respectively
        myStudent.setFirstName("Honey");
        myStudent.setLastName("Bee");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Gosling");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating the student object....");
        Student tempStudent = new Student("Jim", "Carrey", "jim.carrey@gmail.com");

        // save the student in database
        System.out.println("Saving the student.....");
        studentDAO.save(tempStudent);

        // display the id of the student object
        int theId = tempStudent.getId();
        System.out.println("Saved Student. Generated id: " + theId);


        // retrieve the student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findByID(theId);

        // display student
        System.out.println("Found the student: " + myStudent);

    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        // create multiple student
        System.out.println("Creating the student object....");
        Student tempStudent1 = new Student("Ryan", "Gosling", "ryan.gosling@gmail.com");
        Student tempStudent2 = new Student("John", "Cena", "john.cena@gmail.com");
        Student tempStudent3 = new Student("leo", "caprio", "leo.caprio@gmail.com");

        // save the student in database
        System.out.println("Saving the student.....");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating the student object....");
        Student tempStudent = new Student("Jim", "Carrey", "jim.carrey@gmail.com");

        // save the student
        System.out.println("Saving the student.....");
        studentDAO.save(tempStudent);

        // display the id of the student object
        System.out.println("Saved Student. Generated id: " + tempStudent.getId());
    }
}
