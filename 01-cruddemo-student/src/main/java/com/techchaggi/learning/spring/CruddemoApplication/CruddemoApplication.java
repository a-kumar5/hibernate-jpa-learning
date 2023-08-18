package com.techchaggi.learning.spring.CruddemoApplication;


import com.techchaggi.learning.spring.CruddemoApplication.dao.StudentDAO;
import com.techchaggi.learning.spring.CruddemoApplication.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);

			// creating multiple students
			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple student
		System.out.println("Creating the student object....");
		Student tempStudent1 = new Student("Ryan","Gosling","ryan.gosling@gmail.com");
		Student tempStudent2 = new Student("John","Cena","john.cena@gmail.com");
		Student tempStudent3 = new Student("leo","caprio","leo.caprio@gmail.com");

		// save the student in database
		System.out.println("Saving the student.....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating the student object....");
		Student tempStudent = new Student("Aishwarya","Mathad","aish120796@gmail.com");

		// save the student
		System.out.println("Saving the student.....");
		studentDAO.save(tempStudent);

		// display the id of the student object
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}
}
