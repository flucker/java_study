package hw03;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Group group = new Group("GROUP");
		Student student1 = new Student("Max", "Maxov", Gender.MALE, 0);
		Student student2 = new Student("Bob", "Bobov", Gender.MALE, 1);
		Student student3 = new Student("Tom", "Tomov", Gender.MALE, 2);
		Student student4 = new Student("Alex", "Alexov", Gender.MALE, 3);
		Student student5 = new Student("Carl", "Carlov", Gender.MALE, 4);
		
		try {
			group.addStudent(student1);
			group.addStudent(student2);
			group.addStudent(student3);
			group.addStudent(student4);
			group.addStudent(student5);
		} catch (GroupOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(group);
		
		try {
			System.out.println(group.searchStudentByLastName("Tomov"));
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(group.removeStudentByID(3));
	}

}
