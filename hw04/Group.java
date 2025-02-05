package students;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private String groupName;
	Student[] students;
	
	public Group(String groupName) {
		super();
		this.groupName = groupName;
		this.students = new Student[10];
	}

	public Group() {
		super();
		this.students = new Student[10];
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	@Override
	public String toString() {
		sortStudentsByLastName();
		return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";
	}
	
	public void addStudent(Student student) throws GroupOverflowException {
		if (student.getGroupName() != null) {
			if (student.getGroupName().equals(groupName)) {
				throw new IllegalArgumentException("Student already in current group");
			} else {
				throw new IllegalArgumentException("Student already in other group");				
			}
		}		
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				student.setGroupName(groupName);
				students[i] = student;
				return;
			}
		}
		throw new GroupOverflowException("Group is full");
	}
	
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getLastName().equals(lastName)) {
				return students[i];
			}		
		}
		throw new StudentNotFoundException("Student not found");
	}
	
	public boolean removeStudentByID(int id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getId() == id) {
				students[i].setGroupName(null);
				students[i] = null;
				return true;
			}		
		}
		return false;
	}
	
	private void sortStudentsByLastName() {
		Arrays.sort(students, Comparator.nullsLast(new StudentsLastNameComparator()));	
	}
}
