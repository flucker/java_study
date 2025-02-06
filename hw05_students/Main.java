package students;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Group group = new Group("GROUP");
		Student student1 = new Student("Tom", "Tomov", Gender.MALE, 1);
		Student student2 = new Student("Ivan", "Ivanov", Gender.MALE, 2);
		Student student3 = new Student("Max", "Maxov", Gender.MALE, 3);
		Student student4 = new Student("Petr", "Petrov", Gender.MALE, 4);
		Student student5 = new Student("Sam", "Samov", Gender.MALE, 5);
		
		try {
			group.addStudent(student1);
			group.addStudent(student2);
			group.addStudent(student3);
			group.addStudent(student4);
			group.addStudent(student5);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		System.out.println(group);
		
		try {
			GroupFileStorage.saveGroupToCSV(group);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			File groupFile = GroupFileStorage.findFileByGroupName(group.getGroupName(), new File("."));
			System.out.println(groupFile.getName());
			Group group2 = GroupFileStorage.loadGroupFromCSV(groupFile);
			System.out.println(group2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
