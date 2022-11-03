package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Student;
import app.repositories.StudentRepository;

@Component
public class TestComponent {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@PostConstruct
	public void init()
	{
		System.out.println("Testing");
		makeStudent("Tester", "do not email me ever.");
	}
	
	public void makeStudent(String name, String email) {
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		
		s = studentRepo.save(s);
	}
}
