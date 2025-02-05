package students;

import java.util.Scanner;

public class StudentScanner {
	private final Scanner scanner;

	public StudentScanner() {
		super();
		scanner = new Scanner(System.in);
	}

	public Student createStudent() {
		String name = nameScanner();
		String lastName = lastNameScanner();
		Gender gender = genderScanner();
		int id = idScanner();
		Student student = new Student(name, lastName, gender, id);
		return student;
	}

	public Group createGroup() {
		String groupName = groupNameScanner();
		Group group = new Group(groupName);
		return group;
	}

	private String nameScanner() {
		System.out.println("Enter student name: ");
		String name = scanner.nextLine();
		emptyStringCheck(name);
		return name;
	}

	private String lastNameScanner() {
		System.out.println("Enter student last name: ");
		String lastName = scanner.nextLine();
		emptyStringCheck(lastName);
		return lastName;
	}

	private Gender genderScanner() {
		System.out.println("Enter student gender (MALE|FEMALE): ");
		String gender = scanner.nextLine();
		emptyStringCheck(gender);
		return Gender.valueOf(gender);
	}

	private int idScanner() {
		System.out.println("Enter student id: ");
		int id = scanner.nextInt();
		return id;
	}

	private String groupNameScanner() {
		System.out.println("Enter group name: ");
		String groupName = scanner.nextLine();
		emptyStringCheck(groupName);
		return groupName;
	}

	private void emptyStringCheck(String string) {
		if (string.isEmpty()) {
			throw new IllegalArgumentException("Empty value");
		}
	}

	@Override
	public String toString() {
		return "StudentScanner [scanner=" + scanner + "]";
	}
}
