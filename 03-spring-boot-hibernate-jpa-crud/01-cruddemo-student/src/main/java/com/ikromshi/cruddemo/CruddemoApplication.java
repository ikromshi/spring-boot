package com.ikromshi.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ikromshi.cruddemo.dao.StudentDAO;
import com.ikromshi.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) { // spring will inject the bean; diff between repo, bean, and component
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// reaadStudent(studentDAO);
			// queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Ikrom", "Numonov", "email@ikromshi.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display ID of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create students
		System.out.println("Creating three student objects...");
		Student student1 = new Student("Ikrom", "Numonov", "email@ikromshi.com");
		Student student2 = new Student("John", "Doe", "john@doe@email.com");
		Student student3 = new Student("Mary", "Public", "mary@email.com");
		
		// save the students
		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void reaadStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating a student object...");
		Student student = new Student("Ikrom", "Numonov", "email@ikromshi.com");
		
		// save the student object
		System.out.println("Saving a student object...");
		studentDAO.save(student);

		// display the student object
		System.out.println("Saved student: " + student.getId());

		// retreive the student object based on the id: primary key
		System.out.println("Retreiving a student object with id: " + student.getId());
		Student tempStudent = studentDAO.findById(student.getId());
		
		// display the student object
		System.out.println("Retreived student: " + tempStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students;
		List<Student> theStudents = studentDAO.findByLastName("numonov");

		// display a list of students;

		for (Student student : theStudents) {
			System.out.println(student);
		}
	}
}
