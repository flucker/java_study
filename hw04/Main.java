package students;

public class Main {

	public static void main(String[] args) {
		StudentScanner studentScanner = new StudentScanner();
		Group group = studentScanner.createGroup();
		Student student1 = studentScanner.createStudent();
		
		try {
			group.addStudent(student1);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		System.out.println(group);
	}

}
